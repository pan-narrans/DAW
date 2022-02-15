package zz_misc;
public class Triangle {
  static int nLados = 3;
  protected int side1, side2, side3;

  public static int getNLados() {
    return nLados;
  }

  public static void setNLados(int num) {
    Triangle.nLados = num;
  }

  Triangle() {
    this(3);
  }

  Triangle(int side) {
    this(side, side, side);
  }

  Triangle(int side1, int side2, int side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  public int getSide1() {
    return side1;
  }

  public void setSide1(int side1) {
    this.side1 = side1;
  }

  public int getSide2() {
    return side2;
  }

  public void setSide2(int side2) {
    this.side2 = side2;
  }

  public int getSide3() {
    return side3;
  }

  public void setSide3(int side3) {
    this.side3 = side3;
  }

  public int perimeter() {
    return side1 + side2 + side3;
  }

  // public float height() {
  //
  // }
  // public int base() {
  // return Math.max(side1, Math.max(side2, side3));
  // }

  public double area() {
    double sP = (double) perimeter() / 2;

    return Math.sqrt(sP * (sP - side1) * (sP - side2) * (sP - side3));
  }
}
