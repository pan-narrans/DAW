package divisas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class DatosConversion implements Serializable {

  private static final long serialVersionUID = -5762538584010142383L;

  DivisaCambio divisaCambio;
  Collection<Divisa> divisas;

  public DatosConversion(DivisaCambio divisa) {
    this.divisaCambio = divisa;
    this.divisas      = new ArrayList<>();
  }

  // añade una nueva divisa a la colección
  // puede haber duplicados
  public void add(Divisa divisa) {
    divisas.add(divisa);
  }

  // devuelve la colección de divisas almacenadas
  // no se ha de devolver una copia
  public Collection<Divisa> getAllDivisas() {
    return divisas;
  }

  // realiza la conversión a la colección de divisas almacenadas
  // es necesario devolver una copia para no modificar los datos originales
  // la conversión se realizará se la siguiente forma:
  // divisa.cambio/divisaCambio.valor
  //
  public Collection<Divisa> realizaConversion() {
    Collection<Divisa> result = new ArrayList<>();

    for (Divisa divisa : divisas) {
      result.add(new Divisa(
        divisa.getPais(),
        divisa.getNombreMoneda(),
        divisa.getCambio() / divisaCambio.getValorConversion()));
    }

    return result;
  }

  @Override
  public String toString() {
    return "ConversorDivisas [divisaCambio=" + divisaCambio + ", divisas=" + divisas + "]";
  }

}
