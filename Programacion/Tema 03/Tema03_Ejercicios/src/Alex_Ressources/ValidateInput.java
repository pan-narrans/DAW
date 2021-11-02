package Alex_Ressources;

/**
 * <h1>Validate Input</h1>
 * The program ValidateInput is used to avoid a program breakup 
 * in case the user input doesn't match the espected type.
 * 
 * The class re-asks the user for a variable a set number of times
 * in case of missmatch.
 * 
 * @author Alejandro Pérez
 * @version 0.1
 * @since 2021-10-07
 */

import java.util.Scanner;
//import java.lang.Math.*;

public class ValidateInput {

  // Declare global variables
  // Escaner
  Scanner sc = new Scanner(System.in);
  int maxTries;

  /**
   * Sets the amount of max tries the user to re-enter the value has before we
   * throw the exception at them and stop the application to the default value.
   */
  public ValidateInput() {
    this.maxTries = 4;
  }

  /**
   * Sets the amount of max tries the user to re-enter the value has before we
   * throw the exception at them and stop the application.
   * 
   * @param maxTries Maximum number of tries.
   */
  public ValidateInput(int maxTries) {
    this.maxTries = maxTries;
  }

  /**
   * Destructor... sort of?
   * <p>
   * It just closes the scanner.
   * 
   */
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

  public byte inputType(byte returnValue) {
    for (int retries = 0;; retries++) {
      try {
        returnValue = sc.nextByte();
        return returnValue;
      } catch (java.util.InputMismatchException e) {
        if (retries < maxTries) {
          message(retries, "byte, maybe try a number closer to 0");
          sc.next();
        } else {
          System.out.println("  Max number of retries reached.");
          throw e;
        }
      }
    }
  } // End inputType ( byte )

  public short inputType(short returnValue) {
    for (int retries = 0;; retries++) {
      try {
        returnValue = sc.nextShort();
        return returnValue;
      } catch (java.util.InputMismatchException e) {
        if (retries < maxTries) {
          message(retries, "short, maybe try a number closer to 0");
          sc.next();
        } else {
          System.out.println("  Max number of retries reached.");
          throw e;
        }
      }
    }
  } // End inputType ( short )

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

  /**
   * Standarized message
   * 
   * @param retries number of retries taken.
   * @param message specific message to show, constructed so you only have to
   *                write the parameter type.
   */
  private void message(int retries, String message) {
    int aux = maxTries - retries;
    retries++;
    System.out.println("\t Try nº" + retries + ".");
    System.out.println("\t Invalid input, please enter a valid " + message + ".");
    System.out.println("\t You have " + aux + " tries left.");
  } // End message */

  /**
   * Asks user input and checks if the input gotten is within a certain range.
   * 
   * @param value Type of value espected.
   * @param min   Lower bound.
   * @param max   Upper bound.
   * @return User input if validation is successful.
   */
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

  public float alwaysPositive(float value) {
    return Math.abs(value);
  }

  public char inputOptions() {
    return 'a';
  }

}
