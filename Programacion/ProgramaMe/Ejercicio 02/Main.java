import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

  static java.util.Scanner in;

  public static void main(String args[]) {
    in = new java.util.Scanner(System.in);
    /*
     * while (intento2())
     * ;
     */

    Date fecha = new Date();
    fecha.setTime(90000000000000000L);
    System.out.println(fecha);

    //GregorianCalendar fechaNacimiento = new GregorianCalendar(1996, 5, 9);
    //GregorianCalendar fechaActual = new GregorianCalendar(1996, 5, 9);
    //System.out.println(fechaNacimiento.get(fechaNacimiento.DAY_OF_MONTH) + "/" + fechaNacimiento.get(fechaNacimiento.MONTH) + "/" + fechaNacimiento.get(fechaNacimiento.YEAR));
  }

  public static boolean intento2() {
    int birthDay = in.nextInt();
    int birthMonth = in.nextInt();
    int birthYear = in.nextInt();
    int diaA = in.nextInt();
    int mesA = in.nextInt();
    int yearA = in.nextInt();
    int total = 1;

    GregorianCalendar fechaNacimiento = new GregorianCalendar(birthDay, birthMonth, birthYear);
    System.out.println(fechaNacimiento);

    if (birthDay == 0 && diaA == 0 && birthMonth == 0 && mesA == 0 && birthYear == 0 && yearA == 0) {
      return false;
    } else if (birthMonth == mesA && birthDay == diaA) { // Es nuestro cumple
      System.out.println(0);
      return true;
    }

    if (birthMonth <= mesA && birthDay < diaA) { // Ha sido nuestro cumple
      total--;
    }

    total += daysTillNewYear(birthMonth, birthDay);
    total -= daysTillNewYear(mesA, diaA);
    total += ((yearA - birthYear) * 364);

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
