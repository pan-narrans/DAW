package receta;

import cartucho.CodigosCartucho;

public class HuevosConChorizo extends Receta{
	public HuevosConChorizo(){
		cantidades.add(new Cantidad(CodigosCartucho.HUEVO.toString(),3.0));
		cantidades.add(new Cantidad(CodigosCartucho.ACEITE.toString(),200.0));
	}
}
