package test;

import code.Persona;
import auxiliar.Clase;
import auxiliar.Valido;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPersona {

	@ParameterizedTest
	@DisplayName("Persona")
	@MethodSource("test.TestSources#argPersona")

	void testPersonaBasico(
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
	
	Persona personaVacia = new Persona();

    try {
    	personaVacia.setNIF(argNIF);
    	assertEquals(personaVacia.getNIF(),argNIF);}
    catch (IllegalArgumentException exception){
    	assertEquals("Exception: NIF incorrecto",exception.getMessage());
    	argNIF = Valido.darNIFValido();}

		try {
			personaVacia.setNombre(argNombre);
    	assertEquals(personaVacia.getNombre(),argNombre);}
	  catch (IllegalArgumentException exception) {
	  	assertEquals("Exception: Nombre incorrecto",exception.getMessage());
   		argNombre = Valido.darNombreValido();}

		try {
			personaVacia.setTelefono(argTelefono);
			assertEquals(personaVacia.getTelefono(),argTelefono);}
		catch (IllegalArgumentException exception) {
			assertEquals("Exception: Telefono incorrecto",exception.getMessage());
  		argTelefono = Valido.darTelefonoValido();}
	
		try {
			personaVacia.setEMail(argEMail);
			assertEquals(personaVacia.getEMail(),argEMail);}
    catch (IllegalArgumentException exception) {
    	assertEquals("Exception: eMail incorrecto",exception.getMessage());
    	argEMail = Valido.darEMailValido();}

//1. Constructor	
//Truco los argumentos para evitar fallidos
	
	Persona persona = new Persona(argNIF,argNombre,argTelefono,argEMail); 
	System.out.println(persona);
	
//2. Getters
//3. Setters	
	assertEquals(persona.getNIF(),argNIF);
	assertEquals(persona.getNombre(),argNombre);
	assertEquals(persona.getTelefono(),argTelefono);
	assertEquals(persona.getEMail(),argEMail);
		
// 4. toString 		
	assertEquals(persona.toString(),Clase.imprimeClase(persona));
	}
}