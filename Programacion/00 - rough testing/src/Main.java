public class Main {
  public static void main(String[] args) throws Exception {

    Persona p1 = new Persona();
    
    for (int i = 0; i < 20; i++) {
      System.out.println(Persona.generarDNI());
    }

  }
}
