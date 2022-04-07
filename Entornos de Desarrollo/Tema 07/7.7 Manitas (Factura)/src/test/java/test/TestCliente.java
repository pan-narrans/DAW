package test;

import code.ClienteReal;
import auxiliar.Clase;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCliente {

	@ParameterizedTest
	@DisplayName("Cliente: Excepciones")
	@MethodSource("test.TestSourcesAleatorios#argClienteAleatorios")

//El test usa un método que le da como argumentos de entrada valores aleatorios
	
	void testClienteExcepciones(
	    int argId,
	    String argNIF,
	    String argNombre,
	    int argTelefono,
	    String argEMail) {

//0. Excepciones
	
	ClienteReal clienteVacio = new ClienteReal();
	
	try {clienteVacio.setId(argId);}
	catch (IllegalArgumentException exception) {assertEquals("Exception: Id <= 0",exception.getMessage());}

//Opcional: repetimos las pruebas de persona	
	
  try {clienteVacio.setNIF(argNIF);}
  catch (IllegalArgumentException exception) {
  	if (argNIF == "" || argNIF == null)  assertEquals("Exception: NIF vacío",exception.getMessage());
  	else assertEquals("Exception: NIF incorrecto",exception.getMessage());}

		try {clienteVacio.setNombre(argNombre);}
  catch (IllegalArgumentException exception) {
  	if (argNombre == "" || argNombre == null)  assertEquals("Exception: Nombre vacío",exception.getMessage());
		else assertEquals("Exception: Nombre incorrecto",exception.getMessage());}	
	
	try {clienteVacio.setTelefono(argTelefono);}
	catch (IllegalArgumentException exception) {assertEquals("Exception: Telefono incorrecto",exception.getMessage());}

	try {clienteVacio.setEMail(argEMail);}
  catch (IllegalArgumentException exception) {
  	if (argEMail == "" || argEMail == null) 	assertEquals("Exception: eMail vacío",exception.getMessage());
		else assertEquals("Exception: eMail incorrecto",exception.getMessage());}}
	
	@ParameterizedTest
	@DisplayName("Cliente: Clase")
	@MethodSource("test.TestSourcesValidos#argClienteValidos")

//El test usa un método que le da como argumentos de entrada válidos	
	
	void testClienteBasico(
	    int argId,
	    String argNIF,
	    String argNombre,
	    int argTelefono,
	    String argEMail) {

//1. Constructor	
//2. Setters -> se prueban a través del constructor

		ClienteReal clienteTest = new ClienteReal(argId,argNIF,argNombre,argTelefono,argEMail); 

//3. Getters	
		
		assertEquals(clienteTest.getId(),argId);	
		assertEquals(clienteTest.getNIF(),argNIF);
		assertEquals(clienteTest.getNombre(),argNombre);
		assertEquals(clienteTest.getTelefono(),argTelefono);
		assertEquals(clienteTest.getEMail(),argEMail);
		
// 4. toString
	assertEquals(clienteTest.toString(),Clase.imprimeClase(clienteTest));
	System.out.println(clienteTest);

// 5. equal
	assertTrue(clienteTest.equals(clienteTest));}
}