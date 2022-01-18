import java.util.Arrays;

public class Main {

  static java.util.Scanner in;

  public static void casoDePrueba() {
    int joker[] = new int[7];
    int boleto[] = new int[7];

    int joker_numero = in.nextInt();
    int boleto_numero = in.nextInt();

    for (int i = 0; i < 7; i++) {
      joker[i] = joker_numero % 10;
      joker_numero /= 10;

      boleto[i] = boleto_numero % 10;
      boleto_numero /= 10;
    }

    Arrays.sort(joker);
    Arrays.sort(boleto);

    System.out.println((Arrays.equals(joker, boleto)) ? "GANA" : "PIERDE");

  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    int numCasos = in.nextInt();

    for (int i = 0; i < numCasos; i++)
      casoDePrueba();
  }

}
