public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int v = 0, i = 0;
    char c = in.next().charAt(0);
    boolean seguir = true;

    if (c == '.') // Exit condition
      return false;

    do {
      switch (c) {
        case 'A':
          i++;
        case 'V':
          v++;
          break;
        case 'I':
          i++;
          break;
        case '.':
        default:
          seguir = false;
          break;
      }

      if (seguir)
        c = in.next().charAt(0);

    } while (seguir);

    System.out.println((v == i) ? "EMPATE" : (v > i) ? "VERANO" : "INVIERNO");

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
