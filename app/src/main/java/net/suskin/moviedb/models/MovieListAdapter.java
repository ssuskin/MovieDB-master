package net.suskin.moviedb.models;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.suskin.moviedb.R;
import net.suskin.moviedb.utilities.ParseMovieListJSON;

import java.util.List;


//started on some ideas for movie list adapter.  but need to figure out some other bugs first. not in use yet.

public class MovieListAdapter extends ArrayAdapter<MovieList> {
    private static final String LOG_TAG = MovieListAdapter.class.getSimpleName();

    public MovieListAdapter(Activity context, List<MovieList> movieResults) {

        super(context, 0, movieResults);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MovieList movieList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        ListView listResults = (ListView) convertView.findViewById(R.id.movieResults);
      //  listResults.setAdapter(ParseMovieListJSON.parseMovieSearch());

        return convertView;
    }
}
