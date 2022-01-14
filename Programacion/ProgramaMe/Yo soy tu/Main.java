
public class Main {

  static java.util.Scanner in;

  public static void main(String args[]) {
    // Scanner
    in = new java.util.Scanner(System.in);

    // Nº de casos
    int numCasos = in.nextInt();
    in.nextLine();

    String persona;
    String relacion;
    StringBuilder cadena = new StringBuilder();

    // Reto
    for (int i = 0; i < numCasos; i++) {
      cadena = new StringBuilder();
      persona = in.nextLine();
      relacion = in.nextLine();

      if (persona.equals("Luke") && relacion.equals("padre")) {
        cadena.append("TOP SECRET");
      } else {
        cadena.append(persona).append(", yo soy tu ").append(relacion);
      }

      System.out.println(cadena);
    }
  }

}
