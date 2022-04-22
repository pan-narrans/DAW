package SimpleCollection;

import java.util.LinkedList;

public abstract class SimpleCollection {
  protected LinkedList<Object> l = new LinkedList<Object>();

  SimpleCollection() {}

  /**
   * @return true if empty, false if not.
   */
  public boolean isEmpty() { return l.isEmpty(); }

  /** Adds a new entry to the collection. */
  public void add(Object o) { l.addLast(o); }

  /** Deletes all items of the collection. */
  public void clear() { l.clear(); }

  /**
   * Deletes the first object from the collection and deletes it.
   * 
   * @return the first element of the collection.
   */
  public abstract Object extract();

  /**
   * @return the first element of the collection.
   */
  public abstract Object getFirst();

  /**
   * @return String view of the collection.
   */
  public abstract String toString();

}
