/**
 * <h1>Bit Operations</h1>
 * 
 * The class BitOperations offers a series of useful methods to operate with
 * numbers at bit level.
 * 
 * @author Alejandro Pérez
 * @version 0.1
 * @since 2021-10-21
 */

public class BitOperations {

  /**
   * Method to retrieve the Least Significant Bit of a given number.
   *
   * @param number to retrieve the LSB of.
   * @return The least significant bit of the given number.
   */
  public static byte LSB(short number) {
    byte lastBit;
    lastBit = (byte) (number & 1);
    return lastBit;
  }

  /**
   * Method to retrieve the Most Significant Bit of a given number.
   *
   * @param number to retrieve the MSB of.
   * @return The most significant bit of the given number.
   */
  public static byte MSB(short number) {
    byte firstBit;
    firstBit = (byte) (number >> 15 & 1);
    return firstBit;
  }

  /**
   * Method to retrieve the n of a given number.
   *
   * @param number to retrieve the bit of.
   * @param bitToSearch bit you want to retrieve.
   * @return The n of the given number.
   */
  public static byte nBit(short number, int bitToSearch) {
    byte bitFound;
    bitFound = (byte) ((number >> bitToSearch - 1) & 1);
    return bitFound;
  }
}
