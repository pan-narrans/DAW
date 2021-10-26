public class General_Functions {

  public boolean testEqual(float num1, float num2) {
    return (num1 == num2) ? true : false;
  }

  public boolean isPositive(float num) {
    return (num > 0) ? true : false;
  }

  public boolean isEven(int num) {
    return ((num & 1) == 0) ? true : false;
  }

}
