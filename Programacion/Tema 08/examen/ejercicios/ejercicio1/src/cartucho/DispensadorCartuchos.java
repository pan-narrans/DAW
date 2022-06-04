package cartucho;

import java.util.Collection;
import java.util.HashMap;

public class DispensadorCartuchos {

  HashMap<String, Cartucho> cartuchos;

  // no admite argumentos
  public DispensadorCartuchos() {
    cartuchos = new HashMap<String, Cartucho>();
  }

  // añade un nuevo cartucho a la colección. No se permite repetir cartuchos
  // si ya existe, directamente se reemplaza por el nuevo. No es necesario
  // comprobar si es !=null
  public void add(Cartucho cartucho) {
    cartuchos.put(cartucho.getCodigo().toString(), cartucho);
  }

  // Realiza una búsqueda en la colección mediante codigoCartucho suministrado y
  // devuelve los datos del cartucho en caso de encontrarlo.
  // en caso de no encontrar el cartucho se devolverá una excepción de tipo
  // CodigoNoExiste(codigoCartucho)
  //
  public Cartucho get(String codigoCartucho) throws CodigoNoExiste {
    Cartucho result = cartuchos.get(codigoCartucho);

    if (result == null)
      throw new CodigoNoExiste(codigoCartucho);

    return result;
  }

  // devuelve la colección de cartuchos disponibles en la máquina
  // no genera una copia
  public Collection<Cartucho> getAll() {
    return cartuchos.values();
  }
}