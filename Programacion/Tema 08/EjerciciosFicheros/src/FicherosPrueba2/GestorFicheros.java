package FicherosPrueba2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class GestorFicheros {

  public boolean crearDirectorio(String path, String name) {
    return (new File(path + File.separator + name)).mkdir();
  }

  public boolean borrarDirectorio(String path, String name) {
    try {
      Stream<Path> files = Files.walk(Paths.get(path + File.separator + name));

      files.sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          .forEach(File::deleteOnExit);

      files.close();
    } catch (IOException e) {
      return false;
    }
    return true;
  }

  public boolean crearFichero() {
    return false;
  }

  public boolean borrarFichero() {
    return false;
  }

  public boolean moverFichero() {
    return false;
  }

  public boolean renombrarFichero() {
    return false;
  }
}
