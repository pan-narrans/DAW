package ArrayLists;

import java.util.ArrayList;

public class MainArrList {
  public static void main(String[] args) {

    ArrayList<String> cadenas = new ArrayList<>();

    cadenas.add("marta");
    cadenas.add("marta");
    cadenas.add("marta");
    cadenas.add("pablo");
    cadenas.add("pablo");
    cadenas.add("pablo");
    cadenas.add("cris");
    cadenas.add("cris");
    cadenas.add("cris");
    cadenas.add("alex");
    cadenas.add("alex");
    cadenas.add("alex");
    cadenas.add("alex");
    cadenas.add("alex");

    System.out.println(cadenas.toString());
    elminarTodos(cadenas, "alex");
    System.out.println(cadenas.toString());

  }

  public static void elminarTodos(ArrayList<String> cadenas, String target) {
    for (int i = 0; i < cadenas.size(); i++) {
      if (cadenas.get(i).equals(target))
        cadenas.remove(i--);
    }
  }

}
