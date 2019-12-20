package edu.seminolestate.properties;

/**
 * Implement the Comparator interface for Property objects. Override the compare method. Use the zip
 * code field to compare Property objects.
 */
public class IllegalPropertyArgumentException extends Exception {

  private static final long serialVersionUID = 8089604985623130814L;

  public IllegalPropertyArgumentException() {
    super("Invalid argument for the Stock class method");
  }

  public IllegalPropertyArgumentException(String message) {
    super(message);
  }
}
