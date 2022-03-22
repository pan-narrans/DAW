import java.util.ArrayList;

public class Periódico {

  public static void main(String[] args) {

    ArrayList<Piloto> pilotos = new ArrayList<>();
    ArrayList<Escudería> escuderías = new ArrayList<>();
    ArrayList<Carrera> carreras = new ArrayList<>();

    // ESCUDERÍAS
    Escudería redBull = new Escudería("REDBULL", "Australia", "2005");
    Escudería bmw = new Escudería("BMW", "Alemania", "1952");
    escuderías.add(redBull);
    escuderías.add(bmw);

    // PILOTOS
    Piloto piloto1 = new Piloto("Alex", "Español", "09/06/1996");
    Piloto piloto2 = new Piloto("Pablo", "Español", "09/06/1996");
    Piloto piloto3 = new Piloto("Pablo", "Español", "09/06/1996");
    Piloto piloto4 = new Piloto("Cristina", "Español", "09/06/1996");
    pilotos.add(piloto1);
    pilotos.add(piloto2);
    pilotos.add(piloto3);
    pilotos.add(piloto4);

    // CARRERAS
    Carrera carrera1 = new Carrera(
      Constantes.TIPO.MOTO_GP,
      "Circuito de Spa-Francorchamps",
      "Viernes 6",
      "6:00",
      "14:00"
    );
    Carrera carrera2 = new Carrera(
      Constantes.TIPO.MOTO_GP,
      "Circuito de Spa-Francorchamps",
      "Sábado 7",
      "6:00",
      "14:00"
    );
    Carrera carrera3 = new Carrera(
      Constantes.TIPO.MOTO_GP,
      "Circuito de Spa-Francorchamps",
      "Sábado 7",
      "6:00",
      "14:00"
    );
    carreras.add(carrera1);
    carreras.add(carrera2);
    carreras.add(carrera3);

    // AÑADIR EL RESTO DE CAMPOS
    piloto1.addEscudería(2004, redBull);
    piloto2.addEscudería(2005, redBull);
    piloto3.addEscudería(2005, bmw);
    piloto4.addEscudería(2005, bmw);

    piloto1.addRanking(2004, 1);
    piloto2.addRanking(2005, 2);
    piloto3.addRanking(2005, 1);
    piloto4.addRanking(2005, 3);

    redBull.setOro(5);
    redBull.setPlata(10);
    redBull.setBronze(3);
    redBull.addPiloto(piloto1);
    redBull.addPiloto(piloto2);

    bmw.setOro(6);
    bmw.setPlata(15);
    bmw.setBronze(17);
    bmw.addPiloto(piloto3);
    bmw.addPiloto(piloto4);

    carrera1.addEscudería(redBull);
    carrera2.addEscudería(redBull);
    carrera3.addEscudería(redBull);
    carrera1.addEscudería(bmw);
    carrera2.addEscudería(bmw);
    carrera3.addEscudería(bmw);

    for (Carrera carrera : carreras) {
      System.out.println(carrera.imprimirCarrera() + "\n");
    }

  }

  public static void imprimir(ArrayList array) {
    for (Object object : array) {
      System.out.println(object);
    }
    System.out.println("");
  }
}
