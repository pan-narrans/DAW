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
	@DisplayName("Persona: Excepciones")
	@MethodSource("test.TestSourcesAleatorios#argPersonaAleatorios")

	void testPersonaExcepciones(
	    String argNIF,
	    String argNombre,
	    int argTelefono,
	    String argEMail) {

// El test usa un método que le da como argumentos de entrada un nombre y tarifa aleatorios
//0. Excepciones
	
		Persona personaVacia = new Persona();

    try {personaVacia.setNIF(argNIF);}
    catch (IllegalArgumentException exception) {
    	if (argNIF == "" || argNIF == null)  assertEquals("Exception: NIF vacío",exception.getMessage());
    	if (!Valido.validarNIF(argNIF)) assertEquals("Exception: NIF incorrecto",exception.getMessage());}

 		try {personaVacia.setNombre(argNombre);}
	  catch (IllegalArgumentException exception) {
	  	if (argNombre == "" || argNombre == null)  assertEquals("Exception: Nombre vacío",exception.getMessage());
  		else if (!Valido.validarNombre(argNombre)) assertEquals("Exception: Nombre incorrecto",exception.getMessage());}	
		
		try {personaVacia.setTelefono(argTelefono);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Telefono incorrecto",exception.getMessage());}

		try {personaVacia.setEMail(argEMail);}
    catch (IllegalArgumentException exception) {
    	if (argEMail == "" || argEMail == null) 	assertEquals("Exception: eMail vacío",exception.getMessage());
			else if (!Valido.validarEMail(argEMail)) 	assertEquals("Exception: eMail incorrecto",exception.getMessage());}}
	
	@ParameterizedTest
	@DisplayName("Persona: Clase")
	@MethodSource("test.TestSourcesValidos#argPersonaValidos")

	void testPersonaBasico(
	    String argNIF,
	    String argNombre,
	    int argTelefono,
	    String argEMail) {

// El método da argumentos válidos. Hay que probar:		
//1. Constructor	
	Persona persona = new Persona(argNIF,argNombre,argTelefono,argEMail); 
	
//2. Setters -> a través del constructor
//3. Getters
	assertEquals(persona.getNIF(),argNIF);
	assertEquals(persona.getNombre(),argNombre);
	assertEquals(persona.getTelefono(),argTelefono);
	assertEquals(persona.getEMail(),argEMail);
		
// 4. toString 		
	assertEquals(persona.toString(),Clase.imprimeClase(persona));
	System.out.println(persona);
	}
}