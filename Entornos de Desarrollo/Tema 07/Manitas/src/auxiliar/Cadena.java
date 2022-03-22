package auxiliar;

public class Cadena {
	
// METODOS
// primeraMayuscula	
		
	public static String primeraMayuscula (String palabra) throws IllegalArgumentException {
	// Pone la primera letra de palabra en mayúscula	
		if (palabra == "") throw new IllegalArgumentException("Exception: Cadena vacía"); // Protección 
		
		String primeraLetra = String.valueOf(palabra.charAt(0)).toUpperCase(); // Toma el primer carácter y lo pone en mayúscula
    return primeraLetra + palabra.substring(1); // Devuelve la primera letra junto con el resto de la cadena 
	}	
}