package receta;

import cartucho.CodigosCartucho;

public class Popurri extends Receta {
  public Popurri() {
    cantidades.add(new Cantidad(CodigosCartucho.HUEVO.toString(), 3.0));
    cantidades.add(new Cantidad(CodigosCartucho.ACEITE.toString(), 200.0));
    //cantidades.add(new Cantidad(CodigosCartucho.AZUCAR.toString(), 400.0));
    cantidades.add(new Cantidad(CodigosCartucho.AGUA.toString(), 200.0));
    cantidades.add(new Cantidad(CodigosCartucho.SAL.toString(), 100.0));
    cantidades.add(new Cantidad("MERMELADA", 200.0));
  }
}
