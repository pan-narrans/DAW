package main;

public class Oficina {

  static final int LIMITE = 120;

  public Etiqueta asignaEtiqueta(Coche coche) {

    if (coche.getPotencia() < LIMITE)
      return Etiqueta.VERDE;

    return (coche.getTipoEnergia() == Combustible.ELECTRICO) ? Etiqueta.VERDE : Etiqueta.ROJA;
  }
}