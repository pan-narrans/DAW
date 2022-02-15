package ej_ricardo_empleados;


public class Empleado {
  String name;
  String birthDate;
  String post;
  int category;
  float baseSalary;

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
  public Empleado(String name, String birthDate, String post, int category, float baseSalary) {
    this.name = name;
    this.birthDate = birthDate;
    this.post = post;
    this.category = category;
    this.baseSalary = baseSalary;
  }

  public float calcularSueldo() {
    float sueldo = this.baseSalary, incremento, impuestos;
    switch (category) {
      case 1:
        incremento = 20;
        impuestos = 5;
        break;
      case 2:
        incremento = 15;
        impuestos = 3;
        break;
      case 3:
        incremento = 10;
        impuestos = 2;
        break;
      case 4:
        incremento = 5;
        impuestos = 1;
        break;
      default:
        incremento = 0;
        impuestos = 0;
        break;
    }

    sueldo = sueldo * incremento;
    sueldo = sueldo - (sueldo * impuestos);

    return sueldo;
  }

}
