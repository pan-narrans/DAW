package ej_ricardo_empleados;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {
  ArrayList<Empleado> empleados = new ArrayList<>();
  Scanner sc = new Scanner(System.in);

  public void menu() {
    boolean seguir = true;
    int eleccion;

    do {
      System.out.println("---- MENU DE APLICACIÓN ----");
      System.out.println("  1) Alta de empleado:");
      System.out.println("  2) Baja de empleado:");
      System.out.println("  3) Modificación de empleado:");
      System.out.println("  4) Calcular sueldos:");
      System.out.println("  5) Salir");

      eleccion = sc.nextInt();

      switch (eleccion) {
        case 1:
          altaEmpleado();
          break;
        case 2:
          bajaEmpleado();
          break;
        case 3:

          break;
        case 4:

          break;
        case 5:
        default:
          seguir = false;
          break;
      }

    } while (seguir);
  }

  public void altaEmpleado() {
    Empleado empleado;

    String name;
    String birthDate;
    String post;
    int category;
    float baseSalary;

    System.out.println("Introduce el nombre del empleado:");
    name = sc.nextLine();

    System.out.println("Introduce la fecha de nacimiento del empleado:");
    birthDate = sc.nextLine();

    System.out.println("Introduce el puesto del empleado:");
    post = sc.nextLine();

    System.out.println("Introduce la categoría del empleado (1-4):");
    category = validateCategory();

    System.out.println("Introduce el salario base del empleado:");
    baseSalary = sc.nextFloat();

    switch (category) {
      case 1:
        empleado = new JefeTienda(name, birthDate, post, baseSalary);
        break;
      case 2:
        empleado = new Vendedor(name, birthDate, post, baseSalary);
        break;
      case 3:
        empleado = new JefeAlmacen(name, birthDate, post, baseSalary);
        break;
      case 4:
        empleado = new Mantenimiento(name, birthDate, post, baseSalary);
      default:
        break;
    }

    empleados.add(empleado);
  }

  public void bajaEmpleado() {
  }

  private int validateCategory() {
    int category;
    boolean valid;

    do {
      System.out.println("Introduce la categoría del empleado (1-4):");
      category = sc.nextInt();
      valid = (category < 5 && category > 0) ? true : false;
    } while (!valid);
    return 0;
  }

}
