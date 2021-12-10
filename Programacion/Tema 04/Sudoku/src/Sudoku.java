
public class Sudoku {
  Cell[][] sudoku;

  public void createSudoku() {
    sudoku = new Cell[9][9];
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        sudoku[i][j] = new Cell();
        sudoku[i][j].setID(i, j);
      }
    }
  }

  public void printSudoku() {
    System.out.println("+-----------------------+");

    for (int i = 0; i < sudoku.length; i++) {
      System.out.print("| ");

      // Divides columns and prints values
      for (int j = 0; j < sudoku.length; j++) {
        System.out.print(sudoku[i][j].value + " ");
        if ((j + 1) % 3 == 0)
          System.out.print("| ");
      }

      // Divides rows
      System.out.println("");
      if ((i + 1) % 3 == 0)
        System.out.println("+-----------------------+");
    }
  }

}
