
package com.example.riteshkumarsingh.capstone_stage2.data.models.movies;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("genre_ids")
    private List<Long> mGenreIds;
    @SerializedName("id")
    private Long mId;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private Boolean mVideo;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("vote_count")
    private Long mVoteCount;
    @SerializedName("budget")
    private Long mBudget;
    @SerializedName("genres")
    private List<Genre> mGenreList;
    @SerializedName("homepage")
    private String mHomePage;
    @SerializedName("imdb_id")
    private Long mImdbId;
    @SerializedName("production_companies")
    private List<ProductionCompany> mProductionCompanyList;
    @SerializedName("production_countries")
    private List<ProductionCountry> mProductionCountryList;
    @SerializedName("revenue")
    private Long mRevenue;
    @SerializedName("runtime")
    private Long mRuntime;
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> mSpokenLanguageList;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("tagline")
    private String mTagLine;

    public Boolean getAdult() {
        return mAdult;
    }

    public void setAdult(Boolean adult) {
        mAdult = adult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public List<Long> getGenreIds() {
        return mGenreIds;
    }

    public void setGenreIds(List<Long> genreIds) {
        mGenreIds = genreIds;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        mOriginalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double popularity) {
        mPopularity = popularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public Long getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Long voteCount) {
        mVoteCount = voteCount;
    }

    public Long getBudget() {
        return mBudget;
    }

    public void setBudget(Long budget) {
        this.mBudget = budget;
    }

    public List<Genre> getGenreList() {
        return mGenreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.mGenreList = genreList;
    }

    public String getHomePage() {
        return mHomePage;
    }

    public void setHomePage(String homePage) {
        this.mHomePage = homePage;
    }

    public Long getImdbId() {
        return mImdbId;
    }

    public void setImdbId(Long imdbId) {
        this.mImdbId = imdbId;
    }

    public List<ProductionCompany> getProductionCompanyList() {
        return mProductionCompanyList;
    }

    public void setProductionCompanyList(List<ProductionCompany> productionCompanyList) {
        this.mProductionCompanyList = productionCompanyList;
    }

    public List<ProductionCountry> getProductionCountryList() {
        return mProductionCountryList;
    }

    public void setProductionCountryList(List<ProductionCountry> productionCountryList) {
        this.mProductionCountryList = productionCountryList;
    }

    public Long getRevenue() {
        return mRevenue;
    }

    public void setRevenue(Long revenue) {
        this.mRevenue = revenue;
    }

    public Long getRuntime() {
        return mRuntime;
    }

    public void setRuntime(Long runtime) {
        this.mRuntime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguageList() {
        return mSpokenLanguageList;
    }

    public void setSpokenLanguageList(List<SpokenLanguage> spokenLanguageList) {
        this.mSpokenLanguageList = spokenLanguageList;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getTagLine() {
        return mTagLine;
    }

    public void setmTagLine(String tagLine) {
        this.mTagLine = tagLine;
    }
}
