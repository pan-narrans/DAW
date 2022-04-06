package code;


public class ClienteStub implements Cliente {
//	Cliente hardcoded para hacer pruebas
	
	public int getId () {return 2;}

	public String getNombre() {return "ClienteStub";}
	public String getNIF() {return "NIFStub";}
	public int getTelefono() {return 666666666;}
	public String getEMail() {return "clientestub@gmail.com";}
	
// SETTERS
	public void setId(int id) {};	
	
	public void setNombre(String nombre) {};
	public void setNIF(String CIF) {};
	public void setTelefono(int telefono) {}
	public void setEMail(String eMail) {}	
}
