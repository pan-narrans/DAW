public class Conversion {

  public static void main(String[] args) {
    System.out.println(solution(5643));
  }

  public static String solution(int n) {
    String roman = "";
    int[] romanNumerals = { 1000, 500, 100, 50, 10, 5, 1 };
    char[] romanValues = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };

    /*
     * comprobar el ultimo decimal e ir restanto
     * 
     * ir tirando por el array para saber a que letra corresponde
     */
    for (int i = 0; i < romanValues.length; i++) {

    }
    return roman;
  }
}