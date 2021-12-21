public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    long n, cifra, suma = 0;
    String igualdad = "";
    n = in.nextLong();

    if (n < 0) // Exit condition
      return false;

    cifra = n % 10;
    suma += cifra;
    n /= 10;
    igualdad += cifra;

    while (n > 0) {
      cifra = n % 10;
      suma += cifra;
      n /= 10;
      igualdad = cifra + " + " + igualdad;
    }

    igualdad = igualdad + " = " + suma;

    System.out.println(igualdad);

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
