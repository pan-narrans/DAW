package SimpleCollection;

public class Pila extends SimpleCollection {

  @Override
  public Object extract() {
    Object temp = getFirst();
    l.removeLast();
    return temp;
  }

  @Override
  public Object getFirst() { return l.getLast(); }

  @Override
  public String toString() {
    StringBuilder collection = new StringBuilder();

    for (int i = l.size() - 1; i > -1; i--) {
      collection.append(l.get(i).toString() + "\n");
    }

    return collection.toString();
  }

}
