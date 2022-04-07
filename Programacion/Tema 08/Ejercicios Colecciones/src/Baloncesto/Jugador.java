package Baloncesto;

public class Jugador {
  private String nombre;
  private int edad;
  private String nombreEquipo;
  private int numCanastasIntroducidas;
  private String ciudad;

  public Jugador(String nombre, int edad, String nombreEquipo, int numCanastasIntroducidas, String ciudad) {
    this.nombre = nombre;
    this.edad = edad;
    this.nombreEquipo = nombreEquipo;
    this.numCanastasIntroducidas = numCanastasIntroducidas;
    this.ciudad = ciudad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getNombreEquipo() {
    return nombreEquipo;
  }

  public void setNombreEquipo(String nombreEquipo) {
    this.nombreEquipo = nombreEquipo;
  }

  public int getNumCanastasIntroducidas() {
    return numCanastasIntroducidas;
  }

  public void setNumCanastasIntroducidas(int numCanastasIntroducidas) {
    this.numCanastasIntroducidas = numCanastasIntroducidas;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  @Override
  public String toString() {
    return "Jugador [ciudad=" + ciudad + ", edad=" + edad + ", nombre=" + nombre + ", nombreEquipo=" + nombreEquipo
        + ", numCanastasIntroducidas=" + numCanastasIntroducidas + "]";
  }

  public int compareByName(Jugador jugador) {
    return this.getNombre().compareTo(jugador.getNombre());
  }

}
