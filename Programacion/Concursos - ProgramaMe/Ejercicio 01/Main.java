public class Main {

  static java.util.Scanner in;

  public static void casoDePrueba() {
    int nAcuarios, capacidadGrande, diferencia, litrosTotal;

    nAcuarios = in.nextInt();
    capacidadGrande = in.nextInt();
    diferencia = in.nextInt();
    litrosTotal = 0;

    for (int i = 0; i < nAcuarios; i++) {
      litrosTotal += capacidadGrande;
      capacidadGrande -= diferencia;
    }

    System.out.println(litrosTotal);
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    int numCasos = in.nextInt();
    for (int i = 0; i < numCasos; i++)
      casoDePrueba();
  }

}
