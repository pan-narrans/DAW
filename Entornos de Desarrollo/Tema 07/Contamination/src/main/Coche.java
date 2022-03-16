package main;

public class Coche {

    private Combustible tipoEnergia;
    private int potencia = 1000;

// Constructores
    
    public Coche (Combustible energia){this.tipoEnergia = energia;}
    public Coche (Combustible energia, int potencia){this.tipoEnergia = energia; this.potencia = potencia;}

// getters
    
    public Combustible getTipoEnergia() {return tipoEnergia;}
    public int getPotencia() {return potencia;}

// setters
    
    public void setPotencia(int potencia) {this.potencia = potencia;}
    public void setTipoEnergia(Combustible combustible) {this.tipoEnergia = combustible;}
}