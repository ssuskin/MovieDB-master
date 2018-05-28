package net.suskin.moviedb.utilities;

// Sample url:  https://api.themoviedb.org/3/discover/movie?api_key=myKeyHere&language=en-US&sort_by=popularity.asc&include_adult=false&include_video=false&page=1

import android.net.Uri;

import net.suskin.moviedb.R;

import java.net.URL;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;

// TODO: build the URL for the movieDBAPI

public class MovieDBConnect {


    private static String MOVIEDB_BASE_URL = "https://api.themoviedb.org/3/discover/movie";

    private static String API_KEY_PARM = "api_key";

    private static String LANGUAGE_PARM = "language";
    private static String LANGUAGE_VALUE = "en-US";

    private static String SORTBY_PARM = "sort_by";
    //private static String SORTBY_VALUE = "popularity.asc";

    private static String INCLUDE_ADULT_PARM = "include_adult";
    private static String INCLUDE_ADULT_VALUE = "false";

    private static String INCLUDE_VIDEO_VALUE = "include_video";
    private static String INCLUDE_VIDEO_PARM = "false";

    private static String PAGE_PARM = "page";
    private static String PAGE_VALUE = "1";

    public static URL buildMovieDBUrl(String apiKey, String sortValue) {
        Uri movieUri = Uri.parse(MOVIEDB_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY_PARM, apiKey)
                .appendQueryParameter(LANGUAGE_PARM, LANGUAGE_VALUE)
                .appendQueryParameter(SORTBY_PARM, sortValue)
                .appendQueryParameter(INCLUDE_ADULT_PARM, INCLUDE_ADULT_VALUE)
                .appendQueryParameter(INCLUDE_VIDEO_PARM, INCLUDE_VIDEO_VALUE)
                .appendQueryParameter(PAGE_PARM, PAGE_VALUE)
                .build();

        URL url = null;
        try {
            url = new URL(movieUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromMovieDB(URL url) throws IOException {
        HttpURLConnection movieDbConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream inputStream = movieDbConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

            boolean inputExists = scanner.hasNext();
            if (inputExists) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            movieDbConnection.disconnect();
        }
    }
}
