package test;

import code.Factura;
import code.FacturaImportes;

import auxiliar.Aleatorio;
import auxiliar.Clase;
import auxiliar.Valido;

import java.util.EnumMap;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestFactura {

  @ParameterizedTest
  @DisplayName("Factura")
  @MethodSource("test.TestSources#argFactura")

  void testServicioBásico(
      int argId, String argFecha, String argCIFEmisor, String argCIFReceptor,
      String argDescripcion, double argBase, double argIvaTipo,
      double argRetencionTipo) {

    // El test usa un m�todo que le da como argumentos de entrada un nombre y
    // tarifa aleatorios
    // Hay que probar varias cosas:
    // 0. Excepciones
    // 1. Constructor
    // 2. Getters
    // 3. Setters
    // 4. toString
    // 5. calculaFactura

    // 0. Excepciones

    Factura facturaVacia = new Factura();

    try {
      facturaVacia.setId(argId);
      assertEquals(facturaVacia.getId(), argId);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: id <= 0", exception.getMessage());
      argId = Math.abs(argId) + 1;
    } // Evita fallidos al crear la facturaTest

    try {
      facturaVacia.setFecha(argFecha);
      assertEquals(facturaVacia.getFecha(), argFecha);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Fecha Vacía", exception.getMessage());
      argFecha = Aleatorio.darString(10);
    } // Mejorable: una fecha "ver�dica"

    try {
      facturaVacia.setCIFEmisor(argCIFEmisor);
      assertEquals(facturaVacia.getCIFEmisor(), argCIFEmisor);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: CIF Emisor Incorrecto", exception.getMessage());
      argCIFEmisor = Valido.darNIFValido();
    }

    try {
      facturaVacia.setCIFReceptor(argCIFReceptor);
      assertEquals(facturaVacia.getCIFReceptor(), argCIFReceptor);
    } catch (IllegalArgumentException exception) {
      assertEquals(
          "Exception: CIF Receptor Incorrecto", exception.getMessage());
      argCIFReceptor = Valido.darNIFValido();
    }

    try {
      facturaVacia.setDescripcion(argDescripcion);
      assertEquals(facturaVacia.getDescripcion(), argDescripcion);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Descripción Vacía", exception.getMessage());
      argDescripcion = Aleatorio.darString(10);
    } // Una descripción cualquiera

    try {
      facturaVacia.setBase(argBase);
      assertEquals(facturaVacia.getBase(), argBase);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Base <= 0", exception.getMessage());
      argBase = Math.abs(argBase) + 1.0;
    } // La base en positivo (ha fallado por ser negativa o cero

    try {
      facturaVacia.setIvaTipo(argIvaTipo);
      assertEquals(facturaVacia.getIvaTipo(), argIvaTipo);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: IVA incorrecto", exception.getMessage());
      argIvaTipo = Aleatorio.darDouble(0.0, 1.0, 1);
    } // Un valor entre 0 y 1

    try {
      facturaVacia.setRetencionTipo(argRetencionTipo);
      assertEquals(facturaVacia.getRetencionTipo(), argRetencionTipo);
    } catch (IllegalArgumentException exception) {
      assertEquals("Exception: Retención incorrecta", exception.getMessage());
      argRetencionTipo = Aleatorio.darDouble(0.0, 1.0, 1);
    } // Un valor entre 0 y 1

    // 1. Constructor
    // Los argumentos vienen trucados para evitar fallidos

    Factura factura = new Factura(argId, argFecha, argCIFEmisor, argCIFReceptor,
        argDescripcion, argBase, argIvaTipo, argRetencionTipo);

    // 2. Getters
    // 3. Setters
    assertEquals(factura.getId(), argId);
    assertEquals(factura.getFecha(), argFecha);
    assertEquals(factura.getCIFEmisor(), argCIFEmisor);
    assertEquals(factura.getCIFReceptor(), argCIFReceptor);
    assertEquals(factura.getCIFReceptor(), argCIFReceptor);
    assertEquals(factura.getDescripcion(), argDescripcion);
    assertEquals(factura.getBase(), argBase);
    assertEquals(factura.getIvaTipo(), argIvaTipo);
    assertEquals(factura.getRetencionTipo(), argRetencionTipo);

    // 4. toString
    assertEquals(factura.toString(), Clase.imprimeClase(factura));

    // 5. Calcular Factura

    EnumMap<FacturaImportes, Double> importes = factura.getImportes();

    double ivaCheck = factura.getBase() * factura.getIvaTipo();
    double retencionCheck = factura.getBase() * factura.getRetencionTipo();
    double totalCheck = factura.getBase() + ivaCheck;
    double facturableCheck = totalCheck - retencionCheck;

    assertEquals(importes.get(FacturaImportes.BASE), argBase);
    assertEquals(importes.get(FacturaImportes.IVA), ivaCheck);
    assertEquals(importes.get(FacturaImportes.RETENCION), retencionCheck);
    assertEquals(importes.get(FacturaImportes.TOTAL), totalCheck);
    assertEquals(importes.get(FacturaImportes.FACTURABLE), facturableCheck);
  }

}