
public class HPL {

  private int[] turingStrip;
  private int turingPointer;

  private String program;
  private int instructionPointer;

  HPL() {
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public void solve() {
    turingStrip = new int[400];
    turingPointer = 0;
    instructionPointer = 0;

    while (instructionPointer < program.length()) {
      String instruction = getEmojiAt(instructionPointer);
      doIt(instruction);
      instructionPointer += 2;
    }

    System.out.println("");
  }

  public void doIt(String key) {
    // System.out.println(key);
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
    // "🤜"
    if (turingStrip[turingPointer] == 0) {
      int counter = 1;
      instructionPointer += 2;
      String instruction = getEmojiAt(instructionPointer);

      while (!instruction.equals("🤛") || counter != 0) {

        instructionPointer += 2;
        instruction = getEmojiAt(instructionPointer);

        if (instruction.equals("🤜"))
          counter++;
        if (instruction.equals("🤛"))
          counter--;

      }

      /* while (!instruction.equals("🤛")) {
      instruction = getEmojiAt(instructionPointer);
      instructionPointer += 2;
      } */

    }
  }

  private void jumpRightIfNotZero() {
    // "🤛"
    if (turingStrip[turingPointer] != 0) {
      int counter = 1;
      instructionPointer -= 2;
      String instruction = getEmojiAt(instructionPointer);

      while (!instruction.equals("🤜") || counter != 0) {

        instructionPointer -= 2;
        instruction = getEmojiAt(instructionPointer);

        if (instruction.equals("🤛"))
          counter++;
        if (instruction.equals("🤜"))
          counter--;
      }

      // instructionPointer += 2;
      /* while (!instruction.equals("🤜")) {
      instruction = getEmojiAt(instructionPointer);
      instructionPointer -= 2;
      } */
    }
  }

  private String getEmojiAt(int index) {
    return new StringBuilder().appendCodePoint(program.codePointAt(index)).toString();
  }

  private void showChar() {
    System.out.print((char) turingStrip[turingPointer]);
  }

  private void decrementMemory() {
    int value = turingStrip[turingPointer];
    turingStrip[turingPointer] = (value != 0) ? value - 1 : 255;
  }

  private void incrementMemory() {
    int value = turingStrip[turingPointer];
    turingStrip[turingPointer] = (value != 255) ? value + 1 : 0;
  }

  private void movePointerLeft() {
    turingPointer = (turingPointer == 0) ? 0 : turingPointer - 1;
  }

  private void movePointerRight() {
    turingPointer++;
  }

}
