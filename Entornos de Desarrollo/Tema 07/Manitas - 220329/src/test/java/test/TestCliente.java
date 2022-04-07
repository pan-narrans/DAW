package test.java.test;

import main.java.code.ClienteReal;
import main.java.auxiliar.Clase;
import main.java.auxiliar.Valido;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCliente {

  @ParameterizedTest
  @DisplayName("Cliente: Excepciones")
  @MethodSource("test.java.test.TestSourcesAleatorios#argClienteAleatorios")

  // El test usa un método que le da como argumentos de entrada valores
  // aleatorios

  void testClienteExcepciones(
      int argId, String argNIF, String argNombre, int argTelefono,
      String argEMail) {

    // 0. Excepciones

    ClienteReal clienteVacío = new ClienteReal();

    try {
      clienteVacío.setId(argId);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Id <= 0", exception.getMessage());
    }

    // Opcional: repetimos las pruebas de persona

    try {
      clienteVacío.setNIF(argNIF);
    } catch (IllegalArgumentException exception) {
      if (argNIF == "" || argNIF == null)
        assertEquals("Exception: NIF vac�o", exception.getMessage());
      if (!Valido.validarNIF(argNIF))
        assertEquals("Exception: NIF incorrecto", exception.getMessage());
    }

    try {
      clienteVacío.setNombre(argNombre);
    } catch (IllegalArgumentException exception) {
      if (argNombre == "" || argNombre == null)
        assertEquals("Exception: Nombre vac�o", exception.getMessage());
      else if (!Valido.validarNombre(argNombre))
        assertEquals("Exception: Nombre incorrecto", exception.getMessage());
    }

    try {
      clienteVacío.setTelefono(argTelefono);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Telefono incorrecto", exception.getMessage());
    }

    try {
      clienteVacío.setEMail(argEMail);
    } catch (IllegalArgumentException exception) {
      if (argEMail == "" || argEMail == null)
        assertEquals("Exception: eMail vac�o", exception.getMessage());
      else if (!Valido.validarEMail(argEMail))
        assertEquals("Exception: eMail incorrecto", exception.getMessage());
    }
  }

  @ParameterizedTest
  @DisplayName("Cliente: Clase")
  @MethodSource("test.java.test.TestSourcesValidos#argClienteValidos")

  // El test usa un m�todo que le da como argumentos de entrada v�lidos

  void testClienteBasico(
      int argId, String argNIF, String argNombre, int argTelefono,
      String argEMail) {

    // 1. Constructor
    // 2. Setters -> se prueban a trav�s del constructor

    ClienteReal cliente = new ClienteReal(argId, argNIF, argNombre, argTelefono,
        argEMail);

    // 3. Getters

    assertEquals(cliente.getId(), argId);
    assertEquals(cliente.getNIF(), argNIF);
    assertEquals(cliente.getNombre(), argNombre);
    assertEquals(cliente.getTelefono(), argTelefono);
    assertEquals(cliente.getEMail(), argEMail);

    // 4. toString
    assertEquals(cliente.toString(), Clase.imprimeClase(cliente));
    System.out.println(cliente);
  }
}