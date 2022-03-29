package main.java.code;

public interface Colaborador{

// GETTERS
	
	public int getId();
	public ServicioTipos getServicio();
	public Scoring getScoring();
	public double getTarifa();
	public boolean getDisponible();
	
	public String getNombre();
	public String getNIF();
	public int getTelefono();
	public String getEMail();
	
// SETTERS

	public void setId(int id);
	public void setServicio(ServicioTipos servicio);
	public void setScoring(Scoring scoring);
	public void setTarifa(double tarifa);
	public void setDisponible(boolean disponible);

	public void setNombre(String nombre);
	public void setNIF(String NIF);
	public void setTelefono(int telefono);
	public void setEMail(String eMail);
	
	
// M�TODOS	
	public boolean esActivo();
}