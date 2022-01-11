import java.util.ArrayList;

public class Main {

  static java.util.Scanner in;

  public static boolean casoDePrueba() {
    int n;
    n = in.nextInt();

    if (!in.hasNext()) // Exit condition
      return false;

    int calcetin, max_desparejados = 1;
    ArrayList<Integer> mesa = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {

      calcetin = in.nextInt();

      if (mesa.contains(calcetin)) {
        mesa.remove(Integer.valueOf(calcetin));
      } else {
        mesa.add(calcetin);
      }

      if (max_desparejados < mesa.size())
        max_desparejados = mesa.size();

    }

    System.out.println(max_desparejados);

    return true;
  }

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (casoDePrueba())
      ;
  }

}
