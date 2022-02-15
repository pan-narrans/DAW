package ej_ricardo_empleados;

public class Mantenimiento extends Empleado {

  public Mantenimiento(String name, String birthDate, String post, float baseSalary) {
    super(name, birthDate, post, 4, baseSalary);
  }

  public void limpiarCristales() {
    System.out.println("Estoy limpiando un cristal.");
  }

  public void limpiarMesas() {
    System.out.println("Estoy limpiando una mesa.");
  }

  public void limpiarSuelos() {
    System.out.println("Estoy limpiando el suelo.");
  }

}
