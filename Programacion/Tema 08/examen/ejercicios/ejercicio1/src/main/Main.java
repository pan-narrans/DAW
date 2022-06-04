package main;

import cartucho.Aceite;
import cartucho.Agua;
import cartucho.CantidadInsuficiente;
import cartucho.Chorizo;
import cartucho.CodigoNoExiste;
import cartucho.Huevo;
import cartucho.Sal;
import receta.HuevosConChorizo;
import receta.Popurri;
import receta.TortillaFrancesa;
import receta.Vaciador;
import robot.RobotDeCocina;

public class Main {

  public static void main(String[] args) {

    RobotDeCocina robot = new RobotDeCocina();

    cargaCartuchosIngredientes(robot);
    muestraNivelesCartuchos(robot);

    elaboraRecetaEjemplo1(robot);
    muestraNivelesCartuchos(robot);

    elaboraRecetaEjemplo2(robot);
    muestraNivelesCartuchos(robot);

    elaboraRecetaEjemplo3(robot);
    muestraNivelesCartuchos(robot);

    elaboraRecetaEjemplo4(robot);
    muestraNivelesCartuchos(robot);
  }

  private static void cargaCartuchosIngredientes(RobotDeCocina robot) {
    System.out.println("Cargando cartuchos");

    robot.carga(new Huevo());
    robot.carga(new Aceite());
    robot.carga(new Sal());
    robot.carga(new Agua());
    robot.carga(new Chorizo());
    robot.carga(new Chorizo());
  }

  private static void muestraNivelesCartuchos(RobotDeCocina robot) {
    System.out.println("Niveles de los cartuchos");
    System.out.println(robot.getInventario());
  }

  private static void elaboraRecetaEjemplo1(RobotDeCocina robot) {
    System.out.println("\nElaborando receta 1");

    try {
      robot.elabora(new HuevosConChorizo());
      System.out.println("Receta OK");
    } catch (CantidadInsuficiente | CodigoNoExiste e) {
      e.printStackTrace();
    }
  }

  private static void elaboraRecetaEjemplo2(RobotDeCocina robot) {
    System.out.println("\nElaborando receta 2");

    try {
      for (int i = 1; i < 6; i++) {
        robot.elabora(new TortillaFrancesa());
        System.out.println("RECETA TORTILLA Nº " + i + ": OK");
      }
    } catch (CantidadInsuficiente e) {
      System.out.println("Receta NOK. Se lanza CantidadInsuficiente: " + e.getMessage());

    } catch (CodigoNoExiste e) {
      System.out.println("Receta NOK");
    }
  }

  private static void elaboraRecetaEjemplo3(RobotDeCocina robot) {
    System.out.println("\nElaborando receta 3");
    cargaCartuchosIngredientes(robot);

    try {
      robot.elabora(new Popurri());
      System.out.println("Receta OK");
    } catch (CantidadInsuficiente | CodigoNoExiste e) {
      System.out.println(e);
    }
  }

  private static void elaboraRecetaEjemplo4(RobotDeCocina robot) {
    System.out.println("\nElaborando receta 4");
    cargaCartuchosIngredientes(robot);

    try {
      robot.elabora(new Vaciador());
      System.out.println("Receta OK");
    } catch (CantidadInsuficiente | CodigoNoExiste e) {
      System.out.println(e);
    }
  }

}
