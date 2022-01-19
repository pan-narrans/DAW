import java.util.Arrays;
public class Main {

  static java.util.Scanner in;

  public static void casoDePrueba() {
    int[] espumillones = new int[in.nextInt()];

    // Rellenar el array de espumillones
    for (int i = 0; i < espumillones.length; i++) {
      espumillones[i] = in.nextInt();
    }

    Arrays.sort(espumillones);

    System.out.println(Arrays.toString(espumillones));
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    int num_casos = in.nextInt();
    
    for (int i = 0; i < num_casos; i++)
      casoDePrueba();
  }

}
