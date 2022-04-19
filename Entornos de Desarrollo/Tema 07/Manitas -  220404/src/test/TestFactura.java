package test;

import code.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import auxiliar.Clase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFactura {

  @ParameterizedTest
  @DisplayName("Factura: Excepciones")
  @MethodSource("test.TestSourcesAleatorios#argFacturaAleatorios")

  void testFacturaExcepciones(
      int argId,
      String argFecha,
      String argCIFEmisor,
      String argCIFReceptor,
      String argDescripción,
      double argBase,
      double argIvaTipo,
      double argRetenciónTipo) {

    Factura factura = new Factura();

    // ID
    try {
      factura.setId(argId);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Id <= 0", exception.getMessage());
    }

    // Fecha
    try {
      factura.setFecha(argFecha);
    } catch (IllegalArgumentException exception) {
      if (argFecha == "" || argFecha == null) {
        assertEquals("Exception: Fecha vacía", exception.getMessage());
      } else {
        assertEquals("Exception: Fecha incorrecta", exception.getMessage());
      }

    }

    // CIF Emisor
    try {
      factura.setCIFEmisor(argCIFEmisor);
    } catch (IllegalArgumentException exception) {
      if (argCIFEmisor == "" || argCIFEmisor == null) {
        assertEquals("Exception: NIF vacío", exception.getMessage());
      } else {
        assertEquals("Exception: CIF Emisor incorrecto", exception.getMessage());
      }
    }

    // CIF Receptor
    try {
      factura.setCIFReceptor(argCIFReceptor);
    } catch (IllegalArgumentException exception) {
      if (argCIFReceptor == "" || argCIFReceptor == null) {
        assertEquals("Exception: NIF vacío", exception.getMessage());
      } else {
        assertEquals("Exception: CIF Receptor incorrecto", exception.getMessage());
      }
    }

    // Descripción
    try

    {
      factura.setDescripción(argDescripción);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Descripción vacía", exception.getMessage());
    }

    // Base
    try {
      factura.setBase(argBase);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Base <= 0", exception.getMessage());
    }

    // IvaTipo
    try {
      factura.setIvaTipo(argIvaTipo);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: IVA incorrecto", exception.getMessage());
    }

    // RetenciónTipo
    try {
      factura.setRetenciónTipo(argRetenciónTipo);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Retención incorrecta", exception.getMessage());
    }
  }

  @ParameterizedTest
  @DisplayName("Colaborador: Clase")
  @MethodSource("test.TestSourcesValidos#argFacturaValidos")

  void testFacturaGetters(
      int argId,
      String argFecha,
      String argCIFEmisor,
      String argCIFReceptor,
      String argDescripción,
      double argBase,
      double argIvaTipo,
      double argRetenciónTipo) {

    Factura factura = new Factura(
        argId, argFecha, argCIFEmisor, argCIFReceptor, argDescripción, argBase, argIvaTipo,
        argRetenciónTipo);

    assertEquals(factura.getId(), argId);
    assertEquals(factura.getFecha(), argFecha);
    assertEquals(factura.getCIFEmisor(), argCIFEmisor);
    assertEquals(factura.getCIFReceptor(), argCIFReceptor);
    assertEquals(factura.getDescripción(), argDescripción);
    assertEquals(factura.getBase(), argBase);
    assertEquals(factura.getIvaTipo(), argIvaTipo);
    assertEquals(factura.getRetenciónTipo(), argRetenciónTipo);
  }

  @ParameterizedTest
  @DisplayName("Colaborador: Clase")
  @MethodSource("test.TestSourcesValidos#argFacturaValidos")
  void testFacturaOtros(
      int argId,
      String argFecha,
      String argCIFEmisor,
      String argCIFReceptor,
      String argDescripción,
      double argBase,
      double argIvaTipo,
      double argRetenciónTipo) {

    Factura factura = new Factura(
        argId, argFecha, argCIFEmisor, argCIFReceptor, argDescripción, argBase, argIvaTipo,
        argRetenciónTipo);

    // to string
    assertEquals(Clase.imprimeClase(factura), factura.toString());

    // equals
    Factura factura2 = new Factura(
        argId, argFecha, argCIFEmisor, argCIFReceptor, argDescripción, argBase, argIvaTipo,
        argRetenciónTipo);
    assertTrue(factura.equals(factura2));
  }
}
