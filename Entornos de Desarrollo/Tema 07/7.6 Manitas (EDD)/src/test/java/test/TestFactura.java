package test;

import code.Factura;
import code.FacturaImportes;
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
	@DisplayName("Factura: Excepciones")
	@MethodSource("test.TestSourcesAleatorios#argFacturaAleatorios")

//El test usa un método que le da argumentos aleatorios
	
	void testFacturaExcepciones(
	    int argId,	
	    String argFecha,
	    String argCIFEmisor,
	    String argCIFReceptor,
	    String argDescripcion,
	    double argBase,
	    double argIvaTipo,
	    double argRetencionTipo) {

//0. Excepciones
	
		Factura facturaVacia = new Factura();
	
		try {facturaVacia.setId(argId);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Id <= 0",exception.getMessage());}
 
		try {facturaVacia.setFecha(argFecha);}
		catch (IllegalArgumentException exception) {
    	if (argFecha == "" || argFecha == null)  assertEquals("Exception: Fecha vacía",exception.getMessage());
    	if (!Valido.validarFecha(argFecha)) assertEquals("Exception: Fecha incorrecta",exception.getMessage());}
	
		try {facturaVacia.setCIFEmisor(argCIFEmisor);}
		catch (IllegalArgumentException exception) {
    	if (argCIFEmisor == "" || argCIFEmisor == null)  assertEquals("Exception: NIF vacío",exception.getMessage());
    	if (!Valido.validarNIF(argCIFEmisor)) assertEquals("Exception: CIF Emisor incorrecto",exception.getMessage());}

		try {facturaVacia.setCIFReceptor(argCIFReceptor);}
		catch (IllegalArgumentException exception) {
    	if (argCIFReceptor == "" || argCIFReceptor == null)  assertEquals("Exception: NIF vacío",exception.getMessage());
    	if (!Valido.validarNIF(argCIFEmisor)) assertEquals("Exception: CIF Receptor incorrecto",exception.getMessage());}
	
		try {facturaVacia.setDescripcion(argDescripcion);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Descripción vacía",exception.getMessage());}

		try {facturaVacia.setBase(argBase);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Base <= 0",exception.getMessage());}

		try {facturaVacia.setIvaTipo(argIvaTipo);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: IVA incorrecto",exception.getMessage());}
	
		try {facturaVacia.setRetencionTipo(argRetencionTipo);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Retención incorrecta",exception.getMessage());}
	}		

	@ParameterizedTest
	@DisplayName("Factura: Clase")
	@MethodSource("test.TestSourcesValidos#argFacturaValidos")

	//El test usa un método que le da argumentos válidos
	
	void testFacturaClase(
	    int argId,	
	    String argFecha,
	    String argCIFEmisor,
	    String argCIFReceptor,
	    String argDescripcion,
	    double argBase,
	    double argIvaTipo,
	    double argRetencionTipo) {

//1. Constructor	
//2. Setters -> a través del constructor
	
	Factura factura = new Factura(argId,argFecha,argCIFEmisor,argCIFReceptor,argDescripcion,argBase,argIvaTipo,argRetencionTipo); 

//3. Getters

	assertEquals(factura.getId(),argId);
	assertEquals(factura.getFecha(),argFecha);
	assertEquals(factura.getCIFEmisor(),argCIFEmisor);
	assertEquals(factura.getCIFReceptor(),argCIFReceptor);
	assertEquals(factura.getCIFReceptor(),argCIFReceptor);
	assertEquals(factura.getDescripcion(),argDescripcion);
	assertEquals(factura.getBase(),argBase);
	assertEquals(factura.getIvaTipo(),argIvaTipo);
	assertEquals(factura.getRetencionTipo(),argRetencionTipo);

//4. toString 		
	assertEquals(factura.toString(),Clase.imprimeClase(factura));
	System.out.println(factura);
			
//5. Calcular Factura	
//Implemento la lógica de la función
		
		double ivaCheck = factura.getBase() * factura.getIvaTipo(); 
		double retencionCheck = factura.getBase() * factura.getRetencionTipo(); 
		double totalCheck = factura.getBase() + ivaCheck;
		double facturableCheck = totalCheck - retencionCheck;

// Calculo la factura con el método		
		EnumMap <FacturaImportes,Double> importes = factura.getImportes();		

		assertEquals(importes.get(FacturaImportes.BASE),argBase);
		assertEquals(importes.get(FacturaImportes.IVA),ivaCheck);
		assertEquals(importes.get(FacturaImportes.RETENCION),retencionCheck);
		assertEquals(importes.get(FacturaImportes.TOTAL),totalCheck);
		assertEquals(importes.get(FacturaImportes.FACTURABLE), facturableCheck);
	}
	
}