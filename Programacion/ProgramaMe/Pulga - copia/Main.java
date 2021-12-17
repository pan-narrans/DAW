import java.sql.PseudoColumnUsage;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {
  static java.util.Scanner in;

  public static void casoDePrueba() {
    int sizeCinta = in.nextInt();
    int nJuegos = in.nextInt();
    int[] juegos = new int[nJuegos];
    int pesoJuegos = 0;

    for (int i = 0; i < nJuegos; i++) {

      int aux = in.nextInt();
      juegos[i] = aux;
      pesoJuegos += aux;


    }

    Arrays.sort(juegos);

    int cara1 = 0, cara2 = 0;

    for (int i = 0; i < juegos.length / 2; i += 2) {

      cara1 = juegos[i] + juegos[juegos.length - 1];
      cara2 = juegos[i + 1] + juegos[juegos.length - 2];

    }

    if ((sizeCinta * 2) < (pesoJuegos)){
      System.out.println("NO");
    }else if (cara1>sizeCinta || cara2>sizeCinta){
      System.out.println("NO");
    }else{
      System.out.println("SI");
    }
  }

  public static void main(String[] args) {
    in = new java.util.Scanner(System.in);
    int nCasos =5;
    for (int i = 0; i < nCasos; i++) {
      casoDePrueba();
    }
  }
}
