package receta;

import cartucho.CodigosCartucho;

public class Vaciador extends Receta {
  public Vaciador() {
    cantidades.add(new Cantidad(CodigosCartucho.HUEVO.toString(), 12));
  }
}
