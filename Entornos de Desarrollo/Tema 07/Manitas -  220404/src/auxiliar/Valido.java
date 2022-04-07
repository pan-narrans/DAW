package auxiliar;

import java.util.regex.*;

/** 
* Métodos auxiliares para validar valores
* @author bfrancoc@gmail.com
* @version 1.3
* @since 28-03-2022
*/	



public class Valido {
	
// NIF	

  private static final int NIFMin = 1; 
  private static final int NIFMax = 99999999;
	
  /** 
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 22-03-2022 
	* @param numerosDNI Los números para los que se quiere calcular la letra, como String
	* @return String La letra de esos números
	* @throws IllegalArgumentException Si los números est�n fuera de rango
	*/		  		
	
	private static String letraDNI(String numerosDNI) throws IllegalArgumentException {
		int numerosDNIint = Integer.parseInt(numerosDNI); 
		if (numerosDNIint < NIFMin || numerosDNIint > NIFMax) {throw new IllegalArgumentException("Exception: Numeros del DNI no válidos");}
		
		String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		return asignacionLetra[numerosDNIint % 23];} // La letra es la posici�n del array del resto al dividir los números entre 23

  /** 
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 22-03-2022
	* @param NIF
	* @return boolean Si el NIF es correcto o no (tiene bien el formato y la letra)
	* @throws IllegalArgumentException Si el NIF est� vacío
	*/		  		
	
	public static boolean validarNIF(String NIF) throws IllegalArgumentException {
		if (NIF == "" || NIF == null) {throw new IllegalArgumentException("Exception: NIF vacío");}
		
		String regex = "^([0-9]){8}([A-Z]){1}$"; // regex de un pseudo NIF: 8 números y una letra
    Pattern p = Pattern.compile(regex); // Validamos el regex
    NIF = NIF.toUpperCase(); // El método letraDNI devuelve mayúsculas, y la regex es para mayúsculas 
    Matcher m = p.matcher(NIF);   
    if (!m.matches()) {return false;}  // Si no es pseudo NIF sale con false
    return NIF.substring(8).equals(letraDNI(NIF.substring(0, 8)));}	// Si es pseudo NIF comprueba la letra, que tiene que coincidir
	
  /** 
	* @author bfrancoc@gmail.com
	* @version 1.0
	* @since 22-03-2022
	* @return String Un NIF válido
	*/		  			
	
	public static String getNIFValido() {
		int numerosDNI = Aleatorio.getInt(NIFMin,NIFMax); // genera un num aleatorio en el rango válido
		String numerosDNIString = String.format("%08d", numerosDNI); // lo convierte a una cadena llenando de ceros por la izquierda
		return  numerosDNIString + letraDNI(numerosDNIString); // le pega la letra
		}
	
// NOMBRE
	
/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @param nombre El nombre que se quiere validar
* @return boolean El nombre es válido si son dos palabras separadas por un espacio y la primera de cada en may�scula
* @throws IllegalArgumentException Si el nombre est� vacío
*/		  			
		
  public static boolean validarNombre(String nombre) throws IllegalArgumentException {
		if (nombre == "" || nombre == null) {throw new IllegalArgumentException("Exception: Nombre vacío");}
		
    String regex = "^[A-Z]{1}[a-z]{1,20}\s[A-Z]{1}[a-z]{1,20}$"; // regex de un pseudo nombre: dos palabras que empiezan por may�scula
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(nombre);
    return  m.matches();}

/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @return String Un nombre válido: dos palabras separadas por un espacio y la primera de cada en may�scula
*/		  			  
  
	public static String getNombreValido() {
		String nombre = Cadena.primeraMayuscula(Aleatorio.getString(10));
		String apellido =  Cadena.primeraMayuscula(Aleatorio.getString(10));	
		return nombre + " " + apellido;}  
  
// EMAIL
	
/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @param eMail
* @return boolean Si el eMail es correcto (regex)
* @throws IllegalArgumentException Si el eMail est� vacío
*/		  		
	
  public static boolean validarEMail(String eMail)  throws IllegalArgumentException {
		if (eMail == "" || eMail == null) {throw new IllegalArgumentException("Exception: eMail vacío");}
		
	   String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"; // regex de un email válido
	   Pattern p = Pattern.compile(regex);
	   Matcher m = p.matcher(eMail);
	   return  m.matches();}

/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @return String Un email verosimil
*/	  

	public static String getEMailValido() {
		String usuario = Aleatorio.getString(8); // usuario
		String dominio = Aleatorio.getString(6); // dominio
		return usuario + "@" + dominio + ".com";}

// TELÉFONO

  private static final int telMin = 600000000; 
  private static final int telMax = 799999999;

/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @param teléfono
* @return boolean Si el tel�fono es un m�vil válido en Espa�a
*/		  			
  
  
  public static boolean validarTeléfono(int teléfono) {
  	return (teléfono >= telMin && teléfono <= telMax);}

/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @return int Un tel�fono m�vil válido en Espa�a
*/	  
 
  public static int getTeléfonoValido() {
		return Aleatorio.getInt(telMin, telMax);}

// FECHA  
	  
  private static final int [] mesesDias = {31,28,31,30,31,30,31,31,30,31,30,31}; // Array con los d�as de cada mes
  private static final int anioMin = 1900;
  private static final int anioMax = 2100;

/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @param fecha String con la fecha en formato dd/mm/yyyy
* @return boolean Una fecha correcta (teniendo en cuenta bisiestos)
* @throws IllegalArgumentException Si la fecha est� vacío
*/		  		
 
// Es una carrera de obst�culos: solo llegas al final si pasas las validaciones: mejora? el rendimiento
  
  public static boolean validarFecha (String fecha)  throws IllegalArgumentException {
		if (fecha == "" || fecha == null) {throw new IllegalArgumentException("Exception: Fecha vacía");}
	
// Me quito morralla con un regex		
		String regex = "^[0-3]{1}[0-9]{1}/[0-1]{1}[0-9]{1}/[0-9]{4}$"; // regex de una pseudo fecha: dd/mm/yyyy
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(fecha);    
    if (!m.matches()) {return false;}
    
// Valido la pseudo fecha: podr�a haberse colado 39/01/3000
    int dia = Integer.parseInt(fecha.substring(0, 2));
    int mes = Integer.parseInt(fecha.substring(3, 5));		
    int anio = Integer.parseInt(fecha.substring(6, 10)); 	
    boolean bisiesto =  ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))); 

    if (anio < anioMin || anio > anioMax) {return false;} // a�o válido
    if (mes < 0 || mes > 12) {return false;} // mes válido
    if (bisiesto && mes == 2 && dia == 29) {return true;} // si es 29 de febreo de un bisiesto, est� bien
    if (dia <0 || dia > mesesDias[mes-1]) {return false;} // si no el d�a tiene que estar en el rango del mes
    return true;} // si has llegado hasta aqu� es que eres una fecha válida

/** 
* @author bfrancoc@gmail.com
* @version 1.0
* @since 22-03-2022
* @return String con la fecha en formato dd/mm/yyyy
*/		  		  
  
  public static String getFechaValida () {
  	
    String fecha = "";
  	int anio = Aleatorio.getInt(anioMin, anioMax);
    int meses = Aleatorio.getInt(1, 12);
    int dias = Aleatorio.getInt(1, mesesDias[meses-1]);
  
    boolean bisiesto =  ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))); 
    if (bisiesto && meses == 2 ) {dias = Aleatorio.getInt(1, 29);}
    
    fecha = String.format("%02d", dias) + "/";  	// dias a string con relleno de 0
    fecha += String.format("%02d", meses) + "/";	// meses a string con relleno de 0
    fecha += String.format("%04d", anio); 				// a�os a string con relleno de 0
    return fecha;} 
  
// MAIN

  public static void main(String[] args) {
 	
	  System.out.println(getNIFValido());
	  System.out.println(validarNIF("12755355s"));
  	
// Genera una lista de 100 pseudo-NIFs e imprime s�lo los válidos  	
  	
	  Aleatorio.getIntList(0,100000000, 100) // Genera una lista de 100 números aleatorios entre 0 y 100 millones
	  	.stream() // Iterador
			.map(numero ->  String.format("%02d", numero)) // Lo convierte a un string de 10 números enteros
	  	.map(nombre -> nombre += Character.toString(Aleatorio.getInt(65,90)))	// Le pega una letra may�scula				
	  	.filter(nif -> Valido.validarNIF(nif)) // Filtra los buenos
	  	.forEach(System.out::println);  // Los imprime
	  
// Lo mismo para pseudo-fechas	  
  	
  	Aleatorio.getIntList(0,39,100) // Genera una lista de 100 números aleatorios entre 0 y 39 (parecen d�as del mes)
  		.stream()
  		.map(numero -> String.format("%02d", numero) + "/") // Concatena d�a
  		.map(cadena -> cadena + String.format("%02d",Aleatorio.getInt(0,12)) + "/") // Concatena mes
  		.map(cadena -> cadena + String.format("%04d",Aleatorio.getInt(anioMin,anioMax))) // Concatena a�o
  		.filter(fecha -> validarFecha(fecha)) // Filtra los buenos
  		.forEach(System.out::println);} // Imprime

}	