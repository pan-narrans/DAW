package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import grafo.Grafo;

@DisplayName("Tests de la clase Grafo")
public class TestJUnitGrafo {

  Grafo g = new Grafo();

  @BeforeAll
  public static void name() {
    System.out.println("hey");
  }

  @Test
  @DisplayName("Test Grafo")
  public void testGrafo() {
    System.out.println("hola");

    Assertions.assertEquals(1, g.aMethod(true, true, false));
    Assertions.assertEquals(1, g.aMethod(true, true, true));

    Assertions.assertEquals(0, g.aMethod(true, false, false));
    Assertions.assertEquals(2, g.aMethod(true, false, true));
    Assertions.assertEquals(0, g.aMethod(false, true, false));
    Assertions.assertEquals(2, g.aMethod(false, true, true));

    Assertions.assertEquals(0, g.aMethod(false, false, false));
    Assertions.assertEquals(2, g.aMethod(false, false, true));
  }

}
