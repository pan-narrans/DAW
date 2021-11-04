package Alex_Ressources;

// TESTING
/* import org.junit.Test;
import static org.junit.Assert.assertEquals; */

public class Functions_General {

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
  public float[] orderNumbersBigToSmall(float[] nums) {
    for (int m = 0; m < nums.length - 1; m++) {
      for (int n = 0; n < nums.length - 1; n++) {
        if (nums[n] < nums[n + 1]) {
          float aux = nums[n];
          nums[n] = nums[n + 1];
          nums[n + 1] = aux;
        }
      }
    }
    return nums;
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

    // Comprobar que tengamos entre 1 y 31 días y entre 1 y 12 meses.
    if (day < 1 | day > 31 | month < 1 | month > 12) {
      isValid = false;
    }
    // Comprobar que los meses de 30 días no tengan 31.
    else if (day == 31 & (month == 4 | month == 6 | month == 9 | month == 11)) {
      isValid = false;
    }
    // Febrero.
    else if (day > 28 & month == 2) {
      isValid = false;
      if (leap & day == 29) {
        isValid = true;
      }
    }

    return isValid;
  }
}
