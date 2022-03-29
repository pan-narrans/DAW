package code;


public class ColaboradorStub implements Colaborador {
// Colaborador hardcodeado para hacer pruebas
	
	public int getId () {return 1;}
	public ServicioTipos getServicio() {return ServicioTipos.ALBAÑIL;}
	public Scoring getScoring() {return Scoring.ALTO;}
	public double getTarifa() {return 10.0;}
	public boolean getDisponible() {return true;}

	public String getNombre() {return "Stub";}
	public String getNIF() {return "CIFStub";}
	public int getTelefono() {return 666666666;}
	public String getEMail() {return "colaboradorstub@gmail.com";}
	
// SETTERS
	public void setId(int id) {};	
	public void setServicio(ServicioTipos servicio) {};
	public void setScoring(Scoring scoring) {};
	public void setTarifa(double tarifa) {};
	public void setDisponible(boolean disponible) {};
		
	public void setNombre(String nombre) {};
	public void setNIF(String CIF) {};
	public void setTelefono(int telefono) {}
	public void setEMail(String eMail) {}
	
// MÉTODOS	
	public boolean esActivo() {return true;}
}
