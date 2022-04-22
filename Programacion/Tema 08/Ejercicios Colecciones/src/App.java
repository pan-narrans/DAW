import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import Baloncesto.Selector;
import Compare.Movie;
import Compare.MovieDB;
import SimpleCollection.Cola;
import SimpleCollection.Pila;
import SimpleCollection.SimpleCollectionManager;

public class App {
  public static void main(String[] args) throws Exception {
    // baloncesto();
    // compare();
    collection();
  }

  // #region Stack & Queue
  public static void collection() {
    // ==============
    // PILA
    // ==============

    Pila pila = new Pila();
    pila.add("objeto 1");
    pila.add("objeto 2");
    pila.add("objeto 3");
    pila.add("objeto 4");

    System.out.println("To String: ");
    System.out.println(pila.toString());

    System.out.print("Get First: ");
    System.out.println(pila.getFirst());

    System.out.print("Extract: ");
    System.out.println(pila.extract());

    System.err.print("Get First: ");
    System.out.println(pila.getFirst());

    System.out.println("\n=====\n");

    // ==============
    // COLA
    // ==============

    Cola cola = new Cola();
    cola.add("objeto 1");
    cola.add("objeto 2");
    cola.add("objeto 3");
    cola.add("objeto 4");

    System.out.print("To String: ");
    System.out.println(cola.toString());

    System.out.print("Get First: ");
    System.out.println(cola.getFirst());

    System.out.print("Extract: ");
    System.out.println(cola.extract());

    System.out.print("Get First: ");
    System.out.println(cola.getFirst());

    System.out.println("\n=====\n");

    // ==============
    // MAIN
    // ==============
    SimpleCollectionManager manager = new SimpleCollectionManager();

    System.out.println("Test manager con cola:");
    manager.printAndEmpty(cola);
    manager.fill(cola);
    manager.printAndEmpty(cola);
    System.out.println("\n=====\n");

    System.out.println("Test manager con pila:");
    manager.printAndEmpty(pila);
    manager.fill(pila);
    manager.printAndEmpty(pila);
  }
  // #endregion

  // #region Compare

  public static void compare() {
    MovieDB db = new MovieDB();

    Comparator<Movie> byRating = (Movie m1, Movie m2) -> m1.getRating() < m2.getRating() ? 1 : -1;
    Comparator<Movie> byName = (Movie m1, Movie m2) -> m1.getTitle().compareTo(m2.getTitle());

    try {
      db.addMovie(new Movie("The Shawshank Redemption", 9.3f, "1994/10/14", "Frank Darabont"));
      db.addMovie(new Movie("The Godfather", 9.2f, "1972/3/24", "Francis Ford Coppola"));
      db.addMovie(new Movie("The Godfather:  Part II", 9.0f, "1974/12/20", "Francis Ford Coppola"));
      db.addMovie(new Movie("The Dark Knight", 8.7f, "2008/7/18", "Christopher Nolan"));
      db.addMovie(new Movie("12 Angry Men", 9.0f, "1999/10/20", "Spike Lee"));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    db.showMovies();
    System.out.println("===========");

    Collections.sort(db.getMovies(), byRating);

    db.showMovies();
    System.out.println("===========");

    Collections.sort(db.getMovies(), byName);

    db.showMovies();
  }

  // #endregion

  // #region Baloncesto

  public static void baloncesto() {
    Selector agencia = new Selector();

    agencia.addJugador("Pedro", 19, "Los Lakers", 10, "Madrid");
    agencia.addJugador("Ramona", 25, "Los Otros", 19, "Madrid");
    agencia.addJugador("María", 20, "Los Lakers", 15, "Barcelona");
    agencia.addJugador("Ricardo", 21, "Los Lakers", 0, "Canarias");
    agencia.addJugador("Pablo", 21, "Los Lakers", 4, "Canarias");
    agencia.addJugador("Elena", 21, "Los Lakers", 40, "Canarias");

    System.out.println("\n=== Cambiar las canastas de Pedro ===");
    System.out.println(agencia.lookUpJugador("Pedro"));
    agencia.cambiarCanastas("Pedro", 20);
    System.out.println(agencia.lookUpJugador("Pedro"));

    System.out.println("\n=== Todos los jugadores ===");
    agencia.imprimirJugadores();

    System.out.println("\n=== Todos los jugadores por ciudad ===");
    agencia.imprimirJugadoresPorCiudad();

    System.out.println("\n=== Todos los jugadores por nombre ===");
    agencia.imprimirJugadoresPorNombre();

    System.out.println("\n=== Todos los jugadores de Madrid ===");
    System.out.println(Arrays.toString(agencia.lookUpJugadores("Madrid")));

    System.out.println("\n=== Quitar jugadores con 5 < nCanastas < 20 ===");
    agencia.eliminarPorCanastas(5, 20);
    agencia.imprimirJugadores();

    System.out.println("\n=== Eliminar todo ===");
    agencia.resetJugadores();
    agencia.imprimirJugadores();

    System.out.println("\n=== Añadir duplicados ===");
    agencia.addJugador("Pedro", 19, "Los Lakers", 10, "Madrid");
    agencia.addJugador("Pedro", 19, "Los Lakers", 10, "Madrid");
  }

  // #endregion

}