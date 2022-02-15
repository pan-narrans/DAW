package zz_misc;

import java.util.ArrayList;

public class EjArrayList {

  public void iniciar() {
    ArrayList<Integer> listaEnteros = new ArrayList<Integer>();

    for (int i = 0; i < 10; i++) {
      listaEnteros.add(i);
    }

    listaEnteros.iterator();

    System.out.println(listaEnteros.toString());

  }

}
