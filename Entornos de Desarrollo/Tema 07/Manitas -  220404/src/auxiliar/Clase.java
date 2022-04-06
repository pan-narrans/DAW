package auxiliar;

// import code.Factura;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* Métodos auxiliares para manipular clases
* @author bfrancoc@gmail.com
* @version 1.2
* @since 22-03-2022
*/	

public class Clase {
	
// METODOS
//imprimeClase

	/** 
	* Es un método que itera por todos los campos de una clase invocando los métodos "getCampo()" para obtener los valores
	* Forma un texto donde cada línea es una concatenación del nombre del campo y su valor
	* La primera línea es el nombre de la clase
	* @author bfrancoc@gmail.com
	* @version 1.1
	* @since 21-03-2022
	* @param objeto Instancia de la clase que se quiere imprimir
	* @return String Una línea para cada campo: Descripcion + Valor. Primera nombre clase
	* @throws IllegalArgumentException Exception si objeto = nulo
	*/	

	
	public static String imprimeClase (Object objeto) throws IllegalArgumentException{
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");} 
		
		StringBuilder resultado = new StringBuilder(); // String iterable

// Primera línea nombre de la clase			
		String nClase = objeto.getClass().getName(); 	// Nombre de la clase (con el nombre del paquete y un punto por delante) 
		nClase = nClase.substring(nClase.indexOf(".") + 1); // Se queda con la parte de la derecha después del punto
		nClase = nClase.toUpperCase(); // En mayúsculas
		
		resultado.append(nClase + "\n"); // Lo mete en la cadena de resultados
		
		getValores(objeto).forEach((k,v) -> resultado.append(Cadena.primeraMayuscula(k) + ": " + v + "\n")); // Pasa la lista de valores a una ristra 	  
	  
	  return resultado.toString();} //Devuelve el string
	
//METODOS

	/** 
	* Es un método que compara dos objetos de la misma clase: original y copia
	* Sólo funciona si los nombres de los campos se definen en minúsculas, y para cada campo hay un getCampo en camelCase	
	* @author bfrancoc@gmail.com
	* @version 1.2
	* @since 28-03-2022
	* @param original Objeto original que se quiere comparar
	* @param copia Objeto copia que se quiere comparar
	* @return boolean Los objetos original y copia son iguales o no
	* @throws IllegalArgumentException Exception si objeto = nulo, o los objetos de distintas clases
	*/	


	public static boolean comparaObjetos (Object original, Object copia) throws IllegalArgumentException{
		if (original == null || copia == null) {throw new IllegalArgumentException("Exception: Objeto nulo");} 
		if (!original.getClass().equals(copia.getClass())) {throw new IllegalArgumentException("Exception: Objetos de distintas clases");}

		Map<String,Object> originalValores = getValores(original);	// Recupera los valores del original
		Map<String,Object> copiaValores = getValores(copia);			 	// Recupera los valores de la copia

		return originalValores.equals(copiaValores);}
/*
		.keySet() // Extrae las claves de original = nombre de los campos (hubiera sido igual con la copia: son objetos de la misma clase)
		.stream() // Iterable
		.map(campo -> originalValores.get(campo).equals(copiaValores.get(campo))) // Comparo los dos valores de la misma posición (campo)
		.reduce(true,Boolean::logicalAnd);} // Reduce boolean. Hace un && de todos los resultados. Si hay uno solo false (dos valores distintos para el mismo campo), el resultado es false
//    .anyMatch (false);}
 * 
 */
	
	/** 
	* Para un objeto cualquiera, devuelve un HashMap con los nombres de los campos como clave y los valores como valor (objetos)
	* Sólo funciona si los nombres de los campos se definen en minúsculas, y para cada campo hay un getCampo en camelCase
	* Los campos no están ordenados	
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 22-03-2022
	* @param objeto Instancia de la clase
	* @return HasMap nCampo y Valor
	* @throws IllegalArgumentException Exception si objeto = nulo
	*/	

	public static Map<String, Object> getValores(Object objeto) throws IllegalArgumentException{
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");} 
		
		String nGetter = "";
		Method getter = null;
		Object valor = null;
		
		Map<String,Object> resultados = new  LinkedHashMap<String,Object>(); // return	
		List<String> nCampos = getNombreCamposList(objeto); // Array con los nombres de los campos
	  		
	  for (String nCampo : nCampos) {
	  	nGetter = "get" + Cadena.primeraMayuscula(nCampo); // Forma el nombre del getCampo asociado al campo 

	  	try {	getter = objeto.getClass().getMethod(nGetter);} // Captura el método con nombre getCampo
			catch (NoSuchMethodException e) {e.printStackTrace();} 
	    
	  	try {valor = getter.invoke(objeto);} // Invoca el método getCampo sobre ese objeto y recupera el valor del campo. 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {e.printStackTrace();}    	
	    
	  	resultados.put(nCampo, valor);} // Mete en el Hash <k,v>
	  		
	  return resultados;}

	
//getAllFields

	/** 
	* Recupera todos los campos de una clase: propios y heredados, públicos y privados
	* Es necesario hacerlo así porque el método Class.getDeclaredFields() no devuelve los heredados
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 2020-03-21
	* @param objeto Objeto de la clase de la que se quieren obtener los campos
	* @return List Lista con los campos (tipo Field)
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  	
	
	public static List<Field> getAllFields(Object objeto) throws IllegalArgumentException {
		if (objeto == null) {throw new IllegalArgumentException("Exception: Clase nula");}
		
		List<Field> fields = new ArrayList<Field>();
      
    for (Class<?> c = objeto.getClass(); c != null; c = c.getSuperclass()) { // Recorre la jeraquía de la clase
          fields.addAll(Arrays.asList(c.getDeclaredFields()));} // Va añadiendo los campos
      
    return fields;}

	/** 
	* Recupera todos los métodos de una clase: propios y heredados, públicos y privados
	* Es necesario hacerlo así porque el método Class.getDeclaredMethods() no devuelve los heredados
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 2020-03-25
	* @param objeto Objeto de la clase de la que se quieren obtener los campos
	* @return List Lista con los métodos (tipo Method)
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  	
	
	public static List<Method> getAllMethods(Object objeto) throws IllegalArgumentException {
		if (objeto == null) {throw new IllegalArgumentException("Exception: Clase nula");}
		
		List<Method> methods = new ArrayList<Method>();
      
    for (Class<?> c = objeto.getClass(); c != null; c = c.getSuperclass()) { // Recorre la jeraquía de la clase
          methods.addAll(Arrays.asList(c.getDeclaredMethods()));} // Va añadiendo los métodos
      
    return methods;}
	
/** 
	* Recupera los nombres de todos los campos de una clase: propios y heredados, públicos y privados
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 2020-03-22
	* @param objeto Objeto de la clase de la que se quieren obtener los campos
	* @return List Lista con los nombres de los getCampos (tipo String)
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  		
	
	public static List<String> getNombreCamposList (Object objeto) throws IllegalArgumentException {
		if (objeto == null) {throw new IllegalArgumentException("Exception: Clase nula");}
		
		List<Field> campos = Clase.getAllFields(objeto); // Recupera todos los campos (Field)
      
		return campos
				.stream() // Iterable
				.map(Field::getName) // Toma el nombre de los Field (method reference)
				.collect(Collectors.toList());} // Des-iterable

	/** 
	* Imprime solo los nombres de los campos que contienen cierto texto. Si está en blanco, todos los campos
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @param objeto Instancia que se quiere imprimir
	* @param texto Sólo imprime los campos que tengan ese texto. Si es "" imprime todos
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  		


//No hay return porque se trata de hacer un syso de los campos: devuelve void
//El próximo método devuelve la ristra de nombres (String)	
	
	public static void imprimeNombreCampos(Object objeto, String texto) throws IllegalArgumentException {	
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");}
		if (texto == null) {throw new IllegalArgumentException("Exception: Texto nulo");}
		
		List<Field> campos = Clase.getAllFields(objeto); // Recupera todos los campos de una clase
      
		campos
			.stream() // Crea un iterable	cuyos elementos son los campos (Field) de la clase										
			.map(Field::getName) // Toma el nombre de los Field (method reference) 											
			.filter(nCampo -> nCampo.contains(texto)) // Filtra los campos que tengan el texto (parámetro de entrada)
			.forEach(campo -> System.out.println(Cadena.primeraMayuscula(campo)));} // Para cada campo imprime una línea con su nombre (primera en mayúscula)

	/** 
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @param objeto Instancia de la que se quiere recuperar el nombre de sus campos
	* @return String Cadena con todos los nombres de los campos separados por un retorno de carro
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  		
	
	public static String getNombreCamposString (Object objeto) throws IllegalArgumentException {
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");}
		
		List<Field> campos = Clase.getAllFields(objeto);   // Recupera todos los campos de una clase
		StringBuilder chorizo = new StringBuilder(); // Java quiero y no puedo: String no es iterable.
      
		campos
			.stream()  // Crea un iterable	cuyos elementos son los campos (Field) de la clase. Java quiero y no puedo: List no es iterable.
			.map(Field::getName) // Toma el nombre del campo. A map le paso una funcion, como method reference
			.map(Cadena::primeraMayuscula)  // Pone la primera en mayúscula
			.forEach(campo -> chorizo.append(campo + "\n")); // Concatena con un retorno de carro. Es un reduce: convierte n nombres de campo a una sola cosa, el chorizo)
		
		return chorizo.toString();} // Java quiero y no puedo: tengo que deshacer lo del StringBuilder	
	
	/** 
	* Recupera los nombres de todos los campos de una clase: propios y heredados, públicos y privados
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 2020-03-22
	* @param objeto Objeto de la clase de la que se quieren obtener los campos
	* @return List Lista con los nombres de los getCampos (tipo String)
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  		
	
	public static List<String> getNombreMetodosList (Object objeto) throws IllegalArgumentException {
		if (objeto == null) {throw new IllegalArgumentException("Exception: Clase nula");}
		
		List<Method> campos = Clase.getAllMethods(objeto); // Recupera todos los campos (Field)
      
		return campos
				.stream() // Iterable
				.map(Method::getName) // Toma el nombre de los Field (method reference)
				.collect(Collectors.toList());} // Des-iterable

	/** 
	* Imprime solo los nombres de los campos que contienen cierto texto. Si está en blanco, todos los campos
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @param objeto Instancia que se quiere imprimir
	* @param texto Sólo imprime los campos que tengan ese texto. Si es "" imprime todos
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  		


//No hay return porque se trata de hacer un syso de los metodos: devuelve void
//El próximo método devuelve la ristra de nombres (String)	
	
	public static void imprimeNombreMetodos(Object objeto, String texto) throws IllegalArgumentException {	
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");}
		if (texto == null) {throw new IllegalArgumentException("Exception: Texto nulo");}
		
		List<Method> metodos = Clase.getAllMethods(objeto); // Recupera todos los metodos de una clase
      
		metodos
			.stream() // Crea un iterable	cuyos elementos son los metodos (Method) de la clase										
			.map(Method::getName) // Toma el nombre de los Method (method reference) 											
			.filter(nMetodo -> nMetodo.contains(texto)) // Filtra los metodos que tengan el texto (parámetro de entrada)
			.forEach(metodo -> System.out.println(Cadena.primeraMayuscula(metodo)));} // Para cada metodo imprime una línea con su nombre (primera en mayúscula)

	/** 
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @param objeto Instancia de la que se quiere recuperar el nombre de sus metodos
	* @return String Cadena con todos los nombres de los metodos separados por un retorno de carro
	* @throws IllegalArgumentException Exception si clase = nulo
	*/		  		
	
	public static String getNombreMetodosString (Object objeto) throws IllegalArgumentException {
		if (objeto == null) {throw new IllegalArgumentException("Exception: Objeto nulo");}
		
		List<Method> metodos = Clase.getAllMethods(objeto);   // Recupera todos los metodos de una clase
		StringBuilder chorizo = new StringBuilder(); // Java quiero y no puedo: String no es iterable.
      
		metodos
			.stream()  // Crea un iterable	cuyos elementos son los metodos (Method) de la clase. Java quiero y no puedo: List no es iterable.
			.map(Method::getName) // Toma el nombre del metodo. A map le paso una funcion, como method reference
			.map(Cadena::primeraMayuscula)  // Pone la primera en mayúscula
			.forEach(metodo -> chorizo.append(metodo + "\n")); // Concatena con un retorno de carro. Es un reduce: convierte n nombres de metodo a una sola cosa, el chorizo)
		
		return chorizo.toString();} // Java quiero y no puedo: tengo que deshacer lo del StringBuilder	
	
//MAIN	

	public static void main(String[] args) {
/*		
		System.out.println(
		Aleatorio.getIntList(-10, 10, 100)
		.stream()
		.map(valor -> valor*2)
		.filter(valor -> valor > 0)
		.reduce(0,Integer::sum));


		Clase.getNombreMetodosList(factura)
		.stream()
		.filter(metodo -> metodo.contains("get")) 
		.forEach(System.out::println);
	
		
		Factura factura = new Factura(1,"19/03/2022","12755355S","06023717V","Rotura de Tubería",1000,0.21,0.20);
		Factura copia = new Factura(1,"19/03/2022","12755355S","06023717V","Rotura de tubería",1000,0.21,0.20);	
		System.out.println(comparaObjetos(factura,factura));
		System.out.println(comparaObjetos(factura,copia));
	
		
		System.out.println(imprimeClase(factura));	
		System.out.println(Clase.getNombreCamposString(factura));				
		System.out.println(Clase.getValores(factura));
*/	
	}

}