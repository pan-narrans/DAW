package code;

import auxiliar.Clase;
import auxiliar.Valido;

public class Persona {
	
// ATRIBUTOS
	String NIF = "";
	String nombre = "";
	int teléfono = 0;
	String eMail = "";

// CONSTRUCTOR
	public Persona () {}
	
	public Persona(String NIF, String nombre, int teléfono, String eMail) throws IllegalArgumentException {
		this.setNIF(NIF);
		this.setNombre(nombre);
		this.setTeléfono(teléfono);
		this.setEMail(eMail);}

// GETTERS
	public String getNIF() 		{return this.NIF;}
	public String getNombre() {return this.nombre;}
	public int getTeléfono() 	{return this.teléfono;}
	public String getEMail() 	{return this.eMail;}

// SETTERS
// Validar lanza algunas excepciones, como cadenas vacias o nulas, pero hay que lanzar otras por valores incorrectos

/*	
	public void setNIF(String NIF) throws IllegalArgumentException {
		try {
			if (!Valido.validarNIF(NIF)) throw new IllegalArgumentException("Exception: NIF incorrecto"); 
			this.NIF = NIF;}
		catch (IllegalArgumentException e) {throw e;}}
*/
	
	public void setNIF(String NIF) throws IllegalArgumentException {
		if (!Valido.validarNIF(NIF)) throw new IllegalArgumentException("Exception: NIF incorrecto"); 
		this.NIF = NIF;}
	
	public void setNombre(String nombre) throws IllegalArgumentException {
		if (!Valido.validarNombre(nombre))  throw new IllegalArgumentException("Exception: Nombre incorrecto");
		this.nombre = nombre;}
	
	public void setTeléfono(int teléfono) throws IllegalArgumentException {
		if (!Valido.validarTeléfono(teléfono)) throw new IllegalArgumentException("Exception: Teléfono incorrecto"); 
		this.teléfono = teléfono;}
	
	public void setEMail(String eMail) throws IllegalArgumentException {
		if (!Valido.validarEMail(eMail))   throw new IllegalArgumentException("Exception: eMail incorrecto"); 
		this.eMail = eMail;}

// TOSTRING
	@Override
	public String toString() {return Clase.imprimeClase(this);}

// EQUAL
	@Override
	public boolean equals(Object copia) {return Clase.comparaObjetos(this, copia);}


// MAIN
/*
	public static void main(String[] args) {

		Persona personaVacia = new Persona();
		
		try {personaVacia.setNIF("");}
		catch (Exception e) {System.out.println(e);}

		try {
			Persona persona = new Persona("12755355S", "calamardo cangreburguer", 666666666, "calamardo@gmail.com");
			System.out.println(persona);}
		catch (Exception e) {System.out.println(e);}
	}
*/
}
	