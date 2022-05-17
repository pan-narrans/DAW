package FicherosPrueba1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FicheroTexto implements Fichero {

  @Override
  public void write(String fileName, String content) {
    PrintWriter out = null;

    try {
      out = new PrintWriter(new FileWriter(fileName));
      out.print(content);
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      if (out != null)
        out.close();
    }

  }

  @Override
  public Object read(String fileName) {
    Scanner in = null;
    StringBuilder result = null;
    try {
      in = new Scanner(new FileReader(fileName));
      in.useLocale(Locale.ROOT);
      result = new StringBuilder();

      // lee el fichero palabra a palabra
      while (in.hasNext()) {
        result.append(in.nextLine() + "\n");
      }
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      if (in != null) {
        in.close();
      }
    }

    return (result != null) ? result.toString() : result;
  }

}
