package Compare;

import java.util.ArrayList;

public class MovieDB {
  ArrayList<Movie> movies = new ArrayList<Movie>();

  public MovieDB() {}

  public void addMovie(Movie movie) { movies.add(movie); }

  public ArrayList<Movie> getMovies() { return movies; }

  // .format(Date.parse("10/3/2022"))
  public void showMovies() {
    for (Movie movie : movies) {
      System.out.println(movie.toString());
    }
  }
}
