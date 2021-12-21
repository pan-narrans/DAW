
public class Main {

  static java.util.Scanner in;

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    while (intento2())
      ;
  }

  public static boolean intento2() {
    int diaN = in.nextInt();
    int mesN = in.nextInt();
    int yearN = in.nextInt();
    int diaA = in.nextInt();
    int mesA = in.nextInt();
    int yearA = in.nextInt();
    int total = 1;

    if (diaN == 0 && diaA == 0 && mesN == 0 && mesA == 0 && yearN == 0 && yearA == 0) {
      return false;
    } else if (mesN == mesA && diaN == diaA) { // Es nuestro cumple
      System.out.println(0);
      return true;
    }

    if (mesN <= mesA && diaN < diaA) { // Ha sido nuestro cumple
      total--;
    }

    total += daysTillNewYear(mesN, diaN);
    total -= daysTillNewYear(mesA, diaA);
    total += ((yearA - yearN) * 364);

    System.out.println(total);

    return true;
  }

  public static int daysTillNewYear(int month, int day) {
    int result = 0;
    int meses[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    for (int i = month; i < meses.length; i++) {
      result += meses[i];
    }

    return result - day;
  }

}
