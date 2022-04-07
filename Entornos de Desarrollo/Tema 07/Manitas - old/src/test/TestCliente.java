package test;

import code.ClienteReal;
import auxiliar.Aleatorio;
import auxiliar.Clase;
import auxiliar.Valido;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCliente {

	@ParameterizedTest
	@DisplayName("Cliente")
	@MethodSource("test.TestSources#argCliente")


	void testClienteBasico(
	    int argId,
	    String argNIF,
	    String argNombre,
	    int argTelefono,
	    String argEMail) {

// El test usa un método que le da como argumentos de entrada un nombre y tarifa aleatorios
// Hay que probar varias cosas:	
// 0. Excepciones
// 1. Constructor
// 2. Getters
// 3. Setters
// 4. toString		

//0. Excepciones
	
	ClienteReal clienteVacio = new ClienteReal();
	
	try {
		clienteVacio.setId(argId);
		assertEquals(clienteVacio.getId(),argId);}	
	catch (IllegalArgumentException exception) {
		assertEquals("Exception: id <= 0",exception.getMessage());
		argId = Aleatorio.darInt(1,100);}

  try {
  	clienteVacio.setNIF(argNIF);
		assertEquals(clienteVacio.getNIF(),argNIF);}
  catch (IllegalArgumentException exception){
  	assertEquals("Exception: NIF incorrecto",exception.getMessage());
  	argNIF = Valido.darNIFValido();}

	try {
		clienteVacio.setNombre(argNombre);
		assertEquals(clienteVacio.getNombre(),argNombre);}
  catch (IllegalArgumentException exception) {
  	assertEquals("Exception: Nombre incorrecto",exception.getMessage());
  	argNombre = Valido.darNombreValido();}

	try {
		clienteVacio.setTelefono(argTelefono);
		assertEquals(clienteVacio.getTelefono(),argTelefono);}
	catch (IllegalArgumentException exception) {
		assertEquals("Exception: Telefono incorrecto",exception.getMessage());
		argTelefono = Valido.darTelefonoValido();}
	
	try {	
		clienteVacio.setEMail(argEMail);
		assertEquals(clienteVacio.getEMail(),argEMail);}
  catch (IllegalArgumentException exception) {
  	assertEquals("Exception: eMail incorrecto",exception.getMessage());
 		argEMail = Valido.darEMailValido();}

//1. Constructor	
//He trucado los argumentos para evitar fallidos
	
	ClienteReal cliente = new ClienteReal(argId,argNIF,argNombre,argTelefono,argEMail); 

//2. Getters
//3. Setters	
	assertEquals(cliente.getId(),argId);	
	assertEquals(cliente.getNIF(),argNIF);
	assertEquals(cliente.getNombre(),argNombre);
	assertEquals(cliente.getTelefono(),argTelefono);
	assertEquals(cliente.getEMail(),argEMail);
		
// 4. toString
	assertEquals(cliente.toString(),Clase.imprimeClase(cliente));
	}
}