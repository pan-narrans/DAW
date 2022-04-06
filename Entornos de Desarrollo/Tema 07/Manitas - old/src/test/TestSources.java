package test;

import auxiliar.Aleatorio;
import code.ServicioTipos;
import code.Scoring;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;

public class TestSources {
	
//ARGFACTURA: Argumentos para crear una factura	
public static ArrayList<Arguments> argFactura (){	
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
    
//Bucle: genera 20 valores de prueba aleatorios
   for (int i = 0; i < 20; i++) {
     argId = Aleatorio.darInt(-100,100);	// Id entre -100 y 100 														
     argFecha = Aleatorio.darString(Aleatorio.darInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argCIFEmisor = Aleatorio.darString(Aleatorio.darInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argCIFReceptor = Aleatorio.darString(Aleatorio.darInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argDescripcion = Aleatorio.darString(Aleatorio.darInt(0, 10)); // String aleatorio de 0 a 10 caracteres
     argBase = Aleatorio.darDouble(-1000.0, 1000.0, 1);	// base entre 0 y 1000
     argIvaTipo = Aleatorio.darDouble(-10.0, 10.0, 1);	// iva entre -10 y 10
     argRetencionTipo = Aleatorio.darDouble(-10.0, 10.0, 1);	// retencion entre -10 y 10
       
     argumentosLista.add(Arguments.of(argId,argFecha,argCIFEmisor,argCIFReceptor,argDescripcion,argBase,argIvaTipo,argRetencionTipo));} // Añade los argumentos al Array
 
   return argumentosLista;}

//ARGPERSONA: Argumentos para crear una persona	
public static ArrayList<Arguments> argPersona (){	
	ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  

//Bucle: genera 20 valores de prueba aleatorios
  for (int i = 0; i < 20; i++) {
    argNIF = Aleatorio.darString(Aleatorio.darInt(0, 10));  	// String aleatorio de 0 a 10 caracteres
    argNombre = Aleatorio.darString(Aleatorio.darInt(0, 10));	// String aleatorio de 0 a 10 caracteres
  	argTelefono = Aleatorio.darInt(500000000,1100000000); 	// Teléfono entre 500 000 000 y 1 100 000 000
    argEMail = Aleatorio.darString(Aleatorio.darInt(0, 10));	// String aleatorio de 0 a 10 caracteres
        
    argumentosLista.add(Arguments.of(argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argumentosLista;}

//ARGCLIENTE: Argumentos para crear un cliente
public static ArrayList<Arguments> argCliente (){	
	ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	int argId = 0;	
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  
//Bucle: genera 20 valores de prueba aleatorios
  for (int i = 0; i < 20; i++) {
  	argId = Aleatorio.darInt(-100,100); 										// id entre -100 y 100
  	argNIF = Aleatorio.darString(Aleatorio.darInt(0, 10));  	// String aleatorio de 0 a 10 caracteres
    argNombre = Aleatorio.darString(Aleatorio.darInt(0, 10));	// String aleatorio de 0 a 10 caracteres
  	argTelefono = Aleatorio.darInt(500000000,1100000000); 	// Teléfono entre 500 000 000 y 1 100 000 000
    argEMail = Aleatorio.darString(Aleatorio.darInt(0, 10));	// String aleatorio de 0 a 10 caracteres
        
    argumentosLista.add(Arguments.of(argId,argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argumentosLista;}

// ARGCOLABORADOR: Argumentos para craar un colaborador	
	public static ArrayList<Arguments> argColaborador (){
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
  
// Bucle: genera 10 valores de prueba aleatorios
    for (int i = 0; i < 10; i++) {
	  	argId = Aleatorio.darInt(-100,100); 												// id entre -100 y 100
    	argServicio = ServicioTipos.getRandomTipoServicio();		// Tipo Servicio Aleatorio
      argScoring = Scoring.getRandomTipoScoring();	// Tipo Scoring Aleatorio
      argTarifa = Aleatorio.darDouble(-100, 100, 2);							// Tarifa entre -100 y 100 a 2 decimales
      argDisponible = Aleatorio.darBoolean();										// true o false aleatorio
    
      argNIF = Aleatorio.darString(Aleatorio.darInt(0, 10));		// String aleatorio de 0 a 10 caracteres. Muy mejorable
      argNombre = Aleatorio.darString(Aleatorio.darInt(0, 10));	// String aleatorio de 0 a 10 caracteres
	  	argTelefono = Aleatorio.darInt(500000000,1100000000); 	// Teléfono entre 500 000 000 y 1 100 000 000
	    argEMail = Aleatorio.darString(Aleatorio.darInt(0, 10));	// String aleatorio de 0 a 10 caracteres
      
      argLista.add(Arguments.of(
      	argId,argServicio,argScoring,argTarifa,argDisponible,
      	argNombre,argNIF,argTelefono,argEMail));} 		// Añade los argumentos a la lista

    return argLista;  
  }
	
//ARGSERVICIO: Argumentos para craar un servicio  
	public static ArrayList<Arguments> argServicio (){
			ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>();  // Lista de argumentos devueltos
			
	// Argumentos que irán en el Array   
	    int argId = 0;
			String argFecha = "";
			String argNombre = "";
	    double argHoras = 0.0;
	         
	// Bucle: genera 10 valores de prueba aleatorios
	    for (int i = 0; i < 20; i++) {
	      argId = Aleatorio.darInt(-100, 100); // id entre -100 y 100
	      argFecha = Aleatorio.darString(Aleatorio.darInt(0, 10)); // Mejorable: una fecha "real"
	    	argNombre = Aleatorio.darString(Aleatorio.darInt(0, 10)); // String de 0 a 10
	      argHoras = Aleatorio.darDouble(-100, 100, 2);			// Tarifa entre -100 y 100 a 2 decimales
	      
	      argumentosLista.add(Arguments.of(argId, argFecha,argNombre,argHoras));} 	// Añade los argumentos al Array
	  
	    return argumentosLista;  
	  }

}