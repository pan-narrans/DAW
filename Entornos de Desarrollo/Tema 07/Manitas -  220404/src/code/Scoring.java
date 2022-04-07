package code;

import java.util.Random;

// Los colaboradores pueden tener tres tipos de Scoring: alto, medio y bajo. Eso fija la tarifa máxima que se les pagará por el servicio

public enum Scoring {ALTO(0.0),MEDIO(0.25),BAJO(0.5);

	private double rebaja; // % de reducción sobre la tarifa máxima por servicio en función del scoring. 
	
// Constructor
	
	private Scoring(double rebaja) throws IllegalArgumentException {
		if (rebaja < 0.0 || rebaja > 1.0) throw new IllegalArgumentException("Exception: Rebaja inválida");
		this.rebaja = rebaja;}
	
//VALOR AL AZAR		
  public static Scoring getRandomTipoScoring() {
      Random random = new Random();
      return values()[random.nextInt(values().length)];}	
//REBAJA	
  public double getRebaja() {return this.rebaja;}
	
}
