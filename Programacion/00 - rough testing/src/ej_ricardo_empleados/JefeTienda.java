package ej_ricardo_empleados;

import java.util.ArrayList;

public class JefeTienda extends Empleado {
  int shop_id;
  ArrayList<String> salesmen = new ArrayList<String>();

  public JefeTienda(String name, String birthDate, String post, float baseSalary) {
    super(name, birthDate, post, 1, baseSalary);
  }

  public void addSalesman(String name) {
    salesmen.add(name);
  }

  public void removeSalesman(String name) {
    salesmen.remove(name);
  }
}
