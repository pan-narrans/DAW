import java.util.ArrayList;
import java.util.EnumMap;

public class Escudería {
  private String nombre;
  private String país;
  private String fecha_fundación;
  private EnumMap < Constantes.PALMARES,
  Integer > palmares;
  private ArrayList<Piloto> pilotos;

  public Escudería(String nombre, String país, String fecha_fundación) {
    this.nombre = nombre;
    this.país = país;
    this.fecha_fundación = fecha_fundación;;
    pilotos = new ArrayList<>();
    palmares = new EnumMap < Constantes.PALMARES,
    Integer > (Constantes.PALMARES.class);
  }

  public void addPiloto(Piloto piloto) {
    pilotos.add(piloto);
  }

  //#region PALMARES SET Y ADD
  /** Asigna un valor concreto al número de oros ganados. */
  public void setOro(int oro) {
    palmares.put(Constantes.PALMARES.ORO, oro);
  }
  /** Añade uno al número de oros ganados. */
  public void addOro() {
    palmares.put(
      Constantes.PALMARES.ORO,
      palmares.get(Constantes.PALMARES.ORO) + 1
    );
  }
  /** Asigna un valor concreto al número de platas ganados. */
  public void setPlata(int plata) {
    palmares.put(Constantes.PALMARES.PLATA, plata);
  }
  /** Añade uno al número de platas ganados. */
  public void addPlata() {
    palmares.put(
      Constantes.PALMARES.PLATA,
      palmares.get(Constantes.PALMARES.PLATA) + 1
    );
  }
  /** Asigna un valor concreto al número de bronces ganados. */
  public void setBronze(int bronze) {
    palmares.put(Constantes.PALMARES.BRONZE, bronze);
  }
  /** Añade uno al número de bronces ganados. */
  public void addBronze() {
    palmares.put(
      Constantes.PALMARES.BRONZE,
      palmares.get(Constantes.PALMARES.BRONZE) + 1
    );
  }
  //#endregion

  @Override public String toString() {
    StringBuilder string = new StringBuilder();
    string.append(nombre + "\t: ");
    string.append("Escudería de " + país + " ");
    string.append("fundada el año " + fecha_fundación + " ");
    string.append("Palmares: " + palmares.toString() + " ");
    return string.toString();
  }

  public Object imprimirEscudería() {
    StringBuilder string = new StringBuilder();
    string.append(nombre + "\t: ");
    string.append("Escudería de " + país + " ");
    string.append("fundada el año " + fecha_fundación + "\n");
    string.append("\t  Palmares: " + palmares.toString() + "\n");
    string.append("\t  Pilotos: ");
    for (Piloto piloto : pilotos) {
      string.append(piloto.getNombre() + ", ");
    }
    string.deleteCharAt(string.length() - 2);
    return string.toString();
  }
}
