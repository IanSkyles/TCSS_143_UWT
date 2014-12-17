/*
* 
* Circle.java
* TCSS 143 – Autumn 2014
* Assignment 7
* 
*/

import java.lang.Math; 
import java.text.DecimalFormat;

/**
* Circle class extends abstract class Shape
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/11/2014
*/

public class Circle extends Shape {

   /**
   * @field myRadius - double
   */
   private double myRadius;
   
   /** 
   * Constructor for circle
   * @param theRadius - used to set myRadius
   */
   public Circle(final double theRadius) {
      if(theRadius <= 0) {
         throw new IllegalArgumentException("ERROR! Negative or 0 " +
                        "value can't be applied to a circle radius.");
      }
      myRadius = theRadius;   
   }
   
   /** 
   * Method: sets radius of circle
   * @param theRadius - used to set myRadius
   */
   public void setRadius(final double theRadius) {
      myRadius = theRadius;   
   }
   
   /**
   * Absract method - returns double of area
   * @return double area of shape
   */
   @Override
   public double calculateArea() {
      //return myRadius * myRadius * Math.PI;
      return ((double) Math.round((myRadius * myRadius * Math.PI) * 100) / 100);      
   }
   
   /**
   * returns a string of circles radius and area
   * @return String formatted info on fields and area
   */
   public String toString() {
      DecimalFormat format = new DecimalFormat("#.00");
      return "Circle [Radius: " + format.format(myRadius) + "] Area: " + format.format(calculateArea());
      
   }


}