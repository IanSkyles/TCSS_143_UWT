/*
* 
* Rectangle.java
* TCSS 143 – Autumn 2014
* Assignment 7
* 
*/

import java.lang.Math;
import java.text.DecimalFormat;

/**
* Rectangle class extends abstract class Shape
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/11/2014
*/

public class Rectangle extends Shape {

   /**
   * @field myLength - double
   */
   private double myLength;
   
   /**
   * @field myWidth - double
   */
   private double myWidth;
   
   /** 
   * Constructor for rectangle object
   * @param theLength - used to set length
   * @param theWidth - used to get width
   */
   public Rectangle (final double theLength, final double theWidth) {
      if((theLength <= 0) || (theWidth <= 0)) {
         throw new IllegalArgumentException("ERROR! Negative or 0" +
                        " value(s) can't be applied to a rectangle.");
      }
      myLength = theLength;   
      myWidth = theWidth;
   }
   
   /** 
   * Method: sets length of rectangle
   * @param theLength - used to set myLength
   */
   public void setLength(final double theLength) {
      myLength = theLength;
   }
   
   /** 
   * Method: sets myWidth of rectangle
   * @param theWidth - used to set myWidth
   */
   public void setWidth(final double theWidth) {
      myWidth = theWidth;
   }
   
   /**
   * Absract method - returns double of area
   * @return double area of rectangle
   */
   public double calculateArea( ) {
      return myWidth * myLength;
   }
   
   /**
   * returns a string of Rectangle width/length/area
   * @return String formatted info on fields and area
   */
   public String toString( ) {      
      DecimalFormat format = new DecimalFormat("#.00");
      return "Rectangle [Length: " + format.format(myLength) + ", " + format.format(myWidth) + "] " + "Area: " + format.format(calculateArea());
   }
}
