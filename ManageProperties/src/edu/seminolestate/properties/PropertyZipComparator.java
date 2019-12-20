package edu.seminolestate.properties;
/*
 * Sean Lamont
 * COP2800
 * Manage Properties
 * 3/31/19
 */
import java.lang.Comparable;

public class PropertyZipComparator implements Comparable<Property> {
  @Override
  public int compareTo(Property object1) {
    int value = 0;
    try {
      value = Integer.parseInt(object1.getZip());
    } catch (Exception e) {
    }
    return value;
  }
}
