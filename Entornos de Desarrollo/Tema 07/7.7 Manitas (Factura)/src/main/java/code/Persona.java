package code;

import auxiliar.Clase;
import auxiliar.Valido;

public class Persona {
	
// ATRIBUTOS
	String NIF = "";
	String nombre = "";
	int telefono = 0;
	String eMail = "";

// CONSTRUCTOR
	public Persona () {}
	
	public Persona(String NIF, String nombre, int telefono, String eMail) throws IllegalArgumentException {
		this.setNIF(NIF);
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setEMail(eMail);}

// GETTERS
	public String getNIF() 		{return this.NIF;}
	public String getNombre() {return this.nombre;}
	public int getTelefono() 	{return this.telefono;}
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
	
	public void setTelefono(int telefono) throws IllegalArgumentException {
		if (!Valido.validarTelefono(telefono)) throw new IllegalArgumentException("Exception: Telefono incorrecto"); 
		this.telefono = telefono;}
	
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
	