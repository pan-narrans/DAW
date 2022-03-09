package test;

import grafo.Grafo;

public class TestGrafo {
  public static void main(String[] args) {

    Grafo g = new Grafo();

    assert g.aMethod(true, true, false) == 1 : "Error, valor esperado 1.";
    assert g.aMethod(true, true, true) == 1 : "Error, valor esperado 1.";

    assert g.aMethod(true, false, false) == 0 : "Error, valor esperado 0.";
    assert g.aMethod(true, false, true) == 2 : "Error, valor esperado 2.";
    assert g.aMethod(false, true, false) == 0 : "Error, valor esperado 0.";
    assert g.aMethod(false, true, true) == 2 : "Error, valor esperado 2.";
    
    assert g.aMethod(false, false, false) == 0 : "Error, valor esperado 0.";
    assert g.aMethod(false, false, true) == 2 : "Error, valor esperado 2.";

  }
}
