package ej_ricardo_empleados;

public class Empleado {
  String name;
  String birthDate;
  String post;
  int category;
  double baseSalary;

  enum Type {
    Vendedor,
    Jefe_Tienda,
    Personal_Almacén,
    Personal_Mantenimiento
  };

  /**
   * @param birthDate : dd/mm/yyyy
   * @param category  : int between 1 and 4 (both included)
   */
  public Empleado() {
    this.name = "name";
    this.birthDate = "dd/mm/yyyy";
    this.post = "post";
    this.category = 0;
    this.baseSalary = 0;
  }

  /**
   * @param birthDate : dd/mm/yyyy
   * @param category  : int between 1 and 4 (both included)
   */
  public Empleado(String name, String birthDate, String post, int category, double baseSalary) {
    this.name = name;
    this.birthDate = birthDate;
    this.post = post;
    this.category = category;
    this.baseSalary = baseSalary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double calcularSueldo() {
    double sueldo = this.baseSalary, incremento, impuestos;
    switch (category) {
      case 1:
        incremento = 0.20f;
        impuestos = 0.05f;
        break;
      case 2:
        incremento = 0.15f;
        impuestos = 0.03f;
        break;
      case 3:
        incremento = 0.10f;
        impuestos = 0.02f;
        break;
      case 4:
        incremento = 0.5f;
        impuestos = 0.01f;
        break;
      default:
        incremento = 0.0f;
        impuestos = 0.00f;
        break;
    }

    sueldo += (sueldo * incremento);
    sueldo -= (sueldo * impuestos);

    return sueldo;
  }

  @Override
  public String toString() {
    return "Empleado [name=" + name + ", birthDate=" + birthDate + ", category=" + category + ", baseSalary="
        + baseSalary + ", post=" + post + "]";
  }

}
