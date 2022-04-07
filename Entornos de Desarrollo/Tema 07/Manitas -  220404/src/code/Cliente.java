package code;

public interface Cliente {

//GETTERS	
	public int getId();

	public String getNombre();
	public String getNIF();
	public int getTeléfono();
	public String getEMail();
	
//SETTERS
	public void setId(int id);

	public void setNombre(String nombre);
	public void setNIF(String NIF);
	public void setTeléfono(int teléfono);
	public void setEMail(String eMail);
	
}
