import java.util.HashMap;

public class Piloto {
  /** Nombre del piloto. */
  private String nombre;
  /** Nacionalidad del piloto. */
  private String nacionalidad;
  /** Fecha de nacimiento del piloto. */
  private String fecha_nacimiento;
  /** Historial por año de las escuderías del piloto. */
  private HashMap<Integer, Escudería> historial_escuderías;
  /** Ranking por año del piloto. */
  private HashMap<Integer, Integer> ranking;

  public Piloto(String nombre, String nacionalidad, String fecha_nacimiento) {
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
    this.fecha_nacimiento = fecha_nacimiento;
    historial_escuderías = new HashMap<>();
    ranking = new HashMap<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void addEscudería(int año, Escudería escudería) {
    historial_escuderías.put(año, escudería);
  }
  
  /** Añade un valor al ranking del piloto. */
  public void addRanking(int año, int posición) {
    ranking.put(año, posición);
  }

  @Override public String toString() {
    StringBuilder string = new StringBuilder();
    string.append("Piloto " + nacionalidad + " ");
    string.append("nacido el " + fecha_nacimiento + ". ");
    return string.toString();
  }

}
