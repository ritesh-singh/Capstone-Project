package com.example.riteshkumarsingh.capstone_stage2.data.models.movies;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by riteshkumarsingh on 02/05/17.
 */

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class VideoResult {
    @SerializedName("id")
    private String mId;
    @SerializedName("iso_639_1")
    private String mIso639_1;
    @SerializedName("iso_3166_1")
    private String mIso_3166_1;
    @SerializedName("key")
    private String mKey;
    @SerializedName("name")
    private String mName;
    @SerializedName("site")
    private String mSite;
    @SerializedName("size")
    private String mSize;
    @SerializedName("type")
    private String mType;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getIso639_1() {
        return mIso639_1;
    }

    public void setIso639_1(String iso639_1) {
        this.mIso639_1 = iso639_1;
    }

    public String getIso_3166_1() {
        return mIso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.mIso_3166_1 = iso_3166_1;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        this.mKey = key;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getSite() {
        return mSite;
    }

    public void setSite(String site) {
        this.mSite = site;
    }

    public String getSize() {
        return mSize;
    }

    public void setSize(String size) {
        this.mSize = size;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        this.mType = type;
    }
}
