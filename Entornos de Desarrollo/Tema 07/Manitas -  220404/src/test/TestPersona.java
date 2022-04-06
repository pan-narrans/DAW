package test;

import code.Persona;

import auxiliar.Clase;

// Junit
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestPersona {

	@ParameterizedTest
	@DisplayName("Persona: Excepciones")
	@MethodSource("test.TestSourcesAleatorios#argPersonaAleatorios")

	void testPersonaExcepciones(
	    String argNIF,
	    String argNombre,
	    int argTeléfono,
	    String argEMail) {

// El test usa un m�todo que le da como argumentos de entrada un nombre y tarifa aleatorios
//0. Excepciones
	
		Persona personaVacia = new Persona();

    try {personaVacia.setNIF(argNIF);}
    catch (IllegalArgumentException exception) {
     	if (argNIF == "" || argNIF == null)  assertEquals("Exception: NIF vacío",exception.getMessage());
     	else assertEquals("Exception: NIF incorrecto",exception.getMessage());}
//     	else if (!Valido.validarNIF(argNIF)) assertEquals("Exception: NIF incorrecto",exception.getMessage());}

 		try {personaVacia.setNombre(argNombre);}
	  catch (IllegalArgumentException exception) {
	  	if (argNombre == "" || argNombre == null)  assertEquals("Exception: Nombre vacío",exception.getMessage());
  		else assertEquals("Exception: Nombre incorrecto",exception.getMessage());}	
		
		try {personaVacia.setTeléfono(argTeléfono);}
		catch (IllegalArgumentException exception) {assertEquals("Exception: Teléfono incorrecto",exception.getMessage());}

		try {personaVacia.setEMail(argEMail);}
    catch (IllegalArgumentException exception) {
    	if (argEMail == "" || argEMail == null) 	assertEquals("Exception: eMail vacío",exception.getMessage());
			else assertEquals("Exception: eMail incorrecto",exception.getMessage());}}
	
	@ParameterizedTest
	@DisplayName("Persona: Clase")
	@MethodSource("test.TestSourcesValidos#argPersonaValidos")

	void testPersonaBasico(
	    String argNIF,
	    String argNombre,
	    int argTeléfono,
	    String argEMail) {

// El m�todo da argumentos válidos. Hay que probar:		
//1. Constructor	
	Persona personaTest = new Persona(argNIF,argNombre,argTeléfono,argEMail); 
	
//2. Setters -> a través del constructor
//3. Getters
	assertEquals(personaTest.getNIF(),argNIF);
	assertEquals(personaTest.getNombre(),argNombre);
	assertEquals(personaTest.getTeléfono(),argTeléfono);
	assertEquals(personaTest.getEMail(),argEMail);
		
//4. toString 		
	assertEquals(personaTest.toString(),Clase.imprimeClase(personaTest));
	System.out.println(personaTest);

//5. equals 		
	assertTrue(personaTest.equals(personaTest));	
	}
}