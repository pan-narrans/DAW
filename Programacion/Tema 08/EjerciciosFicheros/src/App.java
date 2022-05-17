import FicherosPrueba1.Fichero;
import FicherosPrueba1.FicheroBinario;
import FicherosPrueba1.FicheroTexto;
import FicherosPrueba2.GestorFicheros;

public class App {
  public static void main(String[] args) throws Exception {
    // String texto = "En un lugar de la Mancha,\nde cuyo nombre no quiero
    // acordarme,\nno ha mucho tiempo que vivía\nun hidalgo de los de lanza en
    // astillero,\nadarga antigua, rocín flaco y galgo corredor.";

    // Fichero ft = new FicheroTexto();
    // ft.write("testTexto", texto);
    // System.out.println(ft.read("testTexto"));

    // Fichero fb = new FicheroBinario();
    // fb.write("testBinario", texto);
    // System.out.println(fb.read("testBinario"));

    GestorFicheros gestor = new GestorFicheros();
    System.out.println(gestor.crearDirectorio(
        "C:\\Users\\Alumno\\Documents\\GitHub\\DAW\\Programacion\\Tema 08\\EjerciciosFicheros\\src",
        "Directorio De Prueba 1"));

    System.out.println(gestor.crearDirectorio(
        ".\\src",
        "Directorio De Prueba 2"));

    System.out.println(gestor.borrarDirectorio(
        ".\\src",
        "Directorio De Prueba 2"));
  }
}
