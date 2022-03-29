
public class hlpOld {

  private int[] turing;
  private int pointer;

  private String program;
  // private LinkedList<String> programCommands;
  private int[] instructions;
  private int index;

  hlpOld() {
    turing = new int[100];
    pointer = 0;
    index = 0;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public void solve() {
    // int[] programCommandsInt = program.codePoints().toArray();
    // for (int i : programCommandsInt) {
    // programCommands.add(new StringBuilder()
    // .appendCodePoint(i)
    // .toString());
    // }

    // System.out.println(Arrays.toString(programCommandsInt));

    // System.out.println(program);
    // System.out.println(programCommandsInt[0]);
    // System.out.println(new
    // StringBuilder().appendCodePoint(programCommandsInt[0]).toString());

    // this.programCommands = Arrays
    // .asList(programCommands)
    // .stream()
    // .map(item -> new StringBuilder()
    // .appendCodePoint(item)
    // .toString())
    // .toArray();

    // programCommands = Arrays.stream(program.split(""))
    // .map(item -> new
    // StringBuilder().appendCodePoint(programCommandsInt[0]).toString())
    // .toArray(String[]::new);

    // programCommands = program
    // .codePoints()
    // .collect(StringBuilder::new,
    // StringBuilder::appendCodePoint,
    // StringBuilder::append)
    // ;

    // programCommands = ;

    // System.out.println(Arrays.toString(programCommands));

    // System.out.println(program
    // .codePoints()
    // .collect(StringBuilder::new,
    // StringBuilder::appendCodePoint,
    // StringBuilder::append)
    // .toString());

    // while (instruction < program.length()) {
    // doIt(programCommands[instruction]);
    // instruction++;
    // }
    System.out.println("we started");

    turing = new int[100];
    instructions = program.codePoints().toArray();
    index = 0;

    while (index < program.length()) {
      String instruction = new StringBuilder().appendCodePoint(program.codePointAt(index)).toString();
      doIt(instruction);
      index += 2;
    }

    /*
     * for (int i = 0; i < instructions.length; i++) {
     * System.out.println(new StringBuilder().appendCodePoint(program.codePointAt(i
     * 2)).toString());
     * }
     */

    System.out.println("");
    System.out.println("we ended");
  }

  public void doIt(String key) {
    switch (key) {
      case "👉":
        movePointerRight();
        break;
      case "👈":
        movePointerLeft();
        break;
      case "👆":
        incrementMemory();
        break;
      case "👇":
        decrementMemory();
        break;
      case "🤜":
        jumpLeftIfZero();
        break;
      case "🤛":
        jumpRightIfNotZero();
        break;
      case "👊":
        showChar();
        break;
      default:
        break;
    }
  }

  private void jumpLeftIfZero() {
    if (turing[pointer] == 0) {
      String tempString = new StringBuilder().appendCodePoint(program.codePointAt(index * 2)).toString();
      while (tempString != "🤛") {
        index += 2;
        movePointerRight();
      }
      movePointerRight();
    }
  }

  private void jumpRightIfNotZero() {
    if (turing[pointer] != 0) {
      String tempString = new StringBuilder().appendCodePoint(program.codePointAt(index * 2)).toString();
      while (tempString != "🤜") {
        index -= 2;
        movePointerLeft();
      }
      movePointerLeft();
    }
  }

  private void showChar() {
    System.out.print((char) turing[pointer]);
  }

  private void decrementMemory() {
    int value = turing[pointer];
    turing[pointer] = (value != 0) ? value - 1 : 255;
  }

  private void incrementMemory() {
    int value = turing[pointer];
    turing[pointer] = (value != 255) ? value + 1 : 0;
  }

  private void movePointerLeft() {
    pointer = (pointer == 0) ? 0 : pointer - 1;
  }

  private void movePointerRight() {
    pointer++;
  }

}
