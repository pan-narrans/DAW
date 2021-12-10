public class Game {
  public static void main(String[] args) throws Exception {
    Sudoku sudoku = new Sudoku();

    sudoku.createSudoku();
    sudoku.printSudoku();
  }

}
