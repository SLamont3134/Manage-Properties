package edu.seminolestate.properties;

/*
 * Sean Lamont
 * COP2800
 * Manage Properties
 * 3/31/19
 */
import java.io.Serializable;
// Make the Property class abstract.

public abstract class Property implements Serializable, Comparable<Property> {
  // Implement the class variables shown in the UML class diagram.
  private static final long serialVersionUID = 1L;
  private int propertyID;
  private String address;
  private String city;
  private String state;
  private String zip;
  private double value;
  private double squareFeet;
  private double numberOfBaths;
  private int numberOfBedrooms;

  /*
   * Implement the constructor shown in the UML class diagram.
   * Call the set methods to update the class variables.
   */
  public Property(
      int newPropertyID,
      String newAddress,
      String newCity,
      String newState,
      String newZip,
      double newValue,
      double newSquareFeet,
      double newNumberOfBaths,
      int newNumberOfBedrooms)
      throws IllegalPropertyArgumentException {
    this.setPropertyID(newPropertyID);
    this.setAddress(newAddress);
    this.setCity(newCity);
    this.setState(newState);
    this.setZip(newZip);
    this.setValue(newValue);
    this.setSquareFeet(newSquareFeet);
    this.setNumberOfBaths(newNumberOfBaths);
    this.setNumberOfBedrooms(newNumberOfBedrooms);
  }

  public int getPropertyID() {
    return propertyID;
  }

  public void setPropertyID(int propertyID) throws IllegalPropertyArgumentException {
    if (propertyID > 0) {
      this.propertyID = propertyID;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Property ID " + propertyID + " Must be a number greater than 0.");
  }

  /*
   * Implement the get and set methods shown in the UML class diagram. The set methods must have the following edits: numeric
   *  parameter values must be greater than zero; String parameters values cannot be null or have a length less than one. Throw the
   *  IllegalPropertyArgumentException exception if a parameter is invalid. Instantiate the IllegalPropertyArgumentException with a
   *   descriptive error message.
   */

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) throws IllegalPropertyArgumentException {
    if (address != null && address.length() > 0) {
      this.address = address;
    } else
      throw new IllegalPropertyArgumentException(
          "Invalid Address " + address + " Must be atleast one character.");
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) throws IllegalPropertyArgumentException {
    if (city != null && city.length() > 0) {
      this.city = city;
    } else
      throw new IllegalPropertyArgumentException(
          "Invalid City " + city + " Must be atleast one character.");
  }

  public String getState() {
    return state;
  }

  public void setState(String state) throws IllegalPropertyArgumentException {
    if (state != null && state.length() > 0) {
      this.state = state;
    } else
      throw new IllegalPropertyArgumentException(
          "Invalid State " + state + " Must be atleast one character.");
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) throws IllegalPropertyArgumentException {
    if (zip != null && zip.length() > 0) {
      this.zip = zip;
    } else
      throw new IllegalPropertyArgumentException(
          "Invalid Zip Code " + zip + " Must be atleast one character.");
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) throws IllegalPropertyArgumentException {
    if (value > 0) {
      this.value = value;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Value " + value + " Must be a number greater than 0.");
  }

  public double getSquareFeet() {
    return squareFeet;
  }

  public void setSquareFeet(double squareFeet) throws IllegalPropertyArgumentException {
    if (squareFeet > 0) {
      this.squareFeet = squareFeet;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Square Feet " + squareFeet + " Must be a number greater than 0.");
  }

  public double getNumberOfBaths() {
    return numberOfBaths;
  }

  public void setNumberOfBaths(double numberOfBaths) throws IllegalPropertyArgumentException {
    if (numberOfBaths > 0) {
      this.numberOfBaths = numberOfBaths;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Number Of Bathrooms " + numberOfBaths + " Must be a number greater than 0.");
  }

  public int getNumberOfBedrooms() {
    return numberOfBedrooms;
  }

  public void setNumberOfBedrooms(int numberOfBedrooms) throws IllegalPropertyArgumentException {
    if (numberOfBedrooms > 0) {
      this.numberOfBedrooms = numberOfBedrooms;
    } else
      throw new IllegalPropertyArgumentException(
          "Illegal Number Of Bedrooms " + numberOfBedrooms + " Must be a number greater than 0.");
  }
  // Override the compareTo method. Use the value for the comparison
  @Override
  public int compareTo(Property objectToCompare) {
    return (int) (this.value - objectToCompare.value);
  }
  // Override the toString method
  @Override
  public String toString() {
    return "Property ID: "
        + propertyID
        + " Address: "
        + address
        + " City: "
        + city
        + " State: "
        + state
        + " Zip Code: "
        + zip
        + " Value: "
        + value
        + " Square Feet "
        + squareFeet
        + " Number Of Bathrooms "
        + numberOfBaths
        + " Number Of Bedrooms "
        + numberOfBedrooms;
  }
}
