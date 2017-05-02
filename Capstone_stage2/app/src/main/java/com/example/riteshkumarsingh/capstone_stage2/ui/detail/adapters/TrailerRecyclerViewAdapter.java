package com.example.riteshkumarsingh.capstone_stage2.ui.detail.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.VideoResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by riteshkumarsingh on 02/05/17.
 */

public class TrailerRecyclerViewAdapter
        extends RecyclerView.Adapter<TrailerRecyclerViewAdapter.ViewHolder> {

    List<VideoResult> mMovieVideoResults;

    public TrailerRecyclerViewAdapter(List<VideoResult> resultList) {
        this.mMovieVideoResults = resultList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trailer_adadpter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoResult result = mMovieVideoResults.get(position);

        holder.mTrailerName.setText(result.getName());
        holder.mTrailerType.setText(result.getType());
        holder.mTrailerPlayButton.setTag(result.getKey());
    }

    @Override
    public int getItemCount() {
        return mMovieVideoResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView mTrailerName;

        @BindView(R.id.tv_type)
        TextView mTrailerType;

        @BindView(R.id.iv_play_button)
        ImageView mTrailerPlayButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.iv_play_button)
        public void onPlayButtonClick(View view){

        }
    }
}
