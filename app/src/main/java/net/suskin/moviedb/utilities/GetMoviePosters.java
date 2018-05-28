package net.suskin.moviedb.utilities;

// https://developers.themoviedb.org/3/getting-started/images

/*
 examples: note; no api key required

  http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
  http://image.tmdb.org/t/p/w185/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg
  http://image.tmdb.org/t/p/w342/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg
  http://image.tmdb.org/t/p/original/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg

configuration:
https://api.themoviedb.org/3/configuration?api_key=yourKeyHere

      All of the available poster sizes
      "w92",
      "w154",
      "w185",
      "w342",
      "w500",
      "w780",
      "original"
 */

import android.media.Image;
import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

// TODO: implement a class to take the movie poster URL and get the actual image.


public class GetMoviePosters {

    private static String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
    private static String POSTER_SIZE_185 = "w185/";
    private static String POSTER_SIZE_500 = "w500/";


    // Medium size poster
    public static URL buildPosterMedium(String posterPath) {
        String posterURL = POSTER_BASE_URL + POSTER_SIZE_185 + posterPath;

        Uri posterUri = Uri.parse(posterURL).buildUpon().build();

        URL url = null;
        try {
            url = new URL(posterUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    //large size poster
    public static URL buildPosterLarge(String posterPath) {

        String posterURL = POSTER_BASE_URL + POSTER_SIZE_500 + posterPath;

        Uri posterUri = Uri.parse(posterURL).buildUpon().build();

        URL url = null;
        try {
            url = new URL(posterUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;

    }

}

