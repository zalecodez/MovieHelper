package com.practice.android.moviehelper;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zale on 10/20/16.
 */

public class FetchMovies extends AsyncTask<Void, Void, Void> {

    private final String LOG_TAG = FetchMovies.class.getSimpleName();

    private final String BASE_URL = "https://api.themoviedb.org/3/discover/movie?";
    private String mApi_key = "3d04589b5c416163f71c3d8ef4c97301";
    private String mLanguage = "en-US";
    private String mSort_by = "popularity.desc";
    private boolean mInclude_adult = false;
    private boolean mInclude_video = false;
    private int mPage = 1;

    private String mJsonResponse;

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected Void doInBackground(Void... params) {

        BufferedReader reader = null;
        HttpURLConnection urlConnection = null;

        try {
            Uri path = Uri.parse(BASE_URL).buildUpon()
                    .appendQueryParameter("api_key", mApi_key)
                    .appendQueryParameter("language", mLanguage)
                    .appendQueryParameter("sort_by", mSort_by)
                    .appendQueryParameter("include_adult", Boolean.toString(mInclude_adult))
                    .appendQueryParameter("include_video", Boolean.toString(mInclude_video))
                    .appendQueryParameter("page", Integer.toString(mPage))
                    .build();

            Log.v("FetchMovies", path.toString());

            URL url = new URL(path.toString());

            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            InputStream inputStream = urlConnection.getInputStream();

            StringBuffer buffer = new StringBuffer();

            if(inputStream == null)
                return null;


            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = reader.readLine()) != null){
                buffer.append(line+"\n");
            }

            if(buffer.length() != 0){
                return null;
            }

            mJsonResponse = buffer.toString();
        }
        catch(IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            return null;// no point in attempting to parse movie data
            // if the code didn't successfully retrieve it.
        }
        finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }

            if(reader != null){
                try {
                    reader.close();
                }catch(final IOException e){
                    Log.e(LOG_TAG, "Error closing reader: ", e);
                }
            }
        }

        return null;
    }
}
