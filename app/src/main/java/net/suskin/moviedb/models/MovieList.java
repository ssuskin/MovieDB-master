package net.suskin.moviedb.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

// parcelable class for passing the movie list.

public class MovieList implements Parcelable{

    //https://developers.themoviedb.org/3/discover/movie-discover
    int voteCount;
    int id;
    String video;
    int voteAverage;
    String title;
    double popularity;
    String posterPath;
    String originalLanguage;
    String originalTitle;

    List<String> genreIDs;

    String backdropPath;
    String adult;
    String overview;
    String releaseDate;



    public MovieList(int voteCount, int iD, String video, int voteAverage, String title,
                     double popularity, String posterPath, String originalLanguage,
                     String originalTitle, List<String> genreIdList, String backdropPath,
                     String adult, String overview, String releaseDate) {

        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIDs = genreIDs;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;

    }

    protected MovieList(Parcel in) {
        voteCount = in.readInt();
        id = in.readInt();
        video = in.readString();
        voteAverage = in.readInt();
        title = in.readString();
        popularity = in.readInt();
        posterPath = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();

        in.readStringList(genreIDs);
        backdropPath = in.readString();
        adult = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return title + " " + releaseDate;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(voteCount);
        parcel.writeInt(id);
        parcel.writeString(video);
        parcel.writeInt(voteAverage);
        parcel.writeString(title);
        parcel.writeDouble(popularity);
        parcel.writeString(posterPath);
        parcel.writeString(originalLanguage);
        parcel.writeString(originalTitle);
        parcel.writeStringList(genreIDs);
        parcel.writeString(backdropPath);
        parcel.writeString(adult);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
    }

    public static final Parcelable.Creator<MovieList> CREATOR = new Parcelable.Creator<MovieList>() {
        @Override
        public MovieList createFromParcel(Parcel parcel) {
            return new MovieList(parcel);
        }

        @Override
        public MovieList[] newArray(int i) {
            return new MovieList[i];
        }
    };

}