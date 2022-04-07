import java.util.Arrays;

import Baloncesto.*;

public class App {
  public static void main(String[] args) throws Exception {
    baloncesto();
  }

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
}
