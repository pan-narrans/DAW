package SimpleCollection;

public class Cola extends SimpleCollection {

  @Override
  public Object extract() {
    Object temp = getFirst();
    l.removeFirst();
    return temp;
  }

  @Override
  public Object getFirst() { return l.getFirst(); }

  @Override
  public String toString() {
    StringBuilder collection = new StringBuilder();

    for (Object o : l) {
      collection.append(o.toString() + "\n");
    }

    return collection.toString();
  }
}
