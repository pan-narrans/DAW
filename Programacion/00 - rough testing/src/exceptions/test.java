package exceptions;

public class test {
  public static void main(String[] args) {
    System.out.println("Start of code");

    try {
      method2();
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("End of code");
  }

  private static void method2() throws Exception {
    System.out.println("Entering method 2:");

    method1(0);

    System.out.println("Exiting method 2:");
  }

  private static void method1(int i) throws Exception {
    System.out.println("Entering method 1:");

    if (i == 0)
      throw new Exception("The int is zero.");

    System.out.println("Exiting method 1:");
  }
}
