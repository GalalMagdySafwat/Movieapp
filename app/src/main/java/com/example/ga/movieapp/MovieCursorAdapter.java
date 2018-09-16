package com.example.ga.movieapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import com.example.ga.movieapp.MovieContract.MovieEntry;


import com.squareup.picasso.Picasso;



public class MovieCursorAdapter extends CursorAdapter {

    private Context context;

    public MovieCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        this.context = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.favourite_list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView favourite = (ImageView) view.findViewById(R.id.image_f);

        String poster = cursor.getString(cursor.getColumnIndexOrThrow(MovieContract.MovieEntry.COLUMN_MOVIE_POSTER));

        Picasso.with(context)
                .load(poster)
                .into(favourite);
    }
}