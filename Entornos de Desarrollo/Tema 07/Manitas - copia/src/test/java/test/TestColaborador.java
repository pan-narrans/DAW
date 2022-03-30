package test.java.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

// Propios
import main.java.code.Scoring;
import main.java.code.ServicioTipos;
import main.java.auxiliar.Aleatorio;
import main.java.auxiliar.Valido;
import main.java.code.ColaboradorReal;

public class TestColaborador {

  @ParameterizedTest
  @DisplayName("Cliente")
  @MethodSource("test.java.test.TestSourcesAleatorios#argColaboradorAleatorios")

  void testColaboradorBásico(
      int argId, ServicioTipos argServicio, Scoring argScoring,
      double argTarifa, boolean argDisponible,

      String argNombre, String argNIF, int argTelefono, String argEMail) {

    // Excepciones
    ColaboradorReal colaborador = new ColaboradorReal();
    try {
      colaborador.setId(argId);
    } catch (Exception e) {
      Assertions.assertEquals(e.getMessage(), "Exception: Id <= 0");
    }

  }

}
