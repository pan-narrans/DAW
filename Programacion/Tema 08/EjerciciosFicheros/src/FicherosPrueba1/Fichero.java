package FicherosPrueba1;

public interface Fichero {
  public Object read(String fileName);
  public void write(String fileName, String content);
}
