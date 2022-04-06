package test;

import auxiliar.Aleatorio;
import code.ServicioTipos;
import code.Scoring;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSourcesAleatorios {
	
	private static int nValores = 100; // Número de valores que se pasan en los vectores
	
//ARGPERSONA: Argumentos para crear una persona	
	public static List<Arguments> argPersonaAleatorios (){	
		ArrayList<Arguments> argPersona = new ArrayList<Arguments>(); // Valores devueltos
	
//Argumentos que irán en el Array
	String argNIF = "";
	String argNombre = "";
	int argTelefono = 0;	
  String argEMail = "";
  
//Bucle: genera nValores valores de prueba aleatorios
  for (int i = 0; i < nValores; i++) {
  	argNIF = Aleatorio.getString(Aleatorio.getInt(0, 10));  	// String aleatorio de 0 a 10 caracteres
    argNombre = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
  	argTelefono = Aleatorio.getInt(500000000,1100000000); 		// Teléfono entre 500 000 000 y 1 100 000 000
    argEMail = Aleatorio.getString(Aleatorio.getInt(0, 10));	// String aleatorio de 0 a 10 caracteres
    argPersona.add(Arguments.of(argNIF,argNombre,argTelefono,argEMail));} //Añade los argumentos al Array

  return argPersona;}

//ARGCLIENTE: Argumentos para crear un cliente
// Reutiliza el código de ArgPersona que devuelve un Stream de Arguments
// Arguments = Object [] -> Lo que devuelve argPersona es una cadena de paquetes de valores (Stream<Object[]>)
// Hay que sacar los argumentos del paquete (Arguments), añadir uno nuevo ( y volvera empaquetar	
	
	public static List<Arguments> argClienteAleatorios (){	
	// Solución semi-funcional: iteración por los argumentos de persona
		
		List<Arguments> argPersona = argPersonaAleatorios(); // reuso de persona
		List<Arguments> argCliente = new ArrayList<Arguments>(); // resultado
		List<Object> argItemNew; // desempaquetador
		
		for (Arguments arg : argPersona) { // itera por el stream de Arguments.
			argItemNew = new ArrayList<>(Arrays.asList(arg.get())); // Saca el elemento de la ristra, lo convierte en lista, y sobre ella crea una nueva
			argItemNew.add(0,Aleatorio.getInt(-100,100)); // Añade el número aleatorio al principio de la lista
			argCliente.add(Arguments.of(argItemNew.toArray()));}
		
		return argCliente;}	
	
/*  
// En java la solución funcional es compleja por dos motivos

		return argPersona
		.map(Arguments::get) // Saco los argumentos. Cada elemento del stream es un array de objetos (4 en este caso: NIF, nombre, teléfono, eMail)
		.map(argumentos -> Arrays.asList(argumentos)) // Lo convierto a lista para poder añadirle un nuevo argumento: el id aleatorio
		.map(lista -> new ArrayList<>(lista)) // Ñapa de java: tengo que crear una nueva lista porque la anterior no es ampliable
		.map(listaNueva -> Stream.concat(Aleatorio.getIntList(-100, 100, 1).stream(),listaNueva.stream()).collect(Collectors.toList())) // Otra ñapa: este es el equivalente a lista1 + lista2
		.map(listaAmpliada -> Arguments.of(listaAmpliada.toArray()));}
*/		
			
//ARGCOLABORADOR: Argumentos para craar un colaborador	
	public static List<Arguments> argColaboradorAleatorios (){

		List<Arguments> argPersona = argPersonaAleatorios(); // reuso de persona
		List<Arguments> argColaborador = new ArrayList<Arguments>(); // resultado
		List<Object> argItemNew; // desempaquetador
		
		for (Arguments arg : argPersona) { // itera por el stream de Arguments.
			argItemNew = new ArrayList<>(Arrays.asList(arg.get())); // Saca el elemento de la ristra, lo convierte en lista, y sobre ella crea una nueva
			argItemNew.add(0,Aleatorio.getInt(-100,100)); // Añade el número aleatorio al principio de la lista
			argItemNew.add(1,ServicioTipos.getRandomTipoServicio()); // Tipo de Servicio
			argItemNew.add(2,Scoring.getRandomTipoScoring()); // Scoring
			argItemNew.add(3,Aleatorio.getDouble(-100.0,100.0,1)); // Tarifa
			argItemNew.add(4,Aleatorio.getBoolean()); // Disponibilidad
			argColaborador.add(Arguments.of(argItemNew.toArray()));} // Lo vuelve a empaquetar
		
		return argColaborador;}	
	
//ARGFACTURA: Argumentos para crear una factura	
	public static List<Arguments> argFacturaAleatorios () {	
		List<Arguments> argFactura = new ArrayList<Arguments>(); // Valores devueltos
		
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
       
     argFactura.add(Arguments.of(argId,argFecha,argCIFEmisor,argCIFReceptor,argDescripcion,argBase,argIvaTipo,argRetencionTipo));} // Añade los argumentos al Array
 
   return argFactura;}
	
//ARGSERVICIO: Argumentos para crear un servicio  
	public static List<Arguments> argServicioAleatorios (){
			List<Arguments> argServicio = new ArrayList<Arguments>();  // Lista de argumentos devueltos
			
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
	      argServicio.add(Arguments.of(argId, argFecha,argNombre,argHoras));} 	// Añade los argumentos al Array
	  
	    return argServicio;}
	
//MAIN
	public static void main(String[] args) {}
		
}