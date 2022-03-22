import java.util.ArrayList;

public class Carrera {
  protected Constantes.TIPO tipo;
  protected String lugar;
  protected String day;
  protected String hora_init;
  protected String hora_fin;
  protected ArrayList<Escudería> escuderías;

  public Carrera(
    Constantes.TIPO tipo,
    String lugar,
    String day,
    String hora_init,
    String hora_fin
  ) {
    this.tipo = tipo;
    this.lugar = lugar;
    this.day = day;
    this.hora_init = hora_init;
    this.hora_fin = hora_fin;
    this.escuderías = new ArrayList<>();
  }

  public void addEscudería(Escudería escudería) {
    escuderías.add(escudería);
  }

  @Override public String toString() {
    StringBuilder string = new StringBuilder();
    string.append(tipo + " ");
    string.append(lugar + ", ");
    string.append(day + " ");
    string.append("desde las " + hora_init + " ");
    string.append("hasta las " + hora_fin + ".");
    return string.toString();
  }

  public String imprimirCarrera() {
    StringBuilder string = new StringBuilder();
    string.append(tipo + "\t: ");
    string.append(lugar + ", ");
    string.append(day + " ");
    string.append("desde las " + hora_init + " ");
    string.append("hasta las " + hora_fin + ".");
    string.append("\n\t  Compiten las escuderías:");
    for (Escudería escudería : escuderías) {
      string.append("\n" + escudería.imprimirEscudería());
    }
    return string.toString();
  }

}
