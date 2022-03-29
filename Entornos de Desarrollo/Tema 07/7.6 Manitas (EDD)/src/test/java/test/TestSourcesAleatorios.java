package test;

import auxiliar.Aleatorio;
import code.ServicioTipos;
import code.Scoring;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;

public class TestSourcesAleatorios {
	
	private static int nValores = 20; // Número de valores que se pasan en los vectores
	
//ARGFACTURA: Argumentos para crear una factura	
	public static ArrayList<Arguments> argFacturaAleatorios () {	
		ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
		
//Argumentos que irán en el Array   
   int argId = 0;	
   String argFecha = "";
   String argCIFEmisor = "";
   String argCIFReceptor = "";
   String argDescripcion = "";
   double argBase = 0.0;
   double argIvaTipo = 0.0;
   double argRetencionTipo = 0.0;
    
//Bucle: genera nValores valores de prueba aleatorios
   for (int i = 0; i < nValores; i++) {
     argId = Aleatorio.getInt(-100,100);	// Id entre -100 y 100 														
     argFecha = Aleatorio.getString(Aleatorio.getInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argCIFEmisor = Aleatorio.getString(Aleatorio.getInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argCIFReceptor = Aleatorio.getString(Aleatorio.getInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argDescripcion = Aleatorio.getString(Aleatorio.getInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argBase = Aleatorio.getDouble(-1000.0, 1000.0, 1);	// base entre 0 y 1000
     argIvaTipo = Aleatorio.getDouble(-10.0, 10.0, 1);	// iva entre -10 y 10
     argRetencionTipo = Aleatorio.getDouble(-10.0, 10.0, 1);	// retencion entre -10 y 10
       
     argumentosLista.add(Arguments.of(argId,argFecha,argCIFEmisor,argCIFReceptor,argDescripcion,argBase,argIvaTipo,argRetencionTipo));} // Añade los argumentos al Array
 
   return argumentosLista;}

//ARGPERSONA: Argumentos para crear una persona	
public static ArrayList<Arguments> argPersonaAleatorios (){	
	ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  

//Bucle: genera nValores valores de prueba aleatorios
  for (int i = 0; i < nValores; i++) {
  	argNIF = Aleatorio.getString(Aleatorio.getInt(0, 10));  	// String aleatorio de 0 a 10 caracteres
    argNombre = Aleatorio.getString(Aleatorio.getInt(1, 10));	// String aleatorio de 0 a 10 caracteres
  	argTelefono = Aleatorio.getInt(500000000,1100000000); 	// Teléfono entre 500 000 000 y 1 100 000 000
    argEMail = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
        
    argumentosLista.add(Arguments.of(argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argumentosLista;}

//ARGCLIENTE: Argumentos para crear un cliente
public static ArrayList<Arguments> argClienteAleatorios (){	
	ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	int argId = 0;	
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  
//Bucle: genera nValores valores de prueba aleatorios
  for (int i = 0; i < nValores; i++) {
  	argId = Aleatorio.getInt(-100,100); 										// id entre -100 y 100
  	argNIF = Aleatorio.getString(Aleatorio.getInt(0, 10));  	// String aleatorio de 0 a 10 caracteres
    argNombre = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
  	argTelefono = Aleatorio.getInt(500000000,1100000000); 	// Teléfono entre 500 000 000 y 1 100 000 000
    argEMail = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
        
    argumentosLista.add(Arguments.of(argId,argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argumentosLista;}

// ARGCOLABORADOR: Argumentos para craar un colaborador	
	public static ArrayList<Arguments> argColaboradorAleatorios (){
  	ArrayList<Arguments> argLista = new ArrayList<Arguments>(); // Lista de argumentos devueltos 
   
// Argumentos
  	int argId = 0;
    ServicioTipos argServicio = null;
    Scoring argScoring = null;
    double argTarifa = 0.0;  
    boolean argDisponible = false; 

    String argNombre = "";
    String argNIF = "";
		int argTelefono = 0;	
	  String argEMail = "";
  
// Bucle: genera nValores valores de prueba aleatorios
    for (int i = 0; i < nValores; i++) {
	  	argId = Aleatorio.getInt(-100,100); 												// id entre -100 y 100
    	argServicio = ServicioTipos.getRandomTipoServicio();		// Tipo Servicio Aleatorio
      argScoring = Scoring.getRandomTipoScoring();	// Tipo Scoring Aleatorio
      argTarifa = Aleatorio.getDouble(-100, 100, 2);							// Tarifa entre -100 y 100 a 2 decimales
      argDisponible = Aleatorio.getBoolean();										// true o false aleatorio
    
      argNIF = Aleatorio.getString(Aleatorio.getInt(0, 10));		// String aleatorio de 0 a 10 caracteres. Muy mejorable
      argNombre = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
	  	argTelefono = Aleatorio.getInt(500000000,1100000000); 	// Teléfono entre 500 000 000 y 1 100 000 000
	    argEMail = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
      
      argLista.add(Arguments.of(
      	argId,argServicio,argScoring,argTarifa,argDisponible,
      	argNombre,argNIF,argTelefono,argEMail));} 		// Añade los argumentos a la lista

    return argLista;  
  }
	
//ARGSERVICIO: Argumentos para crear un servicio  
	public static ArrayList<Arguments> argServicioAleatorios (){
			ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>();  // Lista de argumentos devueltos
			
	// Argumentos que irán en el Array   
	    int argId = 0;
			String argFecha = "";
			String argNombre = "";
	    double argHoras = 0.0;
	         
	// Bucle: genera nValores valores de prueba aleatorios
	    for (int i = 0; i < nValores; i++) {
	      argId = Aleatorio.getInt(-100, 100); // id entre -100 y 100
	      argFecha = Aleatorio.getString(Aleatorio.getInt(0, 10)); // Mejorable: una fecha verosimil pero inválida
	    	argNombre = Aleatorio.getString(Aleatorio.getInt(0, 10)); // String de 0 a 10
	      argHoras = Aleatorio.getDouble(-100, 100, 2);			// Tarifa entre -100 y 100 a 2 decimales
	      
	      argumentosLista.add(Arguments.of(argId, argFecha,argNombre,argHoras));} 	// Añade los argumentos al Array
	  
	    return argumentosLista;  
	  }
}