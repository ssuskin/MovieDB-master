package net.suskin.moviedb.utilities;

import android.support.annotation.Nullable;

import net.suskin.moviedb.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


// a class to parse the movie details; but I changed my approach and am using the MovieListJson class instead.
// kept this one in case needed for details...but I don't think I need it anymore.

public class ParseMovieJSON {

    static JSONObject movieDbResults;


    static JSONObject page;
    static JSONObject totalResults;
    static JSONObject totalPages;

    static JSONObject results;
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

    static Movie theMovie;



    @Nullable
    public static Movie parseMovieResultsJson(String json) {
        try {
            movieDbResults = new JSONObject(json);

            page = movieDbResults.getJSONObject("page");
            totalResults = movieDbResults.getJSONObject("total_results");
            totalPages = movieDbResults.getJSONObject("total_pages");

            results = movieDbResults.getJSONObject("results");
            voteCount = results.getInt("vote_count");
            iD = results.getInt("id");
            video = results.getString("video");
            voteAverage = results.getInt("vote_average");
            title = results.getString("title");
            popularity = results.getDouble("popularity");
            posterPath = results.getString("poster_path");
            originalLanguage = results.getString("original_language");
            originalTitle = results.getString("original_title");

            genreIds = results.getJSONArray("genre_ids");
            genreIdList = (ArrayList) getListFromJSONArray(genreIds);

            backdropPath = results.getString("backdrop_path");
            adult = results.getString("adult");
            overview = results.getString("overview");
            releaseDate = results.getString("release_date");

            theMovie = new Movie(voteCount, iD, video, voteAverage, title, popularity, posterPath, originalLanguage, originalTitle, genreIdList, backdropPath, adult, overview, releaseDate);

            return theMovie;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<String> getListFromJSONArray(JSONArray jsonArray) throws JSONException {
        List<String> myList = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            String member = jsonArray.getString(i);
            myList.add(member);

        }
        return myList;
    }


}

