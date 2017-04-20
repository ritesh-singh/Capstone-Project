
package com.example.riteshkumarsingh.capstone_stage2.data.models.configuration;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Configuration {

    @SerializedName("change_keys")
    private List<String> mChangeKeys;
    @SerializedName("images")
    private Images mImages;

    public List<String> getChangeKeys() {
        return mChangeKeys;
    }

    public void setChangeKeys(List<String> changeKeys) {
        mChangeKeys = changeKeys;
    }

    public Images getImages() {
        return mImages;
    }

    public void setImages(Images images) {
        mImages = images;
    }

}
