package main.java.code;

import java.util.Random;

public enum ServicioTipos {
	ALBAÑIL(20.0),CARPINTERO(30.0),CEJARERO(50.0),ELECTRICISTA(35.0),FONTANERO(40.0),PINTOR(30.0);
	
		double tarifa = 0.0;

// CONSTRUCTOR		
		
    private ServicioTipos(double tarifa) throws IllegalArgumentException {
  		if (tarifa < 0) throw new IllegalArgumentException("Tarifa < 0");
  		this.tarifa = tarifa;}

// VALOR AL AZAR		
    public static ServicioTipos getRandomTipoServicio() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];}
    
// TARIFA
  	public double getTarifa() {return this.tarifa;}
//MAIN
/*
  	public static void main(String[] args) {
  		
  		System.out.println(ServicioTipos.values()[1]);}
*/  		
  }