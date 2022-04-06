package code;

import auxiliar.Clase;

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
		if (id <= 0) throw new IllegalArgumentException("Exception: id <= 0");
		this.id = id;}
	
// TO STRING	
	public String toString() {return Clase.imprimeClase(this);}
	
//MAIN
	
	public static void main(String[] args) {
		ClienteReal cliente = new ClienteReal (1,"01234567X", "Bob Esponja", 777777777, "bobesponja@gmail.com");
		System.out.println(cliente);}
}