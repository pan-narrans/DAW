package test;

import auxiliar.Aleatorio;
import auxiliar.Valido;
import code.ServicioTipos;
import code.Scoring;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSourcesValidos {
	
	private static final int nValores = 100; // N�mero de valores que se pasan en los vectores
	

//ARGPERSONA: Argumentos para crear una persona	
public static List<Arguments> argPersonaValidos (){	
	ArrayList<Arguments> argPersona = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que ir�n en el Array
	String argNIF = "";
	String argNombre = "";
	int argTeléfono = 0;	
  String argEMail = "";
  
//Bucle: genera nValores valores de prueba aleatorios
  for (int i = 0; i < nValores; i++) {
    argNIF = Valido.getNIFValido(); 					// NIF V�lido
    argNombre = Valido.getNombreValido(); 		// Nombre v�lido 
  	argTeléfono = Valido.getTeléfonoValido(); // Descripci�n v�lido
    argEMail = Valido.getEMailValido();				// eMail v�lido
    argPersona.add(Arguments.of(argNIF,argNombre,argTeléfono,argEMail));} //A�ade los argumentos al Array

  return argPersona;}

public static List<Arguments> argClienteValidos (){	
// Soluci�n semi-funcional: iteraci�n por los argumentos de persona
	
	List<Arguments> argPersona = argPersonaValidos(); // reuso de persona
	List<Arguments> argCliente = new ArrayList<Arguments>(); // resultado
	List<Object> argItemNew; // desempaquetador
	
	for (Arguments arg : argPersona) { // itera por el stream de Arguments.
		argItemNew = new ArrayList<>(Arrays.asList(arg.get())); // Saca el elemento de la ristra, lo convierte en lista, y sobre ella crea una nueva
		argItemNew.add(0,Aleatorio.getInt(1,100)); // A�ade el n�mero aleatorio al principio de la lista
		argCliente.add(Arguments.of(argItemNew.toArray()));}
	
	return argCliente;}	

//ARGCOLABORADOR: Argumentos para craar un colaborador	
public static List<Arguments> argColaboradorValidos (){

	List<Arguments> argPersona = argPersonaValidos(); // reuso de persona
	List<Arguments> argColaborador = new ArrayList<Arguments>(); // resultado
	List<Object> argItemNew; // desempaquetador
	
	for (Arguments arg : argPersona) { // itera por el stream de Arguments.
		argItemNew = new ArrayList<>(Arrays.asList(arg.get())); // Saca el elemento de la ristra, lo convierte en lista, y sobre ella crea una nueva
		argItemNew.add(0,Aleatorio.getInt(1,100)); // A�ade el n�mero aleatorio al principio de la lista
		argItemNew.add(1,ServicioTipos.getRandomTipoServicio()); // Tipo de Servicio
		argItemNew.add(2,Scoring.getRandomTipoScoring()); // Scoring
		argItemNew.add(3,Aleatorio.getDouble(0.0,100.0,1)); // Tarifa
		argItemNew.add(4,Aleatorio.getBoolean()); // Disponibilidad
		argColaborador.add(Arguments.of(argItemNew.toArray()));} // Lo vuelve a empaquetar
	
	return argColaborador;}

//ARGFACTURA: Argumentos para crear una factura	
	public static List<Arguments> argFacturaValidos (){	
		List<Arguments> argumentosLista = new ArrayList<Arguments>(); // Valores devueltos
		
//Argumentos que ir�n en el Array   
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
     argId = Aleatorio.getInt(1,100);				// Id v�lido														
     argFecha = Valido.getFechaValida(); 		// Fecha V�lida
     argCIFEmisor = Valido.getNIFValido(); 	// NIF V�lido
     argCIFReceptor = Valido.getNIFValido();// NIF V�lido
     argDescripcion = Aleatorio.getString(10); 			// String de 10 carácteres
     argBase = Aleatorio.getDouble(1.0, 1000.0, 1);	// base entre 0 y 1000
     argIvaTipo = Aleatorio.getDouble(0.0,1.0, 1);	// iva entre 0 y 1
     argRetencionTipo = Aleatorio.getDouble(0.0, 1.0, 1);	// retencion entre 0 y 1
       
     argumentosLista.add(Arguments.of(argId,argFecha,argCIFEmisor,argCIFReceptor,argDescripcion,argBase,argIvaTipo,argRetencionTipo));} // A�ade los argumentos al Array
 
   return argumentosLista;}
	
//ARGSERVICIO: Argumentos para crear un servicio  
	public static List<Arguments> argServicioValidos (){
			ArrayList<Arguments> argumentosLista = new ArrayList<Arguments>();  // Lista de argumentos devueltos
			
	// Argumentos que ir�n en el Array   
	    int argId = 0;
			String argFecha = "";
			String argDescripcion = "";
	    double argHoras = 0.0;
	         
	// Bucle: genera nValores valores de prueba válidos
	    for (int i = 0; i < nValores; i++) {
	      argId = Aleatorio.getInt(1, 100); // id entre 1 y 100
	      argFecha = Valido.getFechaValida(); // fecha v�lida
	    	argDescripcion = Aleatorio.getString(10); 	// String de 10
	      argHoras = Aleatorio.getDouble(0.0, 100.0, 1); // Tarifa entre -100 y 100 a 2 decimales
	      
	      argumentosLista.add(Arguments.of(argId, argFecha,argDescripcion,argHoras));} 	// A�ade los argumentos al Array
	  
	    return argumentosLista;  
	  }

}