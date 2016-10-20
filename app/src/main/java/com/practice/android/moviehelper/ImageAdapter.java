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

    private Context mContext;
    private LinkedList<String> mThumbUrls = new LinkedList<>();
    private LinkedList<Bitmap> mThumbBits = new LinkedList<>();
    //private LinkedList<Long> mThumbIds = new LinkedList<>();



    public ImageAdapter(Context c){
        mContext=c;
    }

    public void add(String url){
        mThumbUrls.add(url);
        FetchImageTask fetchImage = new FetchImageTask();
        fetchImage.execute(url);
    }

    public void clear(){
        mThumbUrls.clear();
    }
    public int getCount(){
        return mThumbUrls.size();
    }

    public Object getItem(int position){
        ImageView img = new ImageView(mContext);
        return mThumbUrls.get(position);
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
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageBitmap(mThumbBits.get(position));
        }
        else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(position);

        return imageView;
    }


    public class FetchImageTask extends AsyncTask<String, Void, Bitmap> {

        private final String BASE_URL = "https://image.tmdb.org/t/p/w500/";
        private final String LOG_TAG = FetchImageTask.class.getSimpleName();
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bmp = null;

            try {
                URL url = new URL(BASE_URL + params[0]);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }catch(IOException e){
                Log.e(LOG_TAG, "Error: ", e);
                return null;
            }
            finally{
                return bmp;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bmp) {
            super.onPostExecute(bmp);
            mThumbBits.add(bmp);

        }
    }

}
