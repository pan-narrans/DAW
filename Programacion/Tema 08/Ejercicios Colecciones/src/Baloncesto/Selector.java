package Baloncesto;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Selector {
  ArrayList<Jugador> jugadores;

  public Selector() {
    resetJugadores();
  }

  public void addJugador(
      String nombre,
      int edad,
      String nombreEquipo,
      int numCanastasIntroducidas,
      String ciudad) {
    if (lookUpJugador(nombre) == null)
      jugadores.add(new Jugador(nombre, edad, nombreEquipo, numCanastasIntroducidas, ciudad));
    else
      System.out.println("Ese jugador ya existe.");
  }

  /**
   * Busca un jugador concreto por nombre.
   * 
   * @param nombre del jugador.
   * @return El primer Jugador cuyo nombre coincida con el introducido.
   */
  public Jugador lookUpJugador(String nombre) {
    return jugadores
        .stream()
        .filter(jugador -> jugador.getNombre().equals(nombre))
        .findFirst()
        .orElse(null);
  }

  /**
   * Busca un grupo de jugadores por ciudad.
   * 
   * @param ciudad de los jugadores.
   * @return Array de Jugadores cuya ciudad coincida con la introducida.
   */
  public Jugador[] lookUpJugadores(String ciudad) {
    return jugadores
        .stream()
        .filter(jugador -> jugador.getCiudad().equals(ciudad))
        .toArray(Jugador[]::new);
  }

  /**
   * Cambia el número de canastas introducidas por un jugador.
   * 
   * @param nombre    del jugador.
   * @param nCanastas introducidas por el jugador.
   */
  public void cambiarCanastas(String nombre, int nCanastas) {
    lookUpJugador(nombre).setNumCanastasIntroducidas(nCanastas);
  }

  /**
   * Elimina a todos los jugadores cuyo número de canastas introducidas sea menor
   * al mínimo y superior al máximo.
   * <p>
   * min < nº canastas < max
   * 
   * @param nCanastasMin
   * @param nCanastasMax
   */
  public void eliminarPorCanastas(int nCanastasMin, int nCanastasMax) {
    jugadores = jugadores.stream()
        .filter(jugador -> jugador.getNumCanastasIntroducidas() > nCanastasMin)
        .filter(jugador -> jugador.getNumCanastasIntroducidas() < nCanastasMax)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  /**
   * Imprime todos los jugadores contenidos dentro de la base de datos.
   */
  public void imprimirJugadores() {
    if (jugadores.size() == 0)
      System.out.println("No hay jugadores.");
    else
      jugadores.stream()
          .forEach(jugador -> System.out.println(jugador));
  }

  public void imprimirJugadoresPorCiudad() {
    if (jugadores.size() == 0)
      System.out.println("No hay jugadores.");
    else
      jugadores.stream()
          .sorted((j1, j2) -> j1.getCiudad().compareTo(j2.getCiudad()))
          .forEach(System.out::println);
  }

  public void imprimirJugadoresPorNombre() {
    if (jugadores.size() == 0)
      System.out.println("No hay jugadores.");
    else
      jugadores.stream()
          .sorted(Jugador::compareByName)
          .forEach(System.out::println);
  }

  /** Reinicia la lista de jugadores. */
  public void resetJugadores() {
    jugadores = new ArrayList<>();
  }

}
