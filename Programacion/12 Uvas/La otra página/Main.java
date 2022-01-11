
public class Main {

  static java.util.Scanner in;

  public static void casoDePrueba() {
    int page = in.nextInt();
    System.out.println( (page % 2 == 0) ? ++page : --page);
  }

  public static void main(String args[]) {

    in = new java.util.Scanner(System.in);
    int numCasos = in.nextInt();
    
    for (int i = 0; i < numCasos; i++)
      casoDePrueba();
  }

}
