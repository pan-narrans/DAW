package cartucho;

public abstract class Cartucho {

  String codigo;
  double nivel;

  public Cartucho(String codigo, double nivel) {
    this.codigo = codigo;
    this.nivel  = nivel;
  }

  // devuelve el código del cartucho (se utilizarán los códigos que aparecen en
  // cartucho/CodigosCartucho.java
  public CodigosCartucho getCodigo() {
    return CodigosCartucho.valueOf(codigo);
  }

  // devuelve el nivel actual del cartucho
  public double getNivel() {
    return nivel;
  }

  // antes de dispensar la cantidad indicada se deberán hacer las siguientes
  // comprobaciones
  // si el nivel es 0, se lanzará una nueva excepción de tipo Vacío
  // si nivel disponible no es suficiente para cumplir con el nivel solicitado se
  // lanzará una nueva excepción de tipo CantidadInsuficiente
  // en caso de superar las restricciones anteriores se procederá a actualizar el
  // nivel del contador
  // nivel = nivel - cantidad
  // una vez actualizado el nivel se comprobará que no se ha llegado a 0, en tal
  // caso se
  // lanzará una excepción de tipo Vació
  // Cada vez que lances una excepción deberás de indicar el código del cartucho
  // por ejemplo:
  // CantidadInsuficiente(código)

  public void dispensa(double cantidad) throws Vacio, CantidadInsuficiente {
    if (nivel == 0)
      throw new Vacio(codigo.toString());

    if (nivel < cantidad)
      throw new CantidadInsuficiente(codigo.toString());
  
    nivel = nivel - cantidad;

    if (nivel == 0)
      throw new Vacio(codigo.toString());
  }

  // es necesario que disponga del siguiente toString
  public String toString() {
    return "Cartucho [código=" + codigo + ", nivel=" + nivel + "]";
  }

}
