import java.util.HashMap;

public class Recipe {
  private String name;
  HashMap<Ingredients, Integer> ingredients = new HashMap<>();

  public Recipe(String name, Ingredients[] ingredient, int[] quantity) {
    addIngredient(name, ingredient, quantity);
  }

  public String getNombre() {
    return name;
  }

  public void addIngredient(String name, Ingredients[] ingredient, int[] quantity) {
    this.name = name;
    for (int i = 0; i < ingredient.length; i++) {
      this.ingredients.put(ingredient[i], quantity[i]);
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(" " + name + ":\n");
    sb.append("=========================\n");

    ingredients.forEach((key, value) -> sb.append(
        String.format(" - %-20s: %-4d .uds\n",
            key.toString().replace("_", " ").toLowerCase(),
            value)));

    // ingredients.forEach(
    // (key, value) -> sb.append(key + " : " + Integer.toString(value) + "\n"));

    return sb.toString();

  }

  public HashMap<Ingredients, Integer> getIngredientes() {
    return ingredients;
  }

}
