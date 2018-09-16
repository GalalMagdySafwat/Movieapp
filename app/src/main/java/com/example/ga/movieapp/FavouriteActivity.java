package com.example.ga.movieapp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ga.movieapp.MovieContract.MovieEntry;


public class FavouriteActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int FAVOURITES_LOADER_ID = 31;

    MovieCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        GridView FavoritesGridView = (GridView) findViewById(R.id.favouriteList);

        mAdapter = new MovieCursorAdapter(this, null);

        FavoritesGridView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(FAVOURITES_LOADER_ID, null, this);
        FavoritesGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor currentCursor = mAdapter.getCursor();
                currentCursor.moveToPosition(position);
                String title = currentCursor.getString(currentCursor.getColumnIndexOrThrow(MovieEntry.COLUMN_MOVIE_ORIGINAL_TITLE));
                String title1 = currentCursor.getString(currentCursor.getColumnIndexOrThrow(MovieEntry.COLUMN_MOVIE_OVERVIEW));
                String title2 = currentCursor.getString(currentCursor.getColumnIndexOrThrow(MovieEntry.COLUMN_MOVIE_USER_RATING));
                String title3 = currentCursor.getString(currentCursor.getColumnIndexOrThrow(MovieEntry.COLUMN_MOVIE_RELEASE_DATE));
                String title4 = currentCursor.getString(currentCursor.getColumnIndexOrThrow(MovieContract.MovieEntry.COLUMN_MOVIE_POSTER));
                String movieid = currentCursor.getString(currentCursor.getColumnIndexOrThrow(MovieEntry.COLUMN_MOVIE_ID));


                launchDetailActivity(title, title1, title2, title3, title4, movieid);


            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Uri favoritesQueryUri = MovieContract.MovieEntry.CONTENT_URI;

        return new CursorLoader(this,
                favoritesQueryUri,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mAdapter.changeCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.changeCursor(null);
    }

    private void launchDetailActivity(String title, String title1, String title2, String title3, String title4, String movieid) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);

        intent.putExtra("title", title);
        intent.putExtra("overView", title1);
        intent.putExtra("UserRating", title2);
        intent.putExtra("ReleaseDate", title3);
        intent.putExtra("MoviePoster", title4);
        intent.putExtra("MovieID", movieid);


        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
