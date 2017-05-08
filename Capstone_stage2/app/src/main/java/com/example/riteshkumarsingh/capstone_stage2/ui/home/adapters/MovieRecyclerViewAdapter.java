package com.example.riteshkumarsingh.capstone_stage2.ui.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.bus.RxBus;
import com.example.riteshkumarsingh.capstone_stage2.constants.MovieSections;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Result;
import com.example.riteshkumarsingh.capstone_stage2.utils.ImageUtil;
import com.example.riteshkumarsingh.capstone_stage2.utils.UiUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public class MovieRecyclerViewAdapter extends
        RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private List<Result> mResults;
    private Context mContext;

    private String mMovieCategory;

    public MovieRecyclerViewAdapter(List<Result> results,@MovieSections String movieCategory) {
        this.mResults = results;
        this.mMovieCategory = movieCategory;
    }


    public void swap(List<Result> results){
        mResults = results;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_adapter_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = mResults.get(position);

        ImageUtil.getImageUtilInstance()
                .loadImage(mContext,
                        Utils.getImagePath(Utils.getPosterImageSize(UiUtils.getScreenDensity(mContext)),
                                result.getPosterPath()),
                        holder.mPosterImageView);

        holder.mPosterImageView.setTag(result.getId());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_poster)
        ImageView mPosterImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.iv_poster)
        public void onPosterClick(View view){
            StringBuilder stringBuilder = new StringBuilder(mMovieCategory);
            stringBuilder.append(";").append(view.getTag());
            RxBus.getInstance().send(stringBuilder.toString());
        }
    }
}
