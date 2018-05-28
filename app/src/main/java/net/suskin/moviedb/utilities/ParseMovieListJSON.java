package net.suskin.moviedb.utilities;

import net.suskin.moviedb.models.MovieList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseMovieListJSON {

    // TODO: implement class that will parse the JSON from MovieDB API and return an ArrayList

    static JSONObject movieDbResults;


//    static JSONObject page;
//    static JSONObject totalResults;
//    static JSONObject totalPages;

    static int page;
    static int totalResults;
    static int totalPages;

    static JSONArray results;
    static int voteCount;
    static int iD;
    static String video;
    static int voteAverage;
    static String title;
    static double popularity;
    static String posterPath;
    static String originalLanguage;
    static String originalTitle;

    static JSONArray genreIds;
    static List<String> genreIdList;

    static String backdropPath;
    static String adult;
    static String overview;
    static String releaseDate;

   // static MovieList theMovies;
   // static MovieList theMovieList;
    static ArrayList myMovieList;



    public static ArrayList parseMovieSearch(String json) {

        try {
            movieDbResults = new JSONObject(json);
            myMovieList = new ArrayList();

            page = movieDbResults.getInt("page");
            totalResults = movieDbResults.getInt("total_results");
            totalPages = movieDbResults.getInt("total_pages");

            results = movieDbResults.getJSONArray("results");

            //looping through results
            for (int i = 0; i < results.length(); i++) {
                JSONObject r = results.getJSONObject(i);

                /*
                voteCount = r.getInt("vote_count");
                iD = r.getInt("id");
                video = r.getString("video");
                voteAverage = r.getInt("vote_average");
                title = r.getString("title");
                popularity = r.getDouble("popularity");

                */
                posterPath = r.getString("poster_path");

                /*
                originalLanguage = r.getString("original_language");
                originalTitle = r.getString("original_title");

                genreIds = r.getJSONArray("genre_ids");
                genreIdList = (ArrayList) getMovieInfoFromJSONArray(genreIds);

                backdropPath = r.getString("backdrop_path");
                adult = r.getString("adult");
                overview = r.getString("overview");
                releaseDate = r.getString("release_date");
                */

                // adding each movie to the movie list
                myMovieList.add(posterPath);

            }

            return myMovieList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<String> getMovieInfoFromJSONArray(JSONArray jsonArray) throws JSONException {
        List<String> myList = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            String member = jsonArray.getString(i);
            myList.add(member);

        }
        return myList;
    }









}
