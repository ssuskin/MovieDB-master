package net.suskin.moviedb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.suskin.moviedb.utilities.MovieDBConnect;
import net.suskin.moviedb.utilities.ParseMovieListJSON;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    //api key for movieDB comes from res/values/apiKeys.xml
    String myApiKey = null;

    String SORT_BY_POPULARITY = "popularity.desc";
    String SORT_BY_RATING = "vote_average.desc";
    String sortBy = SORT_BY_POPULARITY;



    TextView urlDisplay;
    ListView resultsDisplay;

    // ArrayList<String> movieList;
     String movieDbResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null || !savedInstanceState.containsKey("movies")) {
            // movieList = new ArrayList<Movie>(Arrays.asList(movies));
            ArrayList movieList = new ArrayList<>();
        } else {
            ArrayList movieList = savedInstanceState.getParcelableArrayList("movies");

        }

        setContentView(R.layout.activity_main);
        urlDisplay = (TextView) findViewById(R.id.movieDBUrl);
        resultsDisplay = (ListView) findViewById(R.id.movieResults);
        myApiKey = getString(R.string.movieDbApiKey);


      //  movieList = ParseMovieListJSON.parseMovieSearch(movieDbResults);


     //   ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movieList);
   //     resultsDisplay.setAdapter(adapter);

    }

    public void findMyMovies(String apiKey) {

        URL movieSearchUrl = MovieDBConnect.buildMovieDBUrl(apiKey, sortBy);
        urlDisplay.setText(movieSearchUrl.toString());

         String res = String.valueOf(new QueryMovieDB().execute(movieSearchUrl));
     //   movieList = ParseMovieListJSON.parseMovieSearch(res);


      //  ArrayAdapter<String> movieAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieList);
       // resultsDisplay = (ListView) findViewById(R.id.movieResults);
       // resultsDisplay.setAdapter(movieAdapter);
    }

    public class QueryMovieDB extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {

            URL movieDbUrl = urls[0];
         //   movieDbResults = null;
          //  movieList = null;
            try {
                movieDbResults = MovieDBConnect.getResponseFromMovieDB(movieDbUrl);

                //TODO: take this out after debugging
                Log.i("ApiResponse", Arrays.toString(new String[]{movieDbResults}));

                //movieList = ParseMovieListJSON.parseMovieSearch(movieDbResults);

            } catch (IOException e) {
                e.printStackTrace();
            }

           // return null;  //doesn't error but doesn't seem to pass the movieDBResults to on
                          // post execute
            //TODO: why does this give a null pointer error if I return movieDBResults
            return movieDbResults;
            //return movieList;
        }

        // will cancel the network operation if no network connectivity
        @Override
        protected void onPreExecute() {
            // TODO: add something here to check network using CheckForActiveNetwork class
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String movieDbResults) {
            if (movieDbResults != null && !movieDbResults.equals("")) {

                ArrayList posterPaths = ParseMovieListJSON.parseMovieSearch(movieDbResults);
                //TODO: take this out after debugging
                Log.i("MovieList", Arrays.toString(new ArrayList[]{posterPaths}));

                ArrayAdapter<String> movieAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, posterPaths);
                resultsDisplay.setAdapter(movieAdapter);



            }

             //  movieList = ParseMovieListJSON.parseMovieSearch(movieDbResults);




            }

            //  private void loadMyPosters() {


        }
        /*
           Picasso.with(this)
                .load(sandwich.getImage())
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(ingredientsIv);

                docs: http://square.github.io/picasso/
         */
        //   }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicked = item.getItemId();

        if (itemClicked == R.id.action_getPopular) {
            sortBy = SORT_BY_POPULARITY;
            return true;
        }

        if (itemClicked == R.id.action_getRated) {
            sortBy = SORT_BY_RATING;
            return true;
        }

        if (itemClicked == R.id.action_getMovies) {
            findMyMovies(myApiKey);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
