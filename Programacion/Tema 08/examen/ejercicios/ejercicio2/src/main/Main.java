package main;

import java.util.Collection;

import clasificadora.Clasificadora;
import fruta.Color;
import fruta.Fruta;
import fruta.FrutaPatron;
import fruta.Manzana;
import fruta.Melocoton;
import fruta.Naranja;
import fruta.Pera;
import fruta.Plantano;

public class Main {
  public static void main(String[] args) {
    Clasificadora clasificadora = new Clasificadora();

    // prueba carga fruta
    cargarFrutas(clasificadora);
    muestraFrutas(clasificadora);
    System.out.println("Se esperaban 20 frutas cargadas, se han obtenido: " + clasificadora.getAll().size());

    // ordenar usando comparable
    ordenaComparable(clasificadora);
    muestraFrutas(clasificadora);

    // ordenar por tamaño usando comparator
    ordenaComparatorTamanyo(clasificadora);
    muestraFrutas(clasificadora);

    // obtener todas las frutas almacenadas
    Collection<Fruta> frutasVerdes = getAllVerdes(clasificadora);
    muestraFrutas(frutasVerdes);
    System.out.println("Se esperaban 8 frutas, se han obtenido: " + frutasVerdes.size());

    // borrar todas las frutas que sean de color verde
    Collection<Fruta> frutasVerdesEliminadas = deleteAllVerdes(clasificadora);
    muestraFrutas(frutasVerdes);
    System.out.println("Se esperaban 8 frutas, se han obtenido: " + frutasVerdes.size());
    System.out.println("Se esperaban que en la clasificadora quedasen 12 frutas, actualmente quedan: "
        + clasificadora.getAll().size());

    // borrar todas las frutas
    deleteAll(clasificadora);
    muestraFrutas(clasificadora);
    System.out.println("Se esperaban 0 frutas, se han obtenido: " + clasificadora.getAll().size());

  }

  // borrar todos los elementos de la colección
  private static void deleteAll(Clasificadora clasificadora) {
    System.out.println("\nBorrar todas las frutas");
    clasificadora.clear();
  }

  // devuelve una colección que resulta de borrar todos las frutas de color verde
  // Color.VERDE
  private static Collection<Fruta> deleteAllVerdes(Clasificadora clasificadora) {
    System.out.println("\nBorrar todas las frutas de color verde");
    return clasificadora.deleteAll(
        new FrutaPatron(Color.VERDE, 0), (a, b) -> a.getColor().compareTo(b.getColor()));
  }

  // devuelve una colección que resulta de consultar todos las frutas que cumplen
  // que son de
  // color verde
  // Color.VERDE
  private static Collection<Fruta> getAllVerdes(Clasificadora clasificadora) {
    System.out.println("\nObtener todas las frutas de color verde");
    return clasificadora.getAll(
        new FrutaPatron(Color.VERDE, 0),
        (a, b) -> a.getColor().compareTo(b.getColor()));
  }

  // ordena la colección haciendo uso de comparable
  // comparable ordena según el color de la fruta
  private static void ordenaComparable(Clasificadora clasificadora) {
    System.out.println("\nOrdenar según criterio Comparable (color)");
    clasificadora.sort();
  }

  // ordena la colección según el peso de la fruta en orden ascendente
  private static void ordenaComparatorTamanyo(Clasificadora clasificadora) {
    System.out.println("\nOrdenar según criterio Comparator por peso ascendente");
    clasificadora.sort((a, b) -> a.getPeso().compareTo(b.getPeso()));
  }

  private static void muestraFrutas(Collection<Fruta> frutas) {
    System.out.println(frutas);
  }

  private static void muestraFrutas(Clasificadora clasificadora) {
    System.out.println(clasificadora.getAll());
  }

  private static void cargarFrutas(Clasificadora clasificadora) {

    clasificadora.add(new Plantano(10));
    clasificadora.add(new Plantano(15));
    clasificadora.add(new Plantano(20));
    clasificadora.add(new Plantano(30));

    clasificadora.add(new Pera(10));
    clasificadora.add(new Pera(15));
    clasificadora.add(new Pera(20));
    clasificadora.add(new Pera(30));

    clasificadora.add(new Manzana(10));
    clasificadora.add(new Manzana(15));
    clasificadora.add(new Manzana(20));
    clasificadora.add(new Manzana(30));

    clasificadora.add(new Melocoton(10));
    clasificadora.add(new Melocoton(15));
    clasificadora.add(new Melocoton(20));
    clasificadora.add(new Melocoton(30));

    clasificadora.add(new Naranja(10));
    clasificadora.add(new Naranja(15));
    clasificadora.add(new Naranja(20));
    clasificadora.add(new Naranja(30));
  }
}
