package ej_ricardo_empleados;


public class JefeAlmacen extends Empleado {
  int storehouse_id;

  public JefeAlmacen(String name, String birthDate, String post, float baseSalary) {
    super(name, birthDate, post, 3, baseSalary);
  }
}
