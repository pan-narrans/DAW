package auxiliar;

import java.util.ArrayList;
import java.util.List;

/** 
* Métodos auxiliares para manipular Strings
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
*/	

public class Cadena {
	
// METODOS
// primeraMayuscula	

	/** 
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 23-03-2022
	* @param palabra
	* @return String Palabra con la primera en mayúscula
	* @throws IllegalArgumentException Exception si palabra está vacía o es nula
	*/		  		
	
	public static String primeraMayuscula (String palabra) throws IllegalArgumentException {
	// Pone la primera letra de palabra en mayúscula	
		if (palabra == "" | palabra == null) throw new IllegalArgumentException("Exception: Cadena vacía"); // Protección 
		
		String primeraLetra = String.valueOf(palabra.charAt(0)).toUpperCase(); // Toma el primer carácter y lo pone en mayúscula
    return primeraLetra + palabra.substring(1); // Devuelve la primera letra junto con el resto de la cadena 
	}	

	public static void main(String[] args) {
		
		List<String> nombre = new ArrayList<String>();
		
		nombre.add("benito");
		nombre.stream().map(String::toUpperCase).forEach(System.out::println);
		nombre.stream().map(Cadena::primeraMayuscula).forEach(System.out::println);
		
	}
}