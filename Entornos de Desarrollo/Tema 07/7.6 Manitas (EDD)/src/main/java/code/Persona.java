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
	
	public Persona(String NIF, String nombre, int telefono, String eMail) {
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

	public void setNIF(String NIF) throws IllegalArgumentException {
		try {
			if (!Valido.validarNIF(NIF)) throw new IllegalArgumentException("Exception: NIF incorrecto"); 
			this.NIF = NIF;}
		catch (IllegalArgumentException e) {}}
	
	public void setNombre(String nombre) throws IllegalArgumentException {
		try {
			if (!Valido.validarNombre(nombre))  throw new IllegalArgumentException("Exception: Nombre incorrecto");
			this.nombre = nombre;}
		catch (IllegalArgumentException e) {}}
	
	public void setTelefono(int telefono) throws IllegalArgumentException {
		try {
			if (!Valido.validarTelefono(telefono)) throw new IllegalArgumentException("Exception: Telefono incorrecto"); 
			this.telefono = telefono;}
		catch (IllegalArgumentException e) {}}
	
	public void setEMail(String eMail) throws IllegalArgumentException {
		try {
		if (!Valido.validarEMail(eMail))   throw new IllegalArgumentException("Exception: eMail incorrecto"); 
		this.eMail = eMail;}
	catch (IllegalArgumentException e) {}}

// TOSTRING
	@Override
	public String toString() {return Clase.imprimeClase(this);}

// EQUAL
	@Override
	public boolean equals(Object copia) {return Clase.comparaObjetos(this, copia);}


// MAIN
/*
	public static void main(String[] args) {
		Persona persona = new Persona("06023717V", "Calamardo Cangreburguer", 666666666, "calamardo@gmail.com");
		System.out.println(persona);
	}
*/	
}
	