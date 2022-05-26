package receta;

import java.util.ArrayList;

public abstract class Receta {
	
	protected ArrayList<Cantidad> cantidades = new ArrayList<Cantidad>();
	
	public ArrayList<Cantidad> getCantidades(){
		return cantidades;
	}
}
