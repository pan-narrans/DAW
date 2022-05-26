package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import divisas.DatosConversion;
import divisas.Divisa;
import divisas.DivisaCambio;

public class Main {

	public static void main(String[] args) {

		String nombreDelFicheroTexto   = "divisas.txt";
		String nombreFicheroBinario    = "divisas.dat";
		String nombreFicheroSalidaTxt  = "divisasToString.txt";
				
		DatosConversion conversor      = cargarDatosConversorFicheroTxt(nombreDelFicheroTexto);

    muestraDatosConversor(conversor);
    
		try {
      generarFicheroBinario(nombreFicheroBinario, conversor);
    } catch (IOException e) {
      e.printStackTrace();
    }

   conversor = null;

    try {
      conversor = leerFicheroBinario(nombreFicheroBinario);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
		
		muestraDatosConversor(conversor);
		
		try {
      escribirEnFicheroTxt(nombreFicheroSalidaTxt, conversor);
    } catch (IOException e) {
      e.printStackTrace();
    }
			
	}

  // 
	// lee de un fichero de texto los datos almacenados según el siguiente formato:
	// primera linea:
	//   nombre de la moneda;valor del cambio respecto al Dólar americano
	// resto de lineas:
	//   Nombre del país;Nombre de la moneda;Valor en dólares (en formato decimal con coma)
	//
	private static DatosConversion cargarDatosConversorFicheroTxt(String nombreFichero) {
    BufferedReader reader  = null;
    DatosConversion result = null;
    try {
      reader = new BufferedReader(new FileReader(nombreFichero));

      String linea              = reader.readLine();
      String[] datos            = linea.split(";");
      DivisaCambio divisaCambio = new DivisaCambio(
        datos[0], 
        Double.parseDouble(datos[1].replace(',', '.')));

      result = new DatosConversion(divisaCambio);
      
      while(reader.ready()){
        linea = reader.readLine();
        datos = linea.split(";");
        result.add(new Divisa(
          datos[0], 
          datos[1], 
          Double.parseDouble(datos[2].replace(',', '.'))));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
	}
	
	private static void muestraDatosConversor(DatosConversion conversor) {
    System.out.println("\n===============");
		System.out.println(conversor);
    
    // Alex: check que las divisas se hayan guardado bien
    // conversor.getAllDivisas().forEach(System.out::println);
    // System.out.println("\n");

    // Alex: check que la conversión se haya realizado correctamente
    // conversor.realizaConversion().forEach(System.out::println);
	}

	//guarda  en un fichero binario de nombre: nombreFichero binario los datos de conversión DatosConversion
	//
	private static void generarFicheroBinario(String nombreFichero, DatosConversion conversor)
			throws IOException {
    ObjectOutputStream writer = null;

    writer = new ObjectOutputStream(new FileOutputStream(nombreFichero));
    writer.writeObject(conversor);
    writer.close();
	}

	//leer  de un fichero binario de nombre: nombreFichero y devuelve el dato almacenado
	//
	private static DatosConversion leerFicheroBinario(String nombreFichero) throws ClassNotFoundException, IOException {
		DatosConversion result   = null;
    ObjectInputStream reader = null;

    reader = new ObjectInputStream(new FileInputStream(nombreFichero));
    result = (DatosConversion) reader.readObject();
    reader.close();

    return result;
	}

	//escribe en un fichero de texto en nueva linea el resultado de realizar el toString a la conversión a las divisas 
	//observación: DatosConversion.realizaConversion()
	private static void escribirEnFicheroTxt(String nombreFichero, DatosConversion conversor) throws IOException {
    BufferedWriter writer = null;

    writer = new BufferedWriter(new FileWriter(nombreFichero));
    writer.write(conversor.realizaConversion().toString());
    writer.close();
	}


}
