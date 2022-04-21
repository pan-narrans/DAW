package Compare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
  String title;

  float rating;
  Date releaseDate;

  String director;

  public Movie(String title, float rating, String releaseDate, String director) throws ParseException {
    setTitle(title);
    setRating(rating);
    setReleaseDate(releaseDate);
    setDirector(director);
  }

  public String getTitle() { return title; }

  public void setTitle(String title) { this.title = title; }

  public float getRating() { return rating; }

  public void setRating(float rating) { this.rating = rating; }

  public String getReleaseDate() { return new SimpleDateFormat("yyyy").format(releaseDate); }

  public void setReleaseDate(String releaseDate) throws ParseException {
    this.releaseDate = new SimpleDateFormat("yyyy/MM/dd").parse(releaseDate);
  }

  public String getDirector() { return director; }

  public void setDirector(String director) { this.director = director; }

  public String toString() {
    StringBuilder movie = new StringBuilder();
    movie.append("Title: " + getTitle() + "\n");
    movie.append("Rating: " + getRating() + "\n");
    movie.append("Release Date: " + getReleaseDate() + "\n");
    movie.append("Director: " + getDirector() + "\n");
    return movie.toString();
  }

}
