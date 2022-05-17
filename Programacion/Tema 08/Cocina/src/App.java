public class App {
  public static void main(String[] args) throws Exception {
    Kitchen c = new Kitchen();
    Recipe r = null;

    c.addIngredient(Ingredients.HUEVOS, 12);
    c.addIngredient(Ingredients.HUEVOS, 12);
    c.addIngredient(Ingredients.LECHE, 1);
    c.addIngredient(Ingredients.SOLOMILLO, 4);
    c.addIngredient(Ingredients.PIMIENTO_ITALIANO, 6);
    c.addIngredient(Ingredients.CHORIZO, 20);

    r = new Recipe(
        "Huevos con chorizo",
        new Ingredients[] { Ingredients.HUEVOS, Ingredients.CHORIZO },
        new int[] { 2, 3 });
    c.addRecipe(r);

    r = new Recipe(
        "Guisantes con jamón",
        new Ingredients[] { Ingredients.GUISANTES, Ingredients.JAMÓN },
        new int[] { 500, 250 });
    c.addRecipe(r);

    System.out.println(c.ingredientsToString());
    // System.out.println(c.recipesToString());

    try {
      c.makeRecipe("Huevos con chorizo");
      c.makeRecipe("Guisantes con jamón");
    } catch (NoHaySuficientesIngredientes e) {
      System.out.println(e);
    } catch (NullPointerException e) {
      System.out.println("Nos falta alguno de los ingredientes.");
    }

    System.out.println(c.ingredientsToString());
  }
}
