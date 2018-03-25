package com.example.ga.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_d);
        Intent intent=getIntent();
        String ReceiveTitle =intent.getStringExtra("title");
        String ReceiveOverView =intent.getStringExtra("overView");
        String ReceiveRating =intent.getStringExtra("UserRating");
        String ReceiveDate =intent.getStringExtra("ReleaseDate");
        String ReceivePoster =intent.getStringExtra("MoviePoster");



        TextView MovieName=(TextView)findViewById(R.id.MovieName);
        MovieName.setText(ReceiveTitle);
        TextView MovieOverView=(TextView)findViewById(R.id.overview);
        MovieOverView.setText(ReceiveOverView);
        TextView MovieRating=(TextView)findViewById(R.id.rating);
        MovieRating.setText(ReceiveRating);
        TextView MovieDate=(TextView)findViewById(R.id.date);
        MovieDate.setText(ReceiveDate);
        ImageView MoviePoster =(ImageView)findViewById(R.id.poster);
        Picasso.with(this)
                .load(ReceivePoster)
                .into(MoviePoster);

    }
}
