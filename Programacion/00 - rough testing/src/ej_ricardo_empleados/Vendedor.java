package ej_ricardo_empleados;

public class Vendedor extends Empleado {
  static int id_ref = 0;
  int id;
  int sales;
  JefeTienda jefe;

  public Vendedor(String name, String birthDate, String post, double baseSalary) {
    super(name, birthDate, post, 2, baseSalary);
    id = id_ref++;
    sales = 0;
  }

  public Vendedor(String name, String birthDate, String post, double baseSalary, JefeTienda jefe) {
    this(name, birthDate, post, baseSalary);
    this.jefe = jefe;
  }

  public boolean checkBonus() {
    return (sales > 50) ? true : false;
  }

  public void asignarJefe(JefeTienda jefe) {
    // Quitarnos del antiguo jefe
    this.jefe.removeSalesman(this.name);

    // Nuevo jefe
    this.jefe = jefe;
    this.jefe.addSalesman(this.name);
  }

  public void destroy() {
    this.jefe.removeSalesman(this.name);
  }

}
