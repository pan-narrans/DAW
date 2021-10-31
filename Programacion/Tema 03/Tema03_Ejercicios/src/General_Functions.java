import java.util.Arrays;
import java.math.*;

public class General_Functions {

  // ==== BLOQUE DE IF'S ====//

  /**
   * Checks if two numbers are equal or not.
   * 
   * @param num1
   * @param num2
   * @return True if equal, false if not.
   */
  public boolean testEqual(float num1, float num2) {
    return (num1 == num2) ? true : false;
  }

  /**
   * Checks if a number is positive or not.
   * 
   * @param num
   * @return True if positive, false if not.
   */
  public boolean isPositive(float num) {
    return (num > 0) ? true : false;
  }

  /**
   * Checks if a number is even or odd.
   * 
   * @param num
   * @return True if even, false if odd.
   */
  public boolean isEven(int num) {
    return ((num & 1) == 0) ? true : false;
  }

  /**
   * Checks if two numbers are multiple of each other.
   * 
   * @param num1
   * @param num2
   * @return True if they are multiple, false if not.
   */
  public boolean areMultiple(float num1, float num2) {
    return (num1 % num2 == 0) ? true : (num2 % num1 == 0) ? true : false;
  }

  /**
   * @param num1
   * @param num2
   * @return The biggest of the two numbers.
   */
  public float biggerOfTwo(float num1, float num2) {
    return (num1 - num2 > 0) ? num1 : num2;
  }

  /**
   * @param nums Array of floats.
   * @return Ordered array from the biggest to the smallest.
   */
  public String orderNumbersBigToSmall(float[] nums) {

    for (int m = 0; m < nums.length - 1; m++) {
      for (int n = 0; n < nums.length - 1; n++) {
        if (nums[n] < nums[n + 1]) {
          float aux = nums[n];
          nums[n] = nums[n + 1];
          nums[n + 1] = aux;
        }
      }
    }

    return Arrays.toString(nums);
  }

  /**
   * @param num
   * @return The number of digits of num.
   */
  public int nDigits(int num) {
    int cifras = 0;

    while (num != 0) {
      num /= 10;
      cifras++;
    }

    return cifras;
  }

  /**
   * @param num
   * @return The number written back to front.
   */
  public int reverseDigits(int num) {
    int reversed = 0, nDigits = nDigits(num);

    for (int i = 0; i < nDigits; i++) {
      reversed = reversed * 10 + num % 10;
      num /= 10;
    }

    return reversed;
  }

  /**
   * Checks if a number is palindromic <i>(reads the same back to front as front
   * to back)</i> or not.
   * <p>
   * <i>Ex: 1001 -> true </i>
   * <p>
   * <i>Ex: 1201 -> false </i>
   * 
   * @param num
   * @return True if palindromic, false if not.
   */
  public boolean isPalindromic(int num) {
    int nDigits, fstDigit, lstDigit;
    boolean palindromic = true;

    nDigits = nDigits(num);

    for (int i = 0; i < (nDigits + 1) / 2; i++) {
      nDigits = nDigits(num);

      lstDigit = num % 10;
      fstDigit = num / (int) (Math.pow(10, nDigits - 1));

      if (lstDigit != fstDigit) {
        palindromic = false;
        break;
      }

      num = (int) (num - fstDigit * Math.pow(10, nDigits - 1)) / 10;
    }

    return palindromic;
  }

  enum Apreciaciones {
    Insuficiente, Suficiente, Bien, Notable, Sobresaliente, Inválido
  }

  public Apreciaciones getScore(int score) {
    Apreciaciones appreciation = Apreciaciones.Inválido;
    if (score < 0 | score > 10) {
      appreciation = Apreciaciones.Inválido;
    }
    return appreciation;
  }

  /**
   * @param year
   * @return True if its a leap {@code year}, false if not.
   */
  public boolean isLeapYear(int year) {
    return (year % 4 == 0 & year % 100 != 0 | year % 400 == 0) ? true : false;
  }

  /**
   * @param day
   * @param month
   * @param year
   * @return True if date is plausible, false if not.
   */
  public boolean validateDate(int day, int month, int year) {
    boolean isValid = true;
    boolean leap = isLeapYear(year);

    // comprobar que tengamos entre 1 y 31 días
    // y entre 1 y 12 meses
    if (day < 1 | day > 31 | month < 1 | month > 12) {
      isValid = false;
    }
    // comprobar que los meses de 30 días no tengan 31
    else if (day == 31 & (month == 4 | month == 6 | month == 9 | month == 11)) {
      isValid = false;
    }
    // febrero
    else if (month == 2 & day > 28) {
      isValid = false;
      if (leap & day == 29) {
        isValid = true;
      }
    }

    return isValid;
  }

  /**
   * 
   * @param day
   * @param month
   * @param year
   * @return "Impossible date" if the date introduced is not valid.
   *         <p>
   *         "dd/mm/yyyy" the next day if the date is valid.
   */
  public String nextDay(int day, int month, int year) {
    boolean valid = validateDate(day, month, year);
    String date = "Impossible date";

    if (valid) {
      if (validateDate(++day, month, year)) {
        ;
      } else if (validateDate(day = 1, ++month, year)) {
        ;
      } else if (validateDate(day = 1, month = 1, ++year)) {
        ;
      }
      date = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
    }

    return date;
  }
}
