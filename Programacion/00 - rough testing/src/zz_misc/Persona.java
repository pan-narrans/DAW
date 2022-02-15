package zz_misc;
import java.util.Random;

public class Persona {
  protected String nombre, dni;
  protected int edad, peso, altura;
  protected final Sexo SEXO;

  public enum Sexo {
    Hombre, Mujer
  };

  public Persona() {
    this("", generarDNI(), 0, 0, 0, Sexo.Hombre);
  }

  public Persona(String nombre, int edad, Persona.Sexo sexo) {
    this(nombre, null, edad, 0, 0, sexo);
  }

  public Persona(String nombre, String dni, int edad, int peso, int altura, Persona.Sexo sexo) {
    this.nombre = nombre;
    this.dni = dni;
    this.edad = edad;
    this.peso = peso;
    this.altura = altura;
    this.SEXO = sexo;
  }

  public int calcularIMC() {
    float imc = this.altura * this.altura;
    imc = this.peso / imc;

    if (imc < 20)
      return -1;
    else if (imc <= 25)
      return 0;
    else
      return 1;
  }

  public boolean esMayorDeEdad() {
    return (edad < 18) ? false : true;
  }

  private boolean comprobarSexo(char sexo) {
    return (sexo == 'H' | sexo == 'M') ? true : false;
  }

  @Override
  public String toString() {
    return "Persona [SEXO=" + SEXO + ", altura=" + altura + ", dni=" + dni + ", edad=" + edad + ", nombre=" + nombre
        + ", peso=" + peso + "]";
  }

  public static String generarDNI() {
    int num = (int) (Math.random() * 100000000);
    char letra = (char) Math.floor(Math.random() * (90 - 65) + 65);
    return Integer.toString(num) + letra;
  }

}
