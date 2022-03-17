import java.util.ArrayList;

public class Carrera {
  protected String tipo;
  protected String lugar;
  protected String day;
  protected String hora_init;
  protected String hora_fin;
  protected ArrayList<Team> teams;

  public Carrera(
    String tipo,
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
    this.teams = new ArrayList<>();
  }

  public void addTeam(Team e) {
    teams.add(e);
  }

  @Override public String toString() {
    return "Carrera [day=" + day + ", hora_fin=" + hora_fin + ", hora_init=" +
        hora_init + ", lugar=" + lugar + ", teams=" + teams + ", tipo=" + tipo + "]";
  }

}
