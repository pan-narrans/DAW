
/**
 * <h1>Validate Input</h1>
 * The program ValidateInput is used to avoid a program breakup 
 * in case the user input doesn't match the espected type.
 * 
 * The program re-asks the user for a variable a set number of times
 * in case of missmatch.
 * 
 * @author Alejandro Pérez
 * @version 0.1
 * @since 2021-10-07
 */

import java.util.Scanner;

public class ValidateInput {

  // Declare global variables
  // Escaner
  Scanner sc = new Scanner(System.in);
  int maxTries;

  /**
   * <h2>Constructor</h2> Sets the amount of max tries or leaves it at the
   * default.
   * 
   * @param maxTries Maximum number of tries the user has before throwing the
   *                 exception at them.
   */
  public ValidateInput() {
    this.maxTries = 4;
  }

  public ValidateInput(int maxTries) {
    this.maxTries = maxTries;
  }

  // Destructor... sort of?
  public void close() {
    sc.close();
  }

  public float inputType(float returnValue) {
    for (int retries = 0;; retries++) {
      try {
        returnValue = sc.nextFloat();
        return returnValue;
      } catch (java.util.InputMismatchException e) {
        if (retries < maxTries) {
          message(retries, "float, use ',' instead of '.' for correct notation");
          sc.next();
        } else {
          System.out.println("  Max number of retries reached.");
          throw e;
        }
      }
    }
  } // End inputType ( float )

  public int inputType(int returnValue) {
    for (int retries = 0;; retries++) {
      try {
        returnValue = sc.nextInt();
        // lee el \n que se introduce para validar la introducción del int y deja el
        // scanner libre para poder leer una string
        sc.nextLine();
        return returnValue;
      } catch (java.util.InputMismatchException e) {
        if (retries < maxTries) {
          message(retries, "integer");
          sc.next();
        } else {
          System.out.println("  Max number of retries reached.");
          throw e;
        }
      }
    }
  } // End inputType ( int )

  public String inputType(String returnValue) {
    returnValue = sc.nextLine();
    return returnValue;
  } // End inputType ( String )

  public char inputType(char returnValue) {
    for (int retries = 0;; retries++) {
      try {
        returnValue = sc.next().charAt(0);
        return returnValue;
      } catch (java.util.InputMismatchException e) {
        if (retries < maxTries) {
          message(retries, "char");
          sc.next();
        } else {
          System.out.println("  Max number of retries reached.");
          throw e;
        }
      }
    }
  } // End inputType ( char )

  public boolean inputType(boolean returnValue) {
    for (int retries = 0;; retries++) {
      try {
        returnValue = sc.nextBoolean();
        return returnValue;
      } catch (java.util.InputMismatchException e) {
        if (retries < maxTries) {
          message(retries, "boolean");
          sc.next();
        } else {
          System.out.println("  Max number of retries reached.");
          throw e;
        }
      }
    }
  }

  private void message(int retries, String message) {
    int aux = maxTries - retries;
    retries++;
    System.out.println("\t Try nº" + retries + ".");
    System.out.println("\t Invalid input, please enter a valid " + message + ".");
    System.out.println("\t You have " + aux + " tries left.");
  } // End message */

  public int inputRange(int value, int min, int max) {
    System.out.println("Introduce un nº entre el " + min + " y el " + max + ":");
    value = inputType(1);

    while (min > value || value > max) {
      System.out.println("El nº escogido no es válido, introduce otro por favor.");
      System.out.println("Recuerda escoger un nº entre el " + min + " y el " + max + ":");
      value = inputType(1);
    }

    return value;
  }

  public char inputOptions() {
    return 'a';
  }

}
