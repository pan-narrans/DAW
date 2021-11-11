public class B05_while extends Bloque {

  public void main() {
    System.out.println("Bloque 04 de ejercicios.\n");

    final int N_EJERCICIOS = 4;

    // Inicialización de ejercicios
    Ejercicio[] ejercicios = new Ejercicio[N_EJERCICIOS];
    ejercicios[0] = new B05_E01("\t Ejercicio 01: calcula la media.");
    ejercicios[1] = new B05_E02("\t Ejercicio 02: calcula si un nº es primo o no.");
    ejercicios[2] = new B05_E03("\t Ejercicio 03: jugar a advinar un nº aleatorio.");
    ejercicios[3] = new B05_E04("\t Ejercicio 04: .");

    // ESCOGER EJERCICIO
    chooseExercise(ejercicios);

  }// Fin main.

  /**
   * Bloque 03 - Ejercicio 01
   */
  private class B05_E01 extends Ejercicio {

    /**
     * Escribir la función float media (float... notas), que reciba un número
     * variable de notas de tipo float de una asignatura y calcule la media
     * utilizando un bucle while en formato float también.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B05_E01(String info) {
      setSelfInfo(info);
    }

    public void main() {
      System.out.println("La media de las notas es:" + media(5, 7.5f, 5, 6, 8, 5, 6.4f, 3, 9f, 8.2f, 7, 9, 3, 8));
    }

    float media(float... notas) {
      int media = 0;
      for (float nota : notas) {
        media += nota;
      }
      media /= notas.length;
      return media;
    }

    float mediaConWhile(float... notas) {
      int media = 0, i = 0;
      while (i++ < notas.length) {
        media += notas[i];
      }
      media /= notas.length;
      return media;
    }

  } // Fin Ejercicio 01

  /**
   * Bloque 03 - Ejercicio 02
   */
  private class B05_E02 extends Ejercicio {

    /**
     * Escribir la función boolean esPrimo (int numero) que utilizando un bucle
     * while devuelva que true si un número es primo y false en caso contrario
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B05_E02(String info) {
      setSelfInfo(info);
    }

    public void main() {
      int num;
      System.out.println("Introduce el número:");
      num = validate.inputType(1);
      System.out.println("El nº" + num + (esPrimoWhile(num) ? " es " : " no es ") + "primo.");
    }

    boolean esPrimo(int num) {
      if (num <= 1)
        return false;

      for (int i = 2; i < num / 2; i++) {
        if (num % i == 0)
          return false;
      }

      return true;
    }

    boolean esPrimoWhile(int num) {
      boolean result = true;
      int i = 2;

      if (num <= 1) {
        result = false;
      } else {
        while (result & i++ < num / 2) {
          if (num % i == 0)
            result = false;
        }
      }

      return result;
    }

  } // Fin Ejercicio 02

  /**
   * Bloque 03 - Ejercicio 03
   */
  private class B05_E03 extends Ejercicio {

    /**
     * Escriba el procedimiento void adivinarNumero () para jugar a adivinar un
     * número entre 1 y 100 utilizando la sentencia {@code Math.random()*100 + 1}
     * <p>
     * Mostrará los siguientes el mensaje “Adivina el número” y leerá un número
     * hasta que acierte utilizando un bucle while.
     * <p>
     * En caso de ser mayor mostrará: “El número es mayor”
     * <p>
     * En caso contrario mostrará: “El número es menor”
     * <p>
     * Cuando acierte mostrará, y podremos jugar otra partida o salir. “Acertaste
     * quieres jugar otra vez (s/n)” utilizando otro bucle do while.
     * 
     * @param info pequeña descripción del ejercicio
     */
    public B05_E03(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
      // int num;
      // System.out.println("Introduce el número:");
      // num = validate.inputType(1);
      adivinarNumero();
    }

    void adivinarNumero() {
      boolean adivinado, seguirJugando;
      int aleatorio, num;
      char c;
      adivinado = seguirJugando = false;

      do {
        System.out.println("Adivina el número");
        aleatorio = (int) (Math.random() * 100 + 1);
        adivinado = false;

        do {
          num = validate.inputType(1);
          if (num < aleatorio) {
            System.out.println("El número es mayor");
          } else if (num > aleatorio) {
            System.out.println("El número es menor");
          } else {
            adivinado = true;
          }
        } while (!adivinado);

        System.out.println("¡Has adivinado el número!");
        System.out.println("¿Quieres seguir jugando? s/n");
        c = validate.inputType('c');
        seguirJugando = (c == 's' | c == 'S') ? true : false;
      } while (seguirJugando);
    }

  } // Fin Ejercicio 03

  /**
   * Bloque 03 - Ejercicio 04
   */
  private class B05_E04 extends Ejercicio {

    /**
     * @param info pequeña descripción del ejercicio
     */
    public B05_E04(String info) {
      setSelfInfo(info);
    }

    public void main() {
      // TODO
      // int num;
      // System.out.println("Introduce el número:");
      // num = validate.inputType(1);
    }

  } // Fin Ejercicio 04

}
