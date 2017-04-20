
package com.example.riteshkumarsingh.capstone_stage2.data.models.configuration;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Images {

    @SerializedName("backdrop_sizes")
    private List<String> mBackdropSizes;
    @SerializedName("base_url")
    private String mBaseUrl;
    @SerializedName("logo_sizes")
    private List<String> mLogoSizes;
    @SerializedName("poster_sizes")
    private List<String> mPosterSizes;
    @SerializedName("profile_sizes")
    private List<String> mProfileSizes;
    @SerializedName("secure_base_url")
    private String mSecureBaseUrl;
    @SerializedName("still_sizes")
    private List<String> mStillSizes;

    public List<String> getBackdropSizes() {
        return mBackdropSizes;
    }

    public void setBackdropSizes(List<String> backdropSizes) {
        mBackdropSizes = backdropSizes;
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    public List<String> getLogoSizes() {
        return mLogoSizes;
    }

    public void setLogoSizes(List<String> logoSizes) {
        mLogoSizes = logoSizes;
    }

    public List<String> getPosterSizes() {
        return mPosterSizes;
    }

    public void setPosterSizes(List<String> posterSizes) {
        mPosterSizes = posterSizes;
    }

    public List<String> getProfileSizes() {
        return mProfileSizes;
    }

    public void setProfileSizes(List<String> profileSizes) {
        mProfileSizes = profileSizes;
    }

    public String getSecureBaseUrl() {
        return mSecureBaseUrl;
    }

    public void setSecureBaseUrl(String secureBaseUrl) {
        mSecureBaseUrl = secureBaseUrl;
    }

    public List<String> getStillSizes() {
        return mStillSizes;
    }

    public void setStillSizes(List<String> stillSizes) {
        mStillSizes = stillSizes;
    }

}
