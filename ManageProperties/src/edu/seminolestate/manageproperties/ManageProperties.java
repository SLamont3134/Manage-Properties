package edu.seminolestate.manageproperties;
/*
 * Sean Lamont
 * COP2800
 * Manage Properties
 * 3/31/19
 */
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import edu.seminolestate.properties.*;

public class ManageProperties {
  private static ArrayList<Property> propertyObjects;
  private static Scanner scanner = new Scanner(System.in);
  private static final String FILE_NAME = "property.dat";

  /**
   * This class will have the main method. Do NOT throw any exceptions from the main method of this
   * class.
   */
  public static void main(String[] args) {
    // Create an ArrayList to store Property objects.
    propertyObjects = new ArrayList<>();
    int userInput;

    /*
     * Displays a menu that has choices for: 1 - Add house; 2 - Add apartment; 3 - Delete property;
     * 4 - List all properties by value; 5 - List all properties by zip code; 6 - Exit. Display an
     * error message and repeat the menu if some other value is entered. This will require you to
     * catch the appropriate exception if letters or just the enter key instead of numbers are
     * entered. The application must continue to display the menu and process these options until
     * the user enters a 6.
     */
    System.out.println("Welcome to my Property Objects Program!");
    do {
      System.out.println("\n1 - Add House");
      System.out.println("2 - Add Apartment");
      System.out.println("3 - Delete Property");
      System.out.println("4 - List All Properties By Value");
      System.out.println("5 - List All Properties By Zip Code");
      System.out.println("6 - Exit");
      System.out.println("Enter an integer number (1-6) :");
      userInput = castToInt(scanner.nextLine());
      if (userInput >= 1 && userInput <= 6) {
        System.out.println("You Entered: " + userInput);
      }

      switch (userInput) {
        case 1:
          option1();
          break;
        case 2:
          option2();
          break;
        case 3:
          option3();
          break;
        case 4:
          option4();
          break;
        case 5:
          option5();
          break;
        case 6:
          try {
            option6();
          } catch (Exception e) {
            printStackTrace(e);
          }
          break;
        default:
          option7();
          break;
      }
    } while (userInput != 6);
  }
  /**
   * When the user chooses menu option 1, prompt for the user to enter the appropriate data for a
   * House object. Read the data using a Scanner and System.in. Implement the following edits:
   * numeric input values must be greater than zero; String input values cannot be null or have a
   * length less than one. If any one piece of input data is invalid, prompt the user to re-enter
   * that data. Continue to prompt the user until a valid value is entered. If all the data is
   * valid, create a House object and store it in the ArrayList. Catch the
   * IllegalPropertyArgumentException when calling the constructor. NOTE: Any String input value
   * must allow spaces. For example, the address must allow entry of data like "100 Main Street".
   */
  private static void option1() {
    int propertyID = checkIntParameter("Property ID");

    String address = checkStringParameter("Address");

    String city = checkStringParameter("City");

    String state = checkStringParameter("State");

    String zip = checkStringParameter("Zip Code");

    double value = checkDoubleParameter("Value");

    double squareFeet = checkDoubleParameter("Square Feet");

    double numberOfBaths = checkDoubleParameter("Number of Bathrooms");

    int numberOfBedrooms = checkIntParameter("Number of Bedrooms");

    double lotSize = checkDoubleParameter("Lot Size");

    try {
      propertyObjects.add(
          new House(
              propertyID,
              address,
              city,
              state,
              zip,
              value,
              squareFeet,
              numberOfBaths,
              numberOfBedrooms,
              lotSize));
      System.out.println("New House " + propertyID + " added to list.\n");
    } catch (IllegalPropertyArgumentException e) {
      System.out.println("Error Creating House, Please Try Again.");
    }
    scanner.nextLine();
  }

  /**
   * When the user chooses menu option 2, prompt for the user to enter the appropriate data for an
   * Apartment object. Read the data using a Scanner and System.in. Implement the following edits:
   * numeric input values must be greater than zero; String input values cannot be null or have a
   * length less than one. If any one piece of input data is invalid, prompt the user to re-enter
   * that data. Continue to prompt the user until a valid value is entered. If all the data is
   * valid, create an Apartment object and store it in the ArrayList. Catch the
   * IllegalPropertyArgumentException when calling the constructor. NOTE: Any String input value
   * must allow spaces. For example, the address must allow entry of data like "100 Main Street".
   */
  private static void option2() {

    int propertyID = checkIntParameter("Property ID");

    String address = checkStringParameter("Address");

    String city = checkStringParameter("City");

    String state = checkStringParameter("State");

    String zip = checkStringParameter("Zip Code");

    double value = checkDoubleParameter("Value");

    double squareFeet = checkDoubleParameter("Square Feet");

    double numberOfBaths = checkDoubleParameter("Number of Bathrooms");

    int numberOfBedrooms = checkIntParameter("Number of Bedrooms");

    double rent = checkDoubleParameter("Rent");

    try {
      propertyObjects.add(
          new Apartment(
              propertyID,
              address,
              city,
              state,
              zip,
              value,
              squareFeet,
              numberOfBaths,
              numberOfBedrooms,
              rent));
      System.out.println("New House " + propertyID + " added to list.\n");
    } catch (IllegalPropertyArgumentException e) {
      System.out.println("Error Creating House, Please Try Again.");
    }
    scanner.nextLine();
  }

  /**
   * When the user chooses menu option 3, prompt the user to enter a property ID. Search the
   * ArrayList to find the object with this ID. Remove this object from the ArrayList if found.
   * Display an error message if not found or if the ArrayList is empty. Be sure to test deleting
   * the last property from the array list.
   */
  private static void option3() {
    int newPropertyID;
    System.out.println("\nEnter The Property ID You Would Like To Find: ");
    newPropertyID = scanner.nextInt();
    scanner.nextLine();

    if (propertyObjects.isEmpty()) {
      System.out.println("The Property List is currently empty");
      return;
    }
    if (hasPropertyID(newPropertyID)) {
      propertyObjects.remove((findProperty(newPropertyID)));
      System.out.println("Property Deleted");
      return;
    }
    if (!(hasPropertyID(newPropertyID))) {
      System.out.println("The Property ID does not exist");
    }
  }

  /**
   * When the user chooses menu option 4, list all the objects contained in the ArrayList by calling
   * their toString method. The objects must be listed in order of their value with the lowest value
   * property listed first. Use the comparable for this.
   */
  private static void option4() {
    Collections.sort(propertyObjects);
    System.out.println("Properties ordered by Value.");
    for (Property property : propertyObjects) {
      System.out.println(property.toString());
    }
  }

  /**
   * When the user chooses menu option 5, list all the objects contained in the ArrayList by calling
   * their toString method. The objects must be listed in order of their zip code with the lowest
   * zip code property listed first. Use the comparator for this.
   */
  private static void option5() {
    // Collections.sort(propertyObjects, new PropertyZipComparator());
    System.out.println("Properties ordered by Zip Code.");
    for (Property property : propertyObjects) {
      System.out.println(property.toString());
    }
  }

  /**
   * When the user chooses menu option 6, check to see if the ArrayList has any Property objects in
   * it. If it does, write each object to a binary file (properties.dat). Make sure you write each
   * object to the file NOT the ArrayList. Then display the message "Thank you for using the
   * Property Manager" and end the application. The data must be written to a relative file location
   * using the file name properties.dat. Make this file name a class constant and use the constant
   * in your code wherever necessary. Use try with resources when writing the file. Make sure you
   * test your application with and without a properties.dat file present.
   */
  private static void option6() throws Exception {
    File objectFile = new File(FILE_NAME);
    if (propertyObjects.isEmpty() == false) {
      while (!propertyObjects.isEmpty()) {
        try (FileOutputStream foStream = new FileOutputStream(objectFile);
            ObjectOutputStream ooStream = new ObjectOutputStream(foStream); ) {
          ooStream.writeObject(propertyObjects.remove(0));
          System.out.println("ArrayList Saved To File");
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("Thank you for using the Property Manager");
  }

  private static void option7() {
    System.out.println("Please Enter A Valid Selection (1-6)");
  }

  private static String checkStringParameter(String name) {
    String string = null;
    while (string == null || string.length() <= 0) {
      System.out.println("Please Enter New " + name + ": ");
      string = scanner.nextLine();
    }
    return string;
  }

  private static int checkIntParameter(String name) {
    int tempInt = 0;
    while (tempInt <= 0) {
      System.out.println("Please Enter A Valid " + name + ": ");
      tempInt = castToInt(scanner.nextLine());
    }
    return tempInt;
  }

  private static double checkDoubleParameter(String name) {
    double tempInt = 0;
    while (tempInt <= 0) {
      System.out.println("Please Enter A Valid " + name + ": ");
      tempInt = castToDouble(scanner.nextLine());
    }
    return tempInt;
  }

  /**
   * When the application first starts check to see if the property.dat file exists. If it does,
   * read each Property object and store it in the ArrayList. If the file doesn't exist just
   * continue with an empty ArrayList. Use try with resources when reading the file.
   */
  public void importFile() throws Exception {

    propertyObjects = new ArrayList<Property>();
    try {
      File file = new File(FILE_NAME);
      if (file.exists()) {
        // while(file.) {
        try (FileInputStream fiStream = new FileInputStream(file);
            ObjectInputStream oiStream = new ObjectInputStream(fiStream); ) {
          Property newProperty = (Property) oiStream.readObject();
          propertyObjects.add(newProperty);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }

      }
      // }
      else if (!file.exists()) {
        file.createNewFile();
      }
    } catch (Exception e) {
      System.out.println("No file to import.");
    }
  }

  private static int castToInt(String string) {
    int userInput = -1;
    try {
      userInput = Integer.parseInt(string);
    } catch (Exception e) {
      System.out.println("Please Enter A valid Selection (1-6): ");
    }
    return userInput;
  }

  private static double castToDouble(String string) {
    double userInput = -1;
    try {
      userInput = Double.parseDouble(string);
    } catch (Exception e) {
      System.out.println("Please Enter A valid Selection (1-6): ");
    }
    return userInput;
  }

  private static boolean hasPropertyID(int newPropertyID) {
    for (int i = 0; i < propertyObjects.size(); i++) {
      if (propertyObjects.get(i).getPropertyID() == newPropertyID) return true;
    }
    return false;
  }

  private static Property findProperty(int propertyID) {
    for (int i = 0; i < propertyObjects.size(); i++) {
      if (propertyObjects.get(i).getPropertyID() == propertyID) return propertyObjects.get(i);
    }
    return null;
  }
}
