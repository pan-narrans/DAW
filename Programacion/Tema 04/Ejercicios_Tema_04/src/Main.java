public class Main {
  public static void main(String[] args) throws Exception {

    Ejercicios_Arrays ej1 = new Ejercicios_Arrays();

    int[] numeros = new int[4];
    int[] pares = { 23, 2, 23, 4, 2, 35, 34, 5, 23, 3, 4, 1, 2, 5, 1, 2, 34 };
    // ej1.rellenarArray(numeros);
    // ej1.imprimirArray(numeros);

    ej1.imprimirArray(ej1.filtrarPares(pares));
  }
}
