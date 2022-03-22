package auxiliar;

import java.util.List;

import java.util.Arrays;
import java.util.ArrayList;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* M�todos auxiliares para manipular clases
* @author Benito Franco
* @version 1.1
* @since 2020-03-21
*/	

public class Clase {
	
// METODOS
//imprimeClase

	/** 
	* Es un m�todo que itera por todos los campos de una clase invocando los m�todos "getCampo()" para obtener los valores
	* Forma un texto donde cada l�nea es una concatenaci�n del nombre del campo y su valor
	* La primera l�nea es el nombre de la clase
	* Hay que hacerlo indirectamente, invocando los getCampos(), porque se asume que los campos son private y no se puede acceder a su valor de otra forma
	* S�lo funciona si los nombres de los campos se definen en min�sculas, y para cada campo hay un getCampo en camelCase	
	* @author Benito Franco
	* @version 1.1
	* @since 2020-03-21
	* @param objeto Instancia de la clase que se quiere imprimir
	* @return String Una l�nea para cada campo: Descripcion + Valor. Primera nombre clase
	* @throws IllegalArgumentException Exception si objeto = nulo
	*/	
	
	public static String imprimeClase (Object objeto) throws IllegalArgumentException{
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");} 
		
		String texto = objeto.getClass().getName().toUpperCase();
		texto = texto.substring(texto.indexOf(".") + 1) + "\n"; // Quita el nombre del paquete del nombre de la clase
	
		String nCampo = "";
		String nGetter = "";
		Method getter = null;
		Object valor = new Object();
	  List<Field> campos = null;  
		campos = getAllFields(objeto.getClass()); // Array con los campos (Field) de la clase
	  		
	  for (Field campo : campos) { 	// Itera por todos los campos = forEach
			nCampo =  campo.getName();	// Toma el nombre del campo									//  		
			nCampo = Cadena.primeraMayuscula(nCampo); // Pone la primera en may�scula: camelCase
	  	nGetter = "get" + nCampo; // Forma el nombre del getter: getCampo
	
	  	try {	getter = objeto.getClass().getMethod(nGetter);} // Captura el m�todo con nombre getCampo
			catch (NoSuchMethodException e) {e.printStackTrace();} 
	    
	  	try {valor = getter.invoke(objeto);} // Invoca el m�todo getCampo y recupera el valor del campo. 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {e.printStackTrace();}    	
	    
	  	texto += nCampo + ": " + valor + "\n";} // Crea una l�nea para cada campo: nombre + valor
		
	  return texto;} 
 
	
//getAllFields

	/** 
	* Recupera todos los campos de una clase: propios y heredados, p�blicos y privados
	* Es necesario hacerlo as� porque el m�todo Class.getDeclaredFields() no devuelve los heredados
	* @author Benito Franco
	* @version 1.0
	* @since 2020-03-21
	* @param type Clase de la que se quieren obtener los campos
	* @return List Lista con los campos
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  	
	
	public static List<Field> getAllFields(Class<?> type) throws IllegalArgumentException {
		if (type == null) {throw new IllegalArgumentException("Exception: Clase nula");}
		
		List<Field> fields = new ArrayList<Field>();
      
    for (Class<?> c = type; c != null; c = c.getSuperclass()) { // Recorre la jeraqu�a de la clase
          fields.addAll(Arrays.asList(c.getDeclaredFields()));} // Va a�adiendo los campos
      
    return fields;}
}