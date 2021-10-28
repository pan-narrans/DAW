import java.util.Arrays;
import java.math.*;

public class General_Functions {

  // ==== BLOQUE DE IF'S ====//

  public boolean testEqual(float num1, float num2) {
    return (num1 == num2) ? true : false;
  }

  public boolean isPositive(float num) {
    return (num > 0) ? true : false;
  }

  public boolean isEven(int num) {
    return ((num & 1) == 0) ? true : false;
  }

  public boolean areMultiple(float num1, float num2) {
    return (num1 % num2 == 0) ? true : (num2 % num1 == 0) ? true : false;
  }

  public float biggerOfTwo(float num1, float num2) {
    return (num1 - num2 > 0) ? num1 : num2;
  }

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

  public int nDigits(short num) {
    int cifras = 0;

    if (0 > num | num > 9999) {
      cifras = -1;
    } else {
      while (num != 0) {
        num /= 10;
        cifras++;
      }
    }

    return cifras;
  }

  public int reverseDigits(short num) {
    int reversed = 0, nDigits = nDigits(num);

    if (0 > num | num > 9999) {
      reversed = -1;
    } else {
      for (int i = 0; i < nDigits; i++) {
        reversed = reversed * 10 + num % 10;
        num /= 10;
      }
    }

    return reversed;
  }

  public boolean isPalindromic(short num) {
    int nDigits = nDigits(num);
    boolean palindromic = true;

    for (int i = 0; i < (nDigits + 1) / 2; i++) {
      nDigits = nDigits(num);
      if (num % 10 != num / Math.pow(10, nDigits - 1)) {
        palindromic = false;
      }
      //num = num - (num / (short) (Math.pow(10, nDigits - 1)));
    }

    return palindromic;
  }
}
