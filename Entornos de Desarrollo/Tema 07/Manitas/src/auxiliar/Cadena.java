package auxiliar;

public class Cadena {
	
// METODOS
// primeraMayuscula	
		
	public static String primeraMayuscula (String palabra) throws IllegalArgumentException {
	// Pone la primera letra de palabra en may�scula	
		if (palabra == "") throw new IllegalArgumentException("Exception: Cadena vac�a"); // Protecci�n 
		
		String primeraLetra = String.valueOf(palabra.charAt(0)).toUpperCase(); // Toma el primer car�cter y lo pone en may�scula
    return primeraLetra + palabra.substring(1); // Devuelve la primera letra junto con el resto de la cadena 
	}	
}