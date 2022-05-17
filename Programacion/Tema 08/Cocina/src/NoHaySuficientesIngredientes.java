
public class NoHaySuficientesIngredientes extends Exception {
  NoHaySuficientesIngredientes() {
    super("No hay suficientes unidades del ingrediente");
  }

  public NoHaySuficientesIngredientes(Ingredients key) {
    super("No hay suficientes unidades del ingrediente: " + key);
  }
}
