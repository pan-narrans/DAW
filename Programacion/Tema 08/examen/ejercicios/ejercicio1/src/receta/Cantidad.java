package receta;

public class Cantidad {
	
	private String codigoIngrediente;
	private double cantidad;
	
	public Cantidad(String codigoIngrediente, double cantidad) {
		this.codigoIngrediente = codigoIngrediente;
		this.cantidad          = cantidad;
	}

	public String getCodigoIngrediente() {
		return codigoIngrediente;
	}

	public double getCantidadNecesaria() {
		return cantidad;
	}

	public String toString() {
		return "Cantidad [codigoIngrediente=" + codigoIngrediente + ", cantidad=" + cantidad + "]";
	}	
}
