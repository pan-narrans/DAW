package test;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Propios
import code.ColaboradorReal;
import code.Scoring;
import code.ServicioTipos;
import auxiliar.Aleatorio;
import auxiliar.Valido;

// Java
import java.util.ArrayList;

public class TestColaborador {

  @ParameterizedTest
  @DisplayName("Cliente")
  @MethodSource("test.TestSources#argColaborador")

  void testColaboradorBásico(int argId,
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
      assertEquals(colaborador.getId(), argId);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: id <= 0", exception.getMessage());
      argId = Aleatorio.darInt(1, 100);
    }
    try {
      colaborador.setNIF(argNIF);
      assertEquals(colaborador.getNIF(), argNIF);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: NIF incorrecto", exception.getMessage());
      argNIF = Valido.darNIFValido();
    }

    try {
      colaborador.setNombre(argNombre);
      assertEquals(colaborador.getNombre(), argNombre);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Nombre incorrecto", exception.getMessage());
      argNombre = Valido.darNombreValido();
    }

    try {
      colaborador.setTelefono(argTelefono);
      assertEquals(colaborador.getTelefono(), argTelefono);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Telefono incorrecto", exception.getMessage());
      argTelefono = Valido.darTelefonoValido();
    }

    try {
      colaborador.setEMail(argEMail);
      assertEquals(colaborador.getEMail(), argEMail);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: eMail incorrecto", exception.getMessage());
      argEMail = Valido.darEMailValido();
    }

  }

}
