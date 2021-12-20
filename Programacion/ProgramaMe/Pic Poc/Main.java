public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int nSonidos = in.nextInt();
    if (nSonidos == 0)
      return false;

    int j1 = 0, j2 = 0;
    boolean campo = true; // 0 \ 1

    for (int i = 0; i < nSonidos; i++) {
      // *
      String sonido = in.next();
      if (sonido.equals("PIC")) {
        campo = !campo;
      } else if (sonido.equals("PONG!")) {
        if (campo)
          j1++;
        else
          j2++;
      } // */
    }

    System.out.println(j1 + " " + j2);

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
    in.close();
  }

}