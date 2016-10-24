package com.practice.android.moviehelper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class MovieDetailFragment extends Fragment {
    TextView mMovieTitle;
    ImageView mMoviePoster;
    RatingBar mRatingBar;
    TextView mPlotSynopsis;

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        Intent intent = getActivity().getIntent();

        mMovieTitle = (TextView)rootView.findViewById(R.id.movie_title_text);
        mMoviePoster = (ImageView)rootView.findViewById(R.id.movie_poster_image);
        mRatingBar = (RatingBar)rootView.findViewById(R.id.movie_ratingbar);
        mPlotSynopsis = (TextView)rootView.findViewById(R.id.plot_synopsis_body);

        String title = intent.getStringExtra(MovieGridFragment.EXTRA_MOVIE_TITLE);
        String date = intent.getStringExtra(MovieGridFragment.EXTRA_RELEASE_DATE);
        Bitmap posterMap = intent.getParcelableExtra(MovieGridFragment.EXTRA_POSTER_BITMAP);
        float rating = intent.getFloatExtra(MovieGridFragment.EXTRA_RATING, 0);
        String synopsis = intent.getStringExtra(MovieGridFragment.EXTRA_PLOT_SYNOPSIS);

        mMovieTitle.setText(title + " ( " + date + " )");
        mMoviePoster.setImageBitmap(posterMap);
        mRatingBar.setRating((rating/10)*5);
        mPlotSynopsis.setText(synopsis);

        return rootView;
    }
}
