package com.practice.android.moviehelper;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

/**
 * Created by zale on 10/21/16.
 */

public class MovieDetail {
    private final String LOG_TAG = MovieDetail.class.getSimpleName();

    private Bitmap mThumbnail;
    private String mUrl;
    private String mTitle;
    private String mReleaseDate;
    private float mVoteAverage;
    private String mPlotSynopsis;


    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getPlotSynopsis() {
        return mPlotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        mPlotSynopsis = plotSynopsis;
    }
}
