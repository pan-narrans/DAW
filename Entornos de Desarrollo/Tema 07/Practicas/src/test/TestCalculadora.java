package test;

import calculadora.Calculadora;

public class TestCalculadora {
  public static void main(String[] args) {
    Calculadora calc = new Calculadora();

    assert calc.sumar(1, 1) == 2 : "Error.";
    assert calc.restar(1, 1) == 0 : "Error.";
    assert calc.multiplicar(1, 1) == 1 : "Error.";
    assert calc.dividir(1, 1) == 3 : "Error.";

  }
}
