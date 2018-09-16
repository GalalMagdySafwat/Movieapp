package com.example.ga.movieapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;



public class ReviewsAndVideosLoader extends AsyncTaskLoader {

    private static final String  LOG_TAG = ReviewsAndVideosLoader.class.getName();
    private  String mUrl;

    public ReviewsAndVideosLoader(Context context, String url) {
        super(context);
        mUrl=url;
    }
    protected void onStartLoading(){forceLoad();}

    @Override
    public Movie loadInBackground() {

        if (mUrl==null) {

            return null;

        }

        Movie movie = new Movie();

        List<Reviews> reviews= MovieUtils.fetchReviewsData(mUrl);

        List<Videos> videos= MovieUtils.fetchVideosData(mUrl);

        movie.setReviews(reviews);
        movie.setVideos(videos);

        return movie;

    }

}
