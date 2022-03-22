package code;

public interface Cliente {

//GETTERS	
	public int getId();

	public String getNombre();
	public String getNIF();
	public int getTelefono();
	public String getEMail();
	
//SETTERS
	public void setId(int id);

	public void setNombre(String nombre);
	public void setNIF(String NIF);
	public void setTelefono(int telefono);
	public void setEMail(String eMail);
	
}
