package divisas;

import java.io.Serializable;

public class Divisa implements Serializable{
	
	private static final long serialVersionUID = 7523130876741782812L;
	
	private String pais;
	private String nombreMoneda;
	private double cambio;

	public Divisa(String pais, String nombreMoneda, double cambio) {
		this.pais         = pais;
		this.nombreMoneda = nombreMoneda;
		this.cambio       = cambio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public double getCambio() {
		return cambio;
	}

	public void setCambio(double cambio) {
		this.cambio = cambio;
	}

	@Override
	public String toString() {
		return "\nDivisa [pais=" + pais + ", nombreMoneda=" + nombreMoneda + ", cambio=" + cambio + "]";
	}

}
