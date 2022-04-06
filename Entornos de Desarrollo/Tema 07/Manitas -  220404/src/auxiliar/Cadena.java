package auxiliar;

import java.util.ArrayList;
import java.util.List;

/** 
* M�todos auxiliares para manipular Strings
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
	* @return String Palabra con la primera en may�scula
	* @throws IllegalArgumentException Exception si palabra est� vac�a o es nula
	*/		  		
	
	public static String primeraMayuscula (String palabra) throws IllegalArgumentException {
	// Pone la primera letra de palabra en may�scula	
		if (palabra == "" | palabra == null) throw new IllegalArgumentException("Exception: Cadena vac�a"); // Protecci�n 
		
		String primeraLetra = String.valueOf(palabra.charAt(0)).toUpperCase(); // Toma el primer car�cter y lo pone en may�scula
    return primeraLetra + palabra.substring(1); // Devuelve la primera letra junto con el resto de la cadena 
	}	

	public static void main(String[] args) {
		
		List<String> nombre = new ArrayList<String>();
		
		nombre.add("benito");
		nombre.stream().map(String::toUpperCase).forEach(System.out::println);
		nombre.stream().map(Cadena::primeraMayuscula).forEach(System.out::println);
		
	}
}