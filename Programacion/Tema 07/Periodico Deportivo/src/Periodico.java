import java.util.ArrayList;

public class Periodico {

  public static void main(String[] args) {

    ArrayList<Piloto> pilotos = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Carrera> carreras = new ArrayList<>();

    Carrera c1 = new Carrera(
      "motos",
      "mocano",
      "lunes",
      "las cuatro",
      "mas menos las 8"
    );
    System.out.println(c1);
    Team rebBull = new Team(1);

    c1.addTeam(rebBull);

    carreras.add(c1);
    System.out.println(c1);

  }
}
