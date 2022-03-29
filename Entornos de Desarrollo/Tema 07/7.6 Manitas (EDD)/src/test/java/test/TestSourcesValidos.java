package test;

import auxiliar.Aleatorio;
import auxiliar.Valido;
import code.ServicioTipos;
import code.Scoring;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;

public class TestSourcesValidos {
	
	private static final int nValores = 20; // Número de valores que se pasan en los vectores
	
//ARGFACTURA: Argumentos para crear una factura	
	public static ArrayList<Arguments> argFacturaValidos (){	
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
    
//Bucle: genera nValores valores de prueba válidos
   for (int i = 0; i < nValores; i++) {
     argId = Aleatorio.getInt(1,100);				// Id válido														
     argFecha = Valido.getFechaValida(); 		// Fecha Válida
     argCIFEmisor = Valido.getNIFValido(); 	// NIF Válido
     argCIFReceptor = Valido.getNIFValido();// NIF Válido
     argDescripcion = Aleatorio.getString(10); 			// String de 10 caracteres
     argBase = Aleatorio.getDouble(1.0, 1000.0, 1);	// base entre 0 y 1000
     argIvaTipo = Aleatorio.getDouble(0.0,1.0, 1);	// iva entre 0 y 1
     argRetencionTipo = Aleatorio.getDouble(0.0, 1.0, 1);	// retencion entre 0 y 1
       
     argumentosLista.add(Arguments.of(argId,argFecha,argCIFEmisor,argCIFReceptor,argDescripcion,argBase,argIvaTipo,argRetencionTipo));} // Añade los argumentos al Array
 
   return argumentosLista;}

//ARGPERSONA: Argumentos para crear una persona	
public static ArrayList<Arguments> argPersonaValidos (){	
	ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  

//Bucle: genera nValores valores de prueba aleatorios
  for (int i = 0; i < nValores; i++) {
    argNIF = Valido.getNIFValido(); 					// NIF Válido
    argNombre = Valido.getNombreValido(); 		// Nombre válido 
  	argTelefono = Valido.getTelefonoValido(); // Descripción válido
    argEMail = Valido.getEMailValido();				// eMail válido
        
    argumentosLista.add(Arguments.of(argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argumentosLista;}

//ARGCLIENTE: Argumentos para crear un cliente
public static ArrayList<Arguments> argClienteValidos (){	
	ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	int argId = 0;	
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  
//Bucle: genera nValores valores de prueba válidos
  for (int i = 0; i < nValores; i++) {
  	argId = Aleatorio.getInt(1,100); 					// id entre 1 y 100
    argNIF = Valido.getNIFValido(); 					// NIF Válido
    argNombre = Valido.getNombreValido(); 		// Nombre válido 
  	argTelefono = Valido.getTelefonoValido(); // Descripción válido
    argEMail = Valido.getEMailValido();				// eMail válido
        
    argumentosLista.add(Arguments.of(argId,argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argumentosLista;}

// ARGCOLABORADOR: Argumentos para craar un colaborador	
	public static ArrayList<Arguments> argColaboradorValidos (){
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
  
// Bucle: genera nValores valores de prueba válidos
    for (int i = 0; i < nValores; i++) {
	  	argId = Aleatorio.getInt(1,100); 								 			// id entre 1 y 100
    	argServicio = ServicioTipos.getRandomTipoServicio(); 	// Tipo Servicio Aleatorio
      argScoring = Scoring.getRandomTipoScoring();					// Tipo Scoring Aleatorio
      argTarifa = Aleatorio.getDouble(0.0, 100.0, 2);				// Tarifa entre -0 y 100 a 2 decimales
      argDisponible = Aleatorio.getBoolean();								// true o false aleatorio

      argNIF = Valido.getNIFValido(); 					// NIF Válido
      argNombre = Valido.getNombreValido(); 		// Nombre válido 
    	argTelefono = Valido.getTelefonoValido(); // Descripción válido
      argEMail = Valido.getEMailValido();				// eMail válido
      
      argLista.add(Arguments.of(
      	argId,argServicio,argScoring,argTarifa,argDisponible,
      	argNombre,argNIF,argTelefono,argEMail));} 		// Añade los argumentos a la lista

    return argLista;  
  }
	
//ARGSERVICIO: Argumentos para crear un servicio  
	public static ArrayList<Arguments> argServicioValidos (){
			ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>();  // Lista de argumentos devueltos
			
	// Argumentos que irán en el Array   
	    int argId = 0;
			String argFecha = "";
			String argDescripcion = "";
	    double argHoras = 0.0;
	         
	// Bucle: genera nValores valores de prueba válidos
	    for (int i = 0; i < nValores; i++) {
	      argId = Aleatorio.getInt(1, 100); // id entre 1 y 100
	      argFecha = Valido.getFechaValida(); // fecha válida
	    	argDescripcion = Aleatorio.getString(10); 	// String de 10
	      argHoras = Aleatorio.getDouble(0.0, 100.0, 1); // Tarifa entre -100 y 100 a 2 decimales
	      
	      argumentosLista.add(Arguments.of(argId, argFecha,argDescripcion,argHoras));} 	// Añade los argumentos al Array
	  
	    return argumentosLista;  
	  }

}