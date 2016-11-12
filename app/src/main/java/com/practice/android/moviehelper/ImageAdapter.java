package com.practice.android.moviehelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import static android.support.v7.appcompat.R.styleable.View;

/**
 * Created by zale on 10/20/16.
 */

public class ImageAdapter extends BaseAdapter {

    private final String LOG_TAG = ImageAdapter.class.getSimpleName();
    private Context mContext;
    private LinkedList<MovieDetail> mMovies = new LinkedList<>();



    public ImageAdapter(Context c){
        mContext=c;
    }

    public void add(MovieDetail movie){
        mMovies.add(movie);
    }

    public void clear(){
        mMovies.clear();
    }
    public int getCount(){
        return mMovies.size();
    }

    public Object getItem(int position){
        return mMovies.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    //create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;

        if(convertView == null) {
            //if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(mMovies.get(position).getThumbnail());
        return imageView;
    }
}
