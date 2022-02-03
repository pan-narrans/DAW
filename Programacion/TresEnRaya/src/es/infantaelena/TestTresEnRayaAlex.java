package es.infantaelena;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static es.infantaelena.TresEnRaya.*;

import java.util.Arrays;

import static es.infantaelena.TestTablerosAlex.*;

public class TestTresEnRayaAlex {

  @Tag("CheckTokensHorizontal")
  @Test
  void testCheckTokensHorizontal() {
    TresEnRaya t = new TresEnRaya();

    System.out.println("======TEST check Tokens Horizontal======");
    int i = 0, j = 0;

    for (int k = 0; k < TABLEROS_HORIZONTAL_DOS_SEGUIDAS.length; k++) {

      System.out.println("TABLERO Nº" + k);
      t.imprimirTablero(TABLEROS_HORIZONTAL_DOS_SEGUIDAS[k]);
      int[] resultado = t.checkTokens(JUG_1, TABLEROS_HORIZONTAL_DOS_SEGUIDAS[k]);

      System.out.println("RESULTADOS: " + Arrays.toString(resultado));
      System.out.println("ESPERADO: [" + i + ", " + j + "]");

      Assertions.assertEquals(i, resultado[0]);
      Assertions.assertEquals(j, resultado[1]);

      i = (j == 2) ? i + 1 : i;
      j = (j == 2) ? 0 : j + 1;
    }
  }

  @Tag("CheckTokensVertical")
  @Test
  void testCheckTokensVertical() {
    TresEnRaya t = new TresEnRaya();

    System.out.println("======TEST check Tokens Vertical======");
    int i = 0, j = 0;

    for (int k = 0; k < TABLEROS_VERTICAL_DOS_SEGUIDAS.length; k++) {

      System.out.println("TABLERO Nº" + k);
      t.imprimirTablero(TABLEROS_VERTICAL_DOS_SEGUIDAS[k]);
      int[] resultado = t.checkTokens(JUG_1, TABLEROS_VERTICAL_DOS_SEGUIDAS[k]);

      System.out.println("RESULTADOS: " + Arrays.toString(resultado));
      System.out.println("ESPERADO: [" + j + ", " + i + "]");

      Assertions.assertEquals(j, resultado[0]);
      Assertions.assertEquals(i, resultado[1]);

      i = (j == 2) ? i + 1 : i;
      j = (j == 2) ? 0 : j + 1;
    }
  }

  @Tag("CheckTokensDiagonal")
  @Test
  void testCheckTokensDiagonal() {
    TresEnRaya t = new TresEnRaya();

    System.out.println("======TEST check Tokens Diagonal======");
    int i = 0, j = 0;

    for (int k = 0; k < TABLEROS_DIAGONAL_DOS_SEGUIDAS.length; k++) {

      System.out.println("TABLERO Nº" + k);
      t.imprimirTablero(TABLEROS_DIAGONAL_DOS_SEGUIDAS[k]);
      int[] resultado = t.checkTokens(JUG_1, TABLEROS_DIAGONAL_DOS_SEGUIDAS[k]);

      System.out.println("RESULTADOS: " + Arrays.toString(resultado));
      System.out.println("ESPERADO: [" + i + ", " + i + "]");

      Assertions.assertEquals(i, resultado[0]);
      Assertions.assertEquals(i, resultado[1]);
      i++;
    }
  }
}