package edu.seminolestate.properties;
/*
 * Sean Lamont
 * COP2800
 * Manage Properties
 * 3/31/19
 */
import java.io.Serializable;

public class House extends Property implements Serializable {
  // Implement the class variable(s) shown in the UML class diagram
  private static final long serialVersionUID = 1L;
  private double lotSize;

  /**
   * Implement the constructor shown in the UML class diagram. Call the set methods to update the
   * class variables.
   */
  public House(
      int newPropertyID,
      String newAddress,
      String newCity,
      String newState,
      String newZip,
      double newValue,
      double newSquareFeet,
      double newNumberOfBaths,
      int newNumberOfBedrooms,
      double newLotSize)
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
    setLotSize(newLotSize);
  }

  /**
   * Implement the get and set methods shown in the UML class diagram. The set methods must have the
   * following edits: numeric parameter values must be greater than zero; String parameters values
   * cannot be null or have a length less than one. Throw the IllegalPropertyArgumentException
   * exception if a parameter is invalid. Instantiate the IllegalPropertyArgumentException with a
   * descriptive error message.
   */
  public double getLotSize() {
    return lotSize;
  }

  public void setLotSize(double lotSize) throws IllegalPropertyArgumentException {
    if (lotSize > 0) {
      this.lotSize = lotSize;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Lot Size " + lotSize + " Must be a number greater than 0.");
  }

  @Override
  public int compareTo(Property o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String toString() {
    return super.toString() + " Lot Size: " + lotSize;
  }
}
