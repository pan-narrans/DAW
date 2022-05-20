package FicherosPrueba1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FicheroBinario implements Fichero {

  @Override
  public Object read(String fileName) {
    StringBuilder result = null;
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(new FileInputStream(fileName));
      result = new StringBuilder();
      result.append(in.readUTF());
    } catch (Exception e) {
      ;
    } finally {
      try {
        in.close();
      } catch (IOException e) {
        ;
      }
    }

    return (result != null) ? result.toString() : result;
  }

  @Override
  public void write(String fileName, String content) {
    ObjectOutputStream out = null;

    try {
      out = new ObjectOutputStream(new FileOutputStream(fileName));
      out.writeUTF(content);
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        ;
      }
    }

  }

}
