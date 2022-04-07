package test;

import code.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import auxiliar.Clase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestColaborador {

	@ParameterizedTest
	@DisplayName("Colaborador: Excepciones")
	@MethodSource("test.TestSourcesAleatorios#argColaboradorAleatorios")

	// Utiliza como entrada un m�todo que genera argumentos aleatorios para crear el colaborador
	
	void testColaboradorExcepciones(
		int 					argId,
		ServicioTipos argServicio,
		Scoring 			argScoring,
		double 				argTarifa, 
		boolean 			argDisponible,
		
		String	argNombre,
		String 	argNIF, 
		int 		argTelefono,
		String 	argEMail) {

// 0.Excepciones
		
		ColaboradorReal colaboradorVacio = new ColaboradorReal();

// El resto de campos "propios de colaborador no generan excepciones		
		try {colaboradorVacio.setId(argId);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Id <= 0",exception.getMessage());}

		try {colaboradorVacio.setTarifa(argTarifa);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Tarifa < 0.0",exception.getMessage());}
		
// Opcional: repetimos las pruebas de persona
		
    try {colaboradorVacio.setNIF(argNIF);}
    catch (IllegalArgumentException exception) {
    	if (argNIF == "" || argNIF == null)  assertEquals("Exception: NIF vac�o",exception.getMessage());
    	else assertEquals("Exception: NIF incorrecto",exception.getMessage());}

 		try {colaboradorVacio.setNombre(argNombre);}
	  catch (IllegalArgumentException exception) {
	  	if (argNombre == "" || argNombre == null)  assertEquals("Exception: Nombre vac�o",exception.getMessage());
  		else assertEquals("Exception: Nombre incorrecto",exception.getMessage());}	
		
		try {colaboradorVacio.setTelefono(argTelefono);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Telefono incorrecto",exception.getMessage());}

		try {colaboradorVacio.setEMail(argEMail);}
    catch (IllegalArgumentException exception) {
    	if (argEMail == "" || argEMail == null) 	assertEquals("Exception: eMail vac�o",exception.getMessage());
			else assertEquals("Exception: eMail incorrecto",exception.getMessage());}		
	}
		
	@ParameterizedTest
	@DisplayName("Colaborador: Clase")
	@MethodSource("test.TestSourcesValidos#argColaboradorValidos")

	// Utiliza como entrada un m�todo que genera argumentos v�lidos

	void testColaboradorClase(
		int 					argId,
		ServicioTipos argServicio,
		Scoring 			argScoring,
		double 				argTarifa, 
		boolean 			argDisponible,
		
		String 	argNIF, 
		String	argNombre,
		int 		argTelefono,
		String 	argEMail) {

// 1.Constructor
// 2. Setters -> se prueban a trav�s del constructor
			
		Colaborador colaboradorTest = new ColaboradorReal (argId,argServicio,argScoring,argTarifa,argDisponible,argNIF,argNombre,argTelefono,argEMail);
		
// 3. Getters
			
		assertEquals(colaboradorTest.getId(),argId);
		assertEquals(colaboradorTest.getServicio(),argServicio);
		assertEquals(colaboradorTest.getScoring(),argScoring);
		assertEquals(colaboradorTest.getTarifa(),argTarifa); 
		assertEquals(colaboradorTest.getDisponible(),argDisponible);	
		assertEquals(colaboradorTest.getNombre(),argNombre);
		assertEquals(colaboradorTest.getNIF(),argNIF);	
		assertEquals(colaboradorTest.getTelefono(),argTelefono);
		assertEquals(colaboradorTest.getEMail(),argEMail);
			
// 4. toString 		
		assertEquals(colaboradorTest.toString(),Clase.imprimeClase(colaboradorTest)+"Activo: " + colaboradorTest.esActivo() + "\n");
		System.out.println(colaboradorTest);
		
// 5. equal
		assertTrue(colaboradorTest.equals(colaboradorTest));
					
// 5. esActivo	
// El colaborodor es activo si est� disponible y su tarifa, despu�s de aplicar la rebaja por su scoring, es inferior a la tarifa de ese servicio
 		
 		boolean colaboradorEstado = false;
 		double tarifaMax = 0.0;
 		
 		tarifaMax = colaboradorTest.getServicio().getTarifa() * (1-colaboradorTest.getScoring().getRebaja());
 		colaboradorEstado = colaboradorTest.getDisponible() && colaboradorTest.getTarifa() < tarifaMax;
 		assertEquals(colaboradorTest.esActivo(), colaboradorEstado);
 	}	
}