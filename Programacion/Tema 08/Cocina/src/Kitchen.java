import java.util.HashMap;
import java.util.Map.Entry;

public class Kitchen {
  HashMap<Ingredients, Integer> ingredients = new HashMap<>();
  HashMap<String, Recipe> recipes = new HashMap<>();

  public void addIngredient(Ingredients ingredient, int quantity) {
    Ingredients key = ingredient;
    int value = quantity;

    if (ingredients.get(key) != null)
      value += ingredients.get(key);

    ingredients.put(key, value);
  }

  public void addRecipe(Recipe r) {
    recipes.put(r.getNombre(), r);
  }

  public String ingredientsToString() {
    StringBuilder sb = new StringBuilder();

    sb.append("=========================\n");
    sb.append(" Ingredients disponibles:\n");
    sb.append("=========================\n");

    ingredients.forEach((key, value) -> sb.append(
        String.format(" - %-20s: %-4d .uds\n",
            key.toString().replace("_", " ").toLowerCase(),
            value)));

    // ingredients.forEach(
    // (key, value) -> sb.append(key + " : " + Integer.toString(value) + "\n"));

    return sb.toString();
  }

  public String recipesToString() {
    StringBuilder sb = new StringBuilder();

    sb.append("=========================\n");
    sb.append(" Recetas disponibles:\n");
    sb.append("=========================\n");

    recipes.forEach((key, value) -> sb.append("\n" + value.toString()));

    // ingredients.forEach(
    // (key, value) -> sb.append(key + " : " + Integer.toString(value) + "\n"));

    return sb.toString();
  }

  public void makeRecipe(String name) throws NoHaySuficientesIngredientes {
    Recipe r = recipes.get(name);

    // Check if all ingredients are available:
    for (Entry<Ingredients, Integer> ingrediente : r.getIngredientes().entrySet()) {
      int cantidadRestante = ingredients.get(ingrediente.getKey()) - ingrediente.getValue();
      if (cantidadRestante < 0)
        throw new NoHaySuficientesIngredientes(ingrediente.getKey());
    }

    // Update quantities:
    for (Entry<Ingredients, Integer> ingrediente : r.getIngredientes().entrySet()) {
      addIngredient(ingrediente.getKey(), -ingrediente.getValue());
    }

    //
    System.out.println("Receta: " + name + "\n\tCorrectamente cocinada.");
  }
}
