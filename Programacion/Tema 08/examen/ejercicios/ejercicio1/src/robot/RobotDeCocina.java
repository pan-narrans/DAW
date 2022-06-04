package robot;

import java.util.ArrayList;
import java.util.Collection;

import cartucho.CantidadInsuficiente;
import cartucho.Cartucho;
import cartucho.CodigoNoExiste;
import cartucho.DispensadorCartuchos;
import cartucho.Vacio;
import receta.Cantidad;
import receta.Receta;

public class RobotDeCocina {

  private DispensadorCartuchos cartuchos = new DispensadorCartuchos();

  // no admite parámetros
  public RobotDeCocina() {

  }

  // antes de elaborar la receta se ha de comprobar que existen los ingredientes y
  // cantidades necesarias se propagará las excepciones que se produzcan durante
  // la comprobación y en caso de que la cantidad necesaria no sea la suficiente
  // se lanzará una nueva excepción CantidadInsuficiente indicando en ella el
  // código del ingrediente CantidadInsuficiente(codigoIngrediente)
  //
  // si se cumple lo anterior entonces se solicitará al cartucho que dispense la
  // cantidad requerida En caso de producirse una excepción de tipo Vacío cuando
  // se solicite al cartucho dispensar el ingrediente no se realizará acción
  // alguna.
  //

  public void elabora(Receta receta) throws CantidadInsuficiente, CodigoNoExiste {
    ArrayList<Cantidad> cantidades = receta.getCantidades();

    for (Cantidad cantidad : cantidades) {
      try {
        String codigoIngrediente = cantidad.getCodigoIngrediente();
        double cantidadNecesaria = cantidad.getCantidadNecesaria();
        double nivelCartucho     = cartuchos.get(codigoIngrediente).getNivel();

        // Comprobar cantidad
        if (cantidadNecesaria > nivelCartucho)
          throw new CantidadInsuficiente(codigoIngrediente);

        // Dispensar
        cartuchos.get(codigoIngrediente).dispensa(cantidadNecesaria);

      } catch (Vacio e) {
        System.out.println("¡CUIDADO! Cartucho vacío: " + e.getMessage());
      }
    }

  }

  // añade un nuevo cartucho a la colección no se permiten duplicados y si
  // anteriormente existía un cartucho con el mismo código se reemplazará
  //
  public void carga(Cartucho cartucho) {
    cartuchos.add(cartucho);
  }

  // devuelve los cartuchos de los que dispone la máquina sin importar
  // el nivelCartucho del que dispongan no se ha de generar una copia
  public Collection<Cartucho> getInventario() {
    return cartuchos.getAll();
  }
}
