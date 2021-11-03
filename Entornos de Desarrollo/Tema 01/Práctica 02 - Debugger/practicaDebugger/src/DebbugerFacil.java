public class DebbugerFacil {

  /*
   * 3. Ejecuta la clase. Sube el pantallazo de la ejecución ✔
   * 
   * 4. Pon puntos de control en las líneas 12, 13, 14 y 15 ✔
   * 
   * 5. Ejecuta el debugger (con F6) y accede al valor de la variable "intermedio"
   * cuando se le asigna el valor 33. Sube el pantallazo con el valor de las
   * variables, incluyendo los valores de la variable "matriz"
   * 
   * 6. Repite el paso anterior creando un sólo punto de control condicional en la
   * linea 15. Sube el pantallazo del Breakpoint
   */

  public static void main(String[] args) {

    int suma = 0, i = 0, intermedio = 0;
    int matriz[];

    matriz = new int[100];

    for (i = 0; i < 100; i++) {
      suma = suma + i;
      matriz[i] = i;

      if (i == 33) {
        intermedio = i;
        System.out.println(intermedio);
      }

    } // fin for

    System.out.println(suma);
  }// fin main

}// fin debugger facil
