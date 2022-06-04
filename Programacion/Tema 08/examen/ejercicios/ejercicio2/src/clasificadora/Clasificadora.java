package clasificadora;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import fruta.Fruta;
import fruta.FrutaPatron;

public class Clasificadora {

  ArrayList<Fruta> frutas = new ArrayList<>();

  public Clasificadora() {
    ;
  }

  // añade una fruta a la colección
  // se permiten elementos repetidos
  // no es necesario realizar ninguna comprobación previa sobre la fruta
  public void add(Fruta fruta) {
    frutas.add(fruta);
  }

  // realiza la ordenación de la colección empleando Comparable de Fruta
  // comparable realiza la comparación según el color de la fruta
  public void sort() {
    frutas.sort((a, b) -> a.compareTo(b));

  }

  // realiza la ordenación de la colección empleando Comparator
  public void sort(Comparator<Fruta> comparador) {
    frutas.sort(comparador);
  }

  // devuelve todos los elementos de la colección
  // (no se necesita hacer una copia)
  public Collection<Fruta> getAll() {
    return frutas;
  }

  // devuelve todos los elementos que cumplan el criterio según los datos
  // que contiene la fruta de referencia, utiliza para ello
  public Collection<Fruta> getAll(FrutaPatron referencia, Comparator<Fruta> comparator) {
    ArrayList<Fruta> result = new ArrayList<>();

    frutas.forEach(fruta -> {
      if (comparator.compare(fruta, referencia) == 0)
        result.add(fruta);
    });

    return result;
  }

  // @param elimina de la colección todos los elementos que cumplan el criterio
  // según los datos de frutaDeReferencia la cual contendrá
  // los valores a usar como referencia para realizar la comparación en comparator
  // @param comparator criterio a utilizar para realizar la búsqueda
  // @return elementos eliminados
  //
  public Collection<Fruta> deleteAll(Fruta frutaDeReferencia, Comparator<Fruta> comparator) {
    Iterator<Fruta> it = frutas.iterator();

    while (it.hasNext()) {
      Fruta fruta = it.next();
      if (comparator.compare(fruta, frutaDeReferencia) == 0)
        it.remove();
    }

    return frutas;
  }

  // borra todos los elementos de la colección
  public void clear() {
    frutas.clear();
  }

  // devuelve el tamaño de la colección
  public int size() {
    return frutas.size();
  }
}
