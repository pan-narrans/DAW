import java.util.ArrayList;
import java.util.List;

public class Cell {
  List<Integer> possibilitySpace;
  int entropy;
  int id;
  int value = 0;

  public Cell() {
    possibilitySpace = new ArrayList<Integer>() {
      {
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
      }
    };
    entropy = possibilitySpace.size();
  }

  public void debugValues() {
    System.out.println("Possibility Space = " + possibilitySpace.toString());
    System.out.println("Entropy = " + entropy);
    System.out.println("id = " + id);
    System.out.println("Value = " + value);
  }

  public void updateEntropy() {
    entropy = possibilitySpace.size();
  }

  public void setID(int a, int b) {
    id = a * 10 + b;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
