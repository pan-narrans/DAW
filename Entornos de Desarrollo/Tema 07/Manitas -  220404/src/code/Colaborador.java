package code;

public interface Colaborador{

// GETTERS
	
	public int getId();
	public ServicioTipos getServicio();
	public Scoring getScoring();
	public double getTarifa();
	public boolean getDisponible();
	
	public String getNombre();
	public String getNIF();
	public int getTeléfono();
	public String getEMail();
	
// SETTERS

	public void setId(int id);
	public void setServicio(ServicioTipos servicio);
	public void setScoring(Scoring scoring);
	public void setTarifa(double tarifa);
	public void setDisponible(boolean disponible);

	public void setNombre(String nombre);
	public void setNIF(String NIF);
	public void setTeléfono(int teléfono);
	public void setEMail(String eMail);
	
	
// MÉTODOS	
	public boolean esActivo();
}