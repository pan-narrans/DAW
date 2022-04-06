package auxiliar;

import java.util.regex.*;

public class Valido {
	
	public static String darNIFValido() {
		int numeroDNIint = 0;
		String numerosDNIString = "";
		
		for (int i = 0;i < 8;i++) {
			numeroDNIint = Aleatorio.darInt(0,9);                 // Valor aleatorio entre 0 y 9
			numerosDNIString += String.valueOf(numeroDNIint);}    // Lo paso a String y concateno
		return numerosDNIString += letraDNI(numerosDNIString);} // Al acabar el bucle le pego la letra válida
		
	public static String darNombreValido() {
		String nombre = Aleatorio.darString(10);   // Cadena aleatoria de 8
		String apellido = Aleatorio.darString(10);	
		
		nombre = Cadena.primeraMayuscula(nombre);			// Pone la primera en mayúscula
		apellido = Cadena.primeraMayuscula(apellido);
		
		return nombre + " " + apellido;} // Devuelve el valor concatenado por un espacio
		
	public static String darEMailValido() {
		String usuario = Aleatorio.darString(8);	// Cadena aleatoria de 8
		String dominio = Aleatorio.darString(6);	// Cadena aleatoria de 6
	
		return usuario + "@" + dominio + ".com";}				// Concatena @ y .com

	public static int darTelefonoValido() {
		return Aleatorio.darInt(600000000, 799999999);}

	public static boolean validarNIF(String NIF) {
		String regex = "^([0-9]){8}([A-Z]){1}$"; // Valida primero que el NIF sean 8 dígitos y una letra
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(NIF);
    if (!m.matches()) {return false;} // Si no lo son devuelve false  
    return (NIF.substring(8).equals(letraDNI(NIF.substring(0, 8))));} // Si lo son compara la letra

  public static boolean validarNombre(String Nombre) {
   String regex = "^[A-Z]{1}[a-z]{1,20}\s[A-Z]{1}[a-z]{1,20}$";
   Pattern p = Pattern.compile(regex);
   Matcher m = p.matcher(Nombre);
   return  m.matches();}

  public static boolean validarTelefono(int telefono) {
        String regex = "^(6|7)([0-9]){8}";
        String telefonoString = String.valueOf(telefono);
  			
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(telefonoString);
        return m.matches();}
 
  public static boolean validarEMail(String EMail) {
	   String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	
	   Pattern p = Pattern.compile(regex);
	   Matcher m = p.matcher(EMail);
	   return  m.matches();}
		
	
	private static String letraDNI(String numerosDNI) throws IllegalArgumentException {
	// El método es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella		
		
	 int numerosDNIint = Integer.parseInt(numerosDNI); 
		
	// Exception: números inválidos	
		if (numerosDNIint <=0 | numerosDNIint > 100000000) {throw new IllegalArgumentException("Exception: Numeros del DNI no válidos");}
//		int miDNI = Integer.parseInt(this.dni.substring(0,8));
	
		int resto = 0;

		String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		resto =  numerosDNIint % 23;
		return asignacionLetra[resto];
	}

// MAIN
	public static void main(String[] args) {

		System.out.println(letraDNI("06023717"));
		System.out.println(validarNIF("06023717V"));			
		System.out.println(validarNombre("Benito Franco"));
		System.out.println(validarEMail("bfrancoc@gmail.com"));
		for (int i = 0; i < 10; i++) {
			System.out.println(darNIFValido());}	
	}
}