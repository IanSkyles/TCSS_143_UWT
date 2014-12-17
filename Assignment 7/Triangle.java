/*
* 
* Triangle.java
* TCSS 143 – Autumn 2014
* Assignment 7
* 
*/

import java.lang.Math;
import java.text.DecimalFormat;

/**
* Triangle class extends abstract class Shape
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/11/2014
*/

public class Triangle extends Shape {

   /**
   * @field mySideA - double
   */
   private double mySideA;
   
   /**
   * @field mySideB - double
   */
   private double mySideB;
   
   /**
   * @field mySideC - double
   */
   private double mySideC;

   
   /** 
   * Constructor for rectangle object
   * @param theLength - used to set length
   * @param theWidth - used to get width
   */
   public Triangle (final double theSideA, final double theSideB,
                                        final double theSideC) {
      if((theSideA <= 0) || (theSideB <= 0) || (theSideC <= 0)) {
         throw new IllegalArgumentException("ERROR! Negative or 0 " +
                      "value can't be applied to a circle radius.");
      }
      if(((theSideA + theSideB) < theSideC) || ((theSideA + theSideC) < theSideB)
          || ((theSideB + theSideC) < theSideA)) {
         throw new IllegalArgumentException("ERROR! Not a Triangle. Longest side too long");
      }
      mySideA = theSideA;
      mySideB = theSideB;
      mySideC = theSideC;
   }
   
   /** 
   * Method: sets length of side A
   * @param theSideA - used to set mySideA
   */
   public void setSideA(final double theSideA) {
      mySideA = theSideA;
   }
   
   /** 
   * Method: sets length of side B
   * @param theSideB - used to set mySideB
   */
   public void setSideB(final double theSideB) {
      mySideB = theSideB;
   }
   
   /** 
   * Method: sets length of side C
   * @param theSideC - used to set mySideC
   */
   public void setSideC(final double theSideC) {
      mySideC = theSideC;
   }
      
   /**
   * Absract method - returns double of area
   * @return double area of rectangle
   */
   public double calculateArea() {
      double s = .5 * (mySideA + mySideB + mySideC);
      double num = s * ((s - mySideA) * (s - mySideB) * (s - mySideC));
      return Math.sqrt(num);
   }
   
   /**
   * returns a string of Rectangle width/length/area
   * @return String formatted info on fields and area
   */
   public String toString( ) {
      DecimalFormat format = new DecimalFormat("#.00");
      return "Triangle[SideA: " + format.format(mySideA) + ", SideB: " + format.format(mySideB) + ", SideC: " +
               format.format(mySideC) + "] Area: " + format.format(calculateArea());
   }
}
