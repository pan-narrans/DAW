
package test.java.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

// Propios
import main.java.code.Scoring;
import main.java.code.ServicioTipos;
import main.java.auxiliar.Clase;
import main.java.code.ColaboradorReal;

/**
 * @author Alejandro Pérez Álvarez
 */
public class TestColaborador {

  @ParameterizedTest
  @MethodSource("test.java.test.TestSourcesAleatorios#argColaboradorAleatorios")

  void testColaboradorExcepciones(int argId,
                                  ServicioTipos argServicio,
                                  Scoring argScoring,
                                  double argTarifa,
                                  boolean argDisponible,

                                  String argNombre,
                                  String argNIF,
                                  int argTelefono,
                                  String argEMail) {

    // Excepciones
    ColaboradorReal colaborador = new ColaboradorReal();
    try {
      colaborador.setId(argId);
    } catch (Exception e) {
      Assertions.assertEquals(e.getMessage(), "Exception: Id <= 0");
    }
    try {
      colaborador.setTarifa(argTarifa);
    } catch (Exception e) {
      Assertions.assertEquals(e.getMessage(), "Exception: Tarifa < 0.0");
    }

  }

  @ParameterizedTest
  @MethodSource("test.java.test.TestSourcesValidos#argColaboradorValidos")

  void testColaboradorBasico(int argId,
                             ServicioTipos argServicio,
                             Scoring argScoring,
                             double argTarifa,
                             boolean argDisponible,

                             String argNombre,
                             String argNIF,
                             int argTelefono,
                             String argEMail) {

    // Setters (se ejecutan con el constructor)
    ColaboradorReal colaborador = new ColaboradorReal(argId, argServicio,
        argScoring, argTarifa, argDisponible, argNIF, argNombre, argTelefono,
        argEMail);

    // Getters
    assertEquals(colaborador.getId(), argId);
    assertEquals(colaborador.getServicio(), argServicio);
    assertEquals(colaborador.getScoring(), argScoring);
    assertEquals(colaborador.getTarifa(), argTarifa);
    assertEquals(colaborador.getDisponible(), argDisponible);

    // To String
    String resultado = Clase.imprimeClase(colaborador)
                       + "Activo: " + colaborador.esActivo() + "\n";
    assertEquals(colaborador.toString(), resultado);

    // Equals
    assertEquals(true, colaborador.equals(colaborador));
    assertEquals(false, colaborador.equals(new ColaboradorReal()));

    // Es Activo
    double tarifaMax = argServicio.getTarifa() * (1 - argScoring.getRebaja());
    boolean esActivo = (argDisponible && argTarifa <= tarifaMax);
    assertEquals(esActivo, colaborador.esActivo());

    System.out.println(colaborador);
  }

}
