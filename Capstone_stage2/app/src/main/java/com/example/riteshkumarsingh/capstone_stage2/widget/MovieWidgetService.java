package com.example.riteshkumarsingh.capstone_stage2.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.riteshkumarsingh.capstone_stage2.BasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.DaggerBasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.MainApplication;
import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Result;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetPopularMovies;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.UiUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;


/**
 * Created by riteshkumarsingh on 08/05/17.
 */

public class MovieWidgetService extends RemoteViewsService {

    @Inject
    GetPopularMovies getPopularMovies;

    private BasicUseCaseComponents mBasicUseCaseComponents;

    private void initDagger(){
        mBasicUseCaseComponents = DaggerBasicUseCaseComponents.builder()
                .appComponent(((MainApplication) getApplication()).getAppComponent())
                .build();

        mBasicUseCaseComponents.plus(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBasicUseCaseComponents = null;
    }

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteViewsFactory() {
            private List<Result> resultList;
            private Subscription mPopularSubscription;
            private Context context;
            @Override
            public void onCreate() {
                context = getApplicationContext();
            }

            @Override
            public void onDataSetChanged() {
                if (resultList != null){
                    RxUtils.unSubscribe(mPopularSubscription);
                    resultList.clear();
                }

                final long identityToken = Binder.clearCallingIdentity();

                if (UiUtils.isNetworkActive(context)){
                    getPopularMovies.setIsFromRemote(true);
                }else{
                    getPopularMovies.setIsFromRemote(false);
                }

                mPopularSubscription = getPopularMovies.getMovies(Utils.getMovieOptions("1"))
                        .subscribe(movies -> {
                            resultList = movies.getResults();
                        },throwable -> {

                        });

                Binder.restoreCallingIdentity(identityToken);
            }

            @Override
            public void onDestroy() {
                if (resultList != null) {
                    RxUtils.unSubscribe(mPopularSubscription);
                    resultList.clear();
                    resultList = null;
                }
            }

            @Override
            public int getCount() {
                return resultList == null ? 0 : resultList.size();
            }

            @Override
            public RemoteViews getViewAt(int position) {
                if (position == AdapterView.INVALID_POSITION ||
                        resultList == null || resultList.size() == 0) {
                    return null;
                }

                Result result = resultList.get(position);

                RemoteViews views = new RemoteViews(getPackageName(), R.layout.list_movie_item);

                try {
                    Bitmap b = Picasso.with(context)
                            .load(Utils.getImagePath(Utils.getPosterImageSize(UiUtils.getScreenDensity(context)),
                                            result.getPosterPath()))
                            .get();
                    views.setImageViewBitmap(R.id.iv_poster, b);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                views.setTextViewText(R.id.iv_movie_name,result.getTitle());

                return views;

            }

            @Override
            public RemoteViews getLoadingView() {
                return null;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
        };
    }
}
