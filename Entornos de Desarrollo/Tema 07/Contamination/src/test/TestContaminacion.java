package test;

// We import the classes to test
import main.Coche;
import main.Combustible;
import main.Etiqueta;
import main.Oficina;

// JUNIT
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Clase de prueba
public class TestContaminacion {
  // ==============================
  // ALEJANDRO PÉREZ ÁLVAREZ 1º DAW
  // ==============================

  Oficina ofi;

  @BeforeEach
  public void beforeEach() {
    ofi = new Oficina();
  }

  @Nested
  @DisplayName("Coches Electricos")
  public class cochesElectricos {

    @ParameterizedTest
    @DisplayName("Test Verde")
    @CsvSource({
        "ELECTRICO, 1000",
        "ELECTRICO, 10",
        "ELECTRICO, 10000",
        "ELECTRICO, 99",
    })
    public void testVerde(Combustible energia, int potencia) {
      Coche carro = new Coche(energia, potencia);
      assertEquals(Etiqueta.VERDE, ofi.asignaEtiqueta(carro));
    }

    @ParameterizedTest
    @DisplayName("Test Rojo")
    @CsvSource({
        "ELECTRICO, 1000",
        "ELECTRICO, 10",
        "ELECTRICO, 10000",
        "ELECTRICO, 99",
    })
    public void testRojo(Combustible energia, int potencia) {
      Coche carro = new Coche(energia, potencia);
      assertNotEquals(Etiqueta.ROJA, ofi.asignaEtiqueta(carro));
    }

  }

  @Nested
  @DisplayName("Coches Fósiles")
  public class cochesFosiles {

    @ParameterizedTest
    @DisplayName("Test Verde")
    @CsvSource({
        "FOSIL, 119",
        "FOSIL, 0",
        "FOSIL, 50",
    })
    public void testVerde(Combustible energia, int potencia) {
      Coche carro = new Coche(energia, potencia);
      assertEquals(Etiqueta.VERDE, ofi.asignaEtiqueta(carro));
    }

    @ParameterizedTest
    @DisplayName("Test Verde")
    @CsvSource({
        "FOSIL, 120",
        "FOSIL, 300",
        "FOSIL, 1000",
    })
    public void testRojo(Combustible energia, int potencia) {
      Coche carro = new Coche(energia, potencia);
      assertEquals(Etiqueta.ROJA, ofi.asignaEtiqueta(carro));
    }

  }

}
