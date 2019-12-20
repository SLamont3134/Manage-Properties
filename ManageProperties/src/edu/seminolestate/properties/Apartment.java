package edu.seminolestate.properties;
/*
 * Sean Lamont
 * COP2800
 * Manage Properties
 * 3/31/19
 */
import java.io.Serializable;

public class Apartment extends Property implements Serializable {
  private static final long serialVersionUID = 1L;

  // Implement the class variable(s) shown in the UML class diagram.
  private double unitRent;

  /**
   * Implement the constructor shown in the UML class diagram. Call the set methods to update the
   * class variables.
   */
  public Apartment(
      int newPropertyID,
      String newAddress,
      String newCity,
      String newState,
      String newZip,
      double newValue,
      double newSquareFeet,
      double newNumberOfBaths,
      int newNumberOfBedrooms,
      double newUnitRent)
      throws IllegalPropertyArgumentException {
    super(
        newPropertyID,
        newAddress,
        newCity,
        newState,
        newZip,
        newValue,
        newSquareFeet,
        newNumberOfBaths,
        newNumberOfBedrooms);
    setUnitRent(newUnitRent);
  }

  /**
   * Implement the get and set methods shown in the UML class diagram. The set methods must have the
   * following edits: numeric parameter values must be greater than zero; String parameters values
   * cannot be null or have a length less than one. Throw the IllegalPropertyArgumentException
   * exception if a parameter is invalid. Instantiate the IllegalPropertyArgumentException with a
   * descriptive error message.
   */
  public double getUnitRent() {
    return unitRent;
  }

  public void setUnitRent(double unitRent) throws IllegalPropertyArgumentException {
    if (unitRent > 0) {
      this.unitRent = unitRent;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Unit Rent Price " + unitRent + " Must be a number greater than 0.");
  }

  @Override
  public int compareTo(Property o) {
    // TODO Auto-generated method stub
    return 0;
  }
  /**
   * Override the toString method. Call the superclass toString method and then add the values for
   * the Apartment class.
   */
  @Override
  public String toString() {
    return super.toString() + " Unit Rent " + unitRent;
  }
}
