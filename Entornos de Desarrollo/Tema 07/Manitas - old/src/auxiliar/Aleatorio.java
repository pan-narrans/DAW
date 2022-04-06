package auxiliar;

import java.util.Random;

public class Aleatorio {
	
	static Random random = new Random();
	
	public static double darDouble (double min, double max, int precision) {
		
    if (precision < 0) throw new IllegalArgumentException("Precisión < 0");
		
		double aleatorioDouble = 0.0;
		double redondeo = Math.pow(10, precision);

		aleatorioDouble = min + (max-min)*random.nextDouble();			
		aleatorioDouble = Math.round(aleatorioDouble*redondeo)/redondeo; 		  
		
    return aleatorioDouble;
	}	
		
	public static int darInt (int min, int max) {
		
    if (max < min) throw new IllegalArgumentException("max < min");
		    
		double aux = Aleatorio.darDouble(min, max, 0);
		return (int)aux;}		
		 	

	public static String darString (int nChar) {   

    if (nChar < 0) throw new IllegalArgumentException("nChar < 0");

		String aleatorioString = "";
		char ascii;
		
		for (int i = 0; i < nChar-1; i++) {
			ascii = (char)random.nextInt(97,122);
			aleatorioString += ascii;}
		
		return aleatorioString;}
	
	public static boolean darBoolean () {return random.nextBoolean();}
	
	
// MAIN
	
  public static void main(String[] args) {
 	for (int i = 0; i < 10; i++) {
  			System.out.println(Aleatorio.darDouble(-10, 10, 0));
  			System.out.println(Aleatorio.darInt(-10, 10));
  			System.out.println(Aleatorio.darString(10));
  			System.out.println(Aleatorio.darBoolean());}
	}
}
