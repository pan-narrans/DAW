package main;

public class Alumno {

  // Atributos
  private String nombre = null;
  private String apellido = null;
  private String curso = null;
  private int matesNota = 0;
  private int inglesNota = 0;
  private int historiaNota = 0;

  // Constructor
  // No usamos el atributo curso para facilitar las pruebas

  public Alumno() {
  }

  public Alumno(String nombre, String apellido, int matesNota, int inglesNota, int historiaNota) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.matesNota = matesNota;
    this.inglesNota = inglesNota;
    this.historiaNota = historiaNota;
  }

  // setters

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public void setMatesNota(int matesNota) {
    this.matesNota = matesNota;
  }

  public void setInglesNota(int inglesNota) {
    this.inglesNota = inglesNota;
  }

  public void setHistoriaNota(int historiaNota) {
    this.historiaNota = historiaNota;
  }

  // getters

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getCurso() {
    return curso;
  }

  public int getMatesNota() {
    return matesNota;
  }

  public int getInglesNota() {
    return inglesNota;
  }

  public int getHistoriaNota() {
    return historiaNota;
  }

  // toString
  // Muestra 5 líneas: nombre y apellidos, curso, y asignaturas

  public String toString() {
    String nombreApellido = null;
    String cursoAlumno = null;
    String notas = null;

    nombreApellido = this.getNombre() + " " + this.getApellido() + "\n";
    cursoAlumno = "Curso: " + this.getCurso() + "\n";
    notas = "Mates: " + this.getMatesNota() + "\n";
    notas += "Inglés: " + this.getInglesNota() + "\n";
    notas += "Historia: " + this.getHistoriaNota() + "\n";

    return nombreApellido + cursoAlumno + notas;

  }
}