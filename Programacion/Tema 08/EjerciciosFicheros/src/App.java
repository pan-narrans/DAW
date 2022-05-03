import Ficheros.Fichero;
import Ficheros.FicheroBinario;
import Ficheros.FicheroTexto;

public class App {
  public static void main(String[] args) throws Exception {
    String texto = "En un lugar de la Mancha,\nde cuyo nombre no quiero acordarme,\nno ha mucho tiempo que vivía\nun hidalgo de los de lanza en astillero,\nadarga antigua, rocín flaco y galgo corredor.";

    Fichero ft = new FicheroTexto();
    ft.write("testTexto", texto);
    System.out.println(ft.read("testTexto"));

    Fichero fb = new FicheroBinario();
    fb.write("testBinario", texto);
    System.out.println(fb.read("testBinario"));
  }
}
