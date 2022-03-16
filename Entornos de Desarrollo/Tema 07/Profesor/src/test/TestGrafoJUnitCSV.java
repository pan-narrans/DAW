package test;

// Importamos la clase que queremos probar
// En vuestro proyecto puede que esté en un paquete distinto. En el mío está en el paquete "main"

import main.Grafo;

// Importo de la biblioteca JUNIT las herramientas que voy a utilizar en la práctica

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Creo la clase de prueba

public class TestGrafoJUnitCSV {

  // Creo un objeto del tipo Grafo, que es la clase que voy a probar

  static private Grafo grafo = new Grafo();

  // Configuro las herramientas de JUNIT
  // Voy a utilizar como fuente de los datos de prueba una matriz (se puede
  // utilizar también datos que estén en un fichero)

  @ParameterizedTest
  @DisplayName("CSV")
  @CsvSource({ "true,false,true,2",
      "true,false,false,0",
      "true,true,false,1",
      "false,false,false,0",
  })

  // Método de prueba
  // En vez de utilizar cuatro métodos o cuatro Asserts, uno por camino, utilzo un
  // único método que admite valores de entrada

  public void testGrafo(boolean a, boolean b, boolean c, int resultado) {
    boolean condicion = (grafo.aMethod(a, b, c) == resultado);
    Assertions.assertTrue(condicion);

  }
}