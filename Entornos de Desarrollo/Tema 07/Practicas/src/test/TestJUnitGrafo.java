package test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import grafo.Grafo;

public class TestJUnitGrafo {

  @Tag("testGrafo")
  @Test
  public void testGrafo() {
    Grafo g = new Grafo();

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
