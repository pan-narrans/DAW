package test;

// === =============== ===
// === ALEJANDRO PÉREZ ===
// === =============== ===

// Importamos la clase que queremos probar
// En vuestro proyecto puede que esté en un paquete distinto. En el mío está en el paquete "main"
import main.Alumno;
import main.Profesor;

// Importo de la biblioteca JUNIT las herramientas que voy a utilizar en la práctica
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Creo la clase de prueba

public class TestProfesor{

  // Creo un objeto del tipo Grafo, que es la clase que voy a probar

  static private Profesor profe = new Profesor();

  @ParameterizedTest
  @DisplayName("Comprobar admitidos")
  @CsvSource({
      "Nombre, Apellido, 10, 10, 10",
      "Nombre, Apellido, 4, 5, 6",
      "Nombre, Apellido, 6, 5, 7",
  })
  public void testProfesorAdmitidos(String name, String surname, int nota1, int nota2, int nota3) {
    Alumno a = new Alumno(name, surname, nota1, nota2, nota3);
    Assertions.assertTrue(profe.admitirAlumno(a));
  }

  @ParameterizedTest
  @DisplayName("Comprobar rechazados")
  @CsvSource({
      "Nombre, Apellido, 3, 5, 2",
      "Nombre, Apellido, 1, 5, 4",
      "Nombre, Apellido, 1, 1, 10",
  })
  public void testProfesorRechazados(String name, String surname, int nota1, int nota2, int nota3) {
    Alumno a = new Alumno(name, surname, nota1, nota2, nota3);
    Assertions.assertFalse(profe.admitirAlumno(a));
  }
}