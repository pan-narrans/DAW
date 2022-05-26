package receta;

import cartucho.CodigosCartucho;

public class TortillaFrancesa extends Receta{
	public TortillaFrancesa(){
		cantidades.add(new Cantidad(CodigosCartucho.HUEVO.toString(),2.0));
		cantidades.add(new Cantidad(CodigosCartucho.CHORIZO.toString(),100.0));
		cantidades.add(new Cantidad(CodigosCartucho.ACEITE.toString(),100.0));
	}
}
