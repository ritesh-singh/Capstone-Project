
package com.example.riteshkumarsingh.capstone_stage2.data.models.movies;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MovieVideos {

    @SerializedName("id")
    private Long mId;
    @SerializedName("results")
    private List<VideoResult> mVideoResults;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<VideoResult> getVideoResults() {
        return mVideoResults;
    }

    public void setVideoResults(List<VideoResult> videoResults) {
        this.mVideoResults = videoResults;
    }
}
