
public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int n_notas, notas = 0, nota_prometida, nota_necesaria;

    n_notas = in.nextInt();

    if (n_notas == 0) // Exit condition
      return false;

    for (int i = 0; i < n_notas; i++) {
      notas += in.nextInt();
    }

    nota_prometida = in.nextInt();

    nota_necesaria = nota_prometida * (n_notas + 1) - notas;

    System.out.println((nota_necesaria > 10 || nota_necesaria < 0) ? "IMPOSIBLE" : nota_necesaria);

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}