package main.java.code;

import main.java.auxiliar.Clase;

public class ClienteReal extends Persona implements Cliente {

// ATRIBUTOS
	private int id = 0;

// CONSTRUCTOR
	public ClienteReal () {}
	
	public ClienteReal(int id, String NIF, String nombre, int telefono, String eMail) {
		super(NIF,nombre,telefono,eMail);
		this.setId(id);}

// GETTERS	
	public int getId() {return this.id;}

// SETTERS		
	public void setId(int id) throws IllegalArgumentException {
			if (id <=0) throw new IllegalArgumentException("Exception: Id <= 0"); 
			this.id = id;}

// TOSTRING	
	@Override
	public String toString() {return Clase.imprimeClase(this);}
	
// EQUAL
	@Override
	public boolean equals(Object copia) {return Clase.comparaObjetos(this, copia);}	
	
// MAIN
/*	
	public static void main(String[] args) {
		ClienteReal cliente = new ClienteReal (1,"12755355S", "Bob Esponja", 777777777, "bobesponja@gmail.com");
		System.out.println(cliente);
	}
*/	
}