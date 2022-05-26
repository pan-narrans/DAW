package divisas;

import java.io.Serializable;

public class DivisaCambio implements Serializable{

	private static final long serialVersionUID = 3931621443596799447L;
	
	private String nombreMoneda;
	private double valorConversion;

	public DivisaCambio(String nombreMoneda, double valorConversion) {
		this.nombreMoneda    = nombreMoneda;
		this.valorConversion = valorConversion;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public double getValorConversion() {
		return valorConversion;
	}

	public void setValorConversion(double valorConversion) {
		this.valorConversion = valorConversion;
	}

	@Override
	public String toString() {
		return "DivisaCambio [nombreMoneda=" + nombreMoneda + ", valorConversion=" + valorConversion + "]";
	}
}
