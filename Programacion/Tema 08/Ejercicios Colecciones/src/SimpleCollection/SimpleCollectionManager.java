package SimpleCollection;

public class SimpleCollectionManager {

  /**
   * Fills the collection with numbers from 0 to 10.
   * 
   * @param collection collection to fill
   */
  public void fill(SimpleCollection collection) {
    for (int i = 0; i < 11; i++) {
      collection.add(i);
    }
  }

  /**
   * Prints and deletes the content of the collection.
   * 
   * @param collection collection to print
   */
  public void printAndEmpty(SimpleCollection collection) {
    System.out.println(collection);
    collection.clear();
  }

}
