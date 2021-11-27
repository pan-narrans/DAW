public class roman {

  public static void main(String[] args) {
    int number = 0;
    number = 3550;
    System.out.println(number + " = " + solution(number));
    number = 4400;
    System.out.println(number + " = " + solution(number));
    number = 424440;
    System.out.println(number + " = " + solution(number));
  }

  public static String solution(int number) {
    String romanNumber = "";
    String romanDigit = "";
    String[] romanValues = { "I", "V", "X", "L", "C", "D", "M", "_V", "_X", "_L", "_C", "_D", "_M" };

    for (int i = nDigits(number); i > 0; i--) {
      // (i * 2) - 1 points us to the part of the array corresponding to the digit
      // digit 1 -> indexes 0,1,2
      // digit 2 -> indexes 2,3,4
      // digit 3 -> indexes 4,5,6 ...
      // -1 , +0 and +2 adjusts the index to select the correct value
      switch (getDigit(number, i)) {
      // I II and III
      case 3:
        romanDigit += romanValues[(i * 2) - 2];
      case 2:
        romanDigit += romanValues[(i * 2) - 2];
      case 1:
        romanDigit += romanValues[(i * 2) - 2];
        break;
      // IV and V
      case 4:
        romanDigit = (i == 4) ? "_I" : romanDigit + romanValues[(i * 2) - 2];
      case 5:
        romanDigit += romanValues[(i * 2) - 1];
        break;
      // VI VII and VII
      case 8:
        romanDigit += romanValues[(i * 2) - 2];
      case 7:
        romanDigit += romanValues[(i * 2) - 2];
      case 6:
        romanDigit += romanValues[(i * 2) - 2];
        romanDigit = romanValues[(i * 2) - 1] + romanDigit;
        break;
      // IX
      case 9:
        romanDigit += romanValues[(i * 2) - 2];
        romanDigit += romanValues[(i * 2)];
        break;
      default:
        break;
      }// End Switch
      romanNumber += romanDigit;
      romanDigit = "";
    } // End For

    return romanNumber;
  }

  /**
   * @param number
   * @param n      : romanDigit to fetch
   * @return Returns the nth romanDigit of a number.
   */
  public static int getDigit(int number, int n) {
    return (number / (int) Math.pow(10, n - 1)) % 10;
  }

  /**
   * Only works with positive numbers != 0.
   * 
   * @param number
   * @return Returns the number of romanDigits of "number"
   */
  public static int nDigits(int number) {
    return (int) (Math.log10(number) + 1);
  }
}