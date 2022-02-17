package ej_ricardo_empleados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ej_ricardo_empleados.Empleado.Type;

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
      System.out.println("  5) Listado de empleados:");
      System.out.println("  6) Salir");

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
          calcularSueldos();
          break;
        case 5:
          listarEmpleados();
          break;
        case 6:
          seguir = false;
          break;
        default:
          System.out.println("Valor no contemplado.");
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
    double baseSalary;

    System.out.println("Introduce el nombre del empleado:");
    name = sc.next();

    System.out.println("Introduce la fecha de nacimiento del empleado (dd/mm/yyyy):");
    birthDate = sc.next();

    System.out.println("Introduce el puesto del empleado:");
    post = sc.next();

    category = validateCategory();

    System.out.println("Introduce el salario base del empleado:");
    baseSalary = sc.nextDouble();

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
        break;
      default:
        empleado = new Empleado();
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
      System.out.println("  1) Jeje de Tienda");
      System.out.println("  2) Vendedor");
      System.out.println("  3) Jeje de Almacén");
      System.out.println("  4) Mantenimiento");
      category = sc.nextInt();
      valid = (category < 5 && category > 0) ? true : false;
      if (!valid)
        System.out.println("Valor no válido.");

    } while (!valid);

    return category;
  }

  private void calcularSueldos() {
    System.out.println("\n\n--- LISTADO DE SUELDOS ---\n");
    Iterator<Empleado> it = empleados.iterator();
    while (it.hasNext()) {
      Empleado temp = it.next();
      System.out.println(temp);
      System.out.println("Su sueldo es: " + temp.calcularSueldo() + "\n");
    }
  }

  private void listarEmpleados() {
    Iterator<Empleado> it = empleados.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  private void elminiarEmpleado() {
    boolean elementoNoEncontrado = true;

    Iterator<Empleado> it = empleados.iterator();
    while (it.hasNext() && elementoNoEncontrado) {
      Empleado temp = it.next();
      if (temp.getName() == "alex") {
        it.remove();
        elementoNoEncontrado = false;
      }
    }

  }

}
