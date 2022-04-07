package main.java.code;

import main.java.auxiliar.*;

public class ColaboradorReal extends Persona implements Colaborador {

  private int id = 0;
  ServicioTipos servicio = null;
  Scoring scoring = null;
  private double tarifa = 0.0;
  private boolean disponible = false;

  // CONSTRUCTOR

  public ColaboradorReal() {}

  public ColaboradorReal(int id,
                         ServicioTipos servicio,
                         Scoring scoring,
                         double tarifa,
                         boolean disponible, // Propios del colaborador
                         String NIF,
                         String nombre,
                         int telefono,
                         String eMail) { // Heredados de persona

    super(NIF, nombre, telefono, eMail);
    this.setId(id);
    this.setServicio(servicio);
    this.setScoring(scoring);
    this.setTarifa(tarifa);
    this.setDisponible(disponible);
  }

  // GETTERS
  public int getId() { return this.id; }

  public ServicioTipos getServicio() { return servicio; }

  public Scoring getScoring() { return scoring; }

  public double getTarifa() { return tarifa; }

  public boolean getDisponible() { return disponible; }

  // SETTERS
  public void setId(int id) throws IllegalArgumentException {
    if (id <= 0)
      throw new IllegalArgumentException("Exception: Id <= 0");
    this.id = id;
  }

  public void setServicio(ServicioTipos servicio) { this.servicio = servicio; }

  public void setScoring(Scoring scoring) { this.scoring = scoring; }

  public void setTarifa(double tarifa) throws IllegalArgumentException {
    if (tarifa < 0)
      throw new IllegalArgumentException("Exception: Tarifa < 0.0");
    this.tarifa = tarifa;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  // TO STRING
  @Override public String toString() {
    return Clase.imprimeClase(this) + "Activo: " + this.esActivo() + "\n";
  }

  // EQUAL
  @Override public boolean equals(Object copia) {
    return Clase.comparaObjetos(this, copia);
  }

  // M�TODOS

  // esActivo
  public boolean esActivo() {
    boolean activo = false;
    double tarifaMax = 0.0;

    // Calcula la tarifa máxima para el servicio y scoring del colaborador
    tarifaMax = this.servicio.getTarifa() * (1 - this.scoring.getRebaja());

    // El colaborador está activo si está disponible y su tarifa no sobrepasa el
    // máximo para ese scoring y servicio
    if (this.disponible && this.tarifa <= tarifaMax)
      activo = true;

    return activo;
  }
}