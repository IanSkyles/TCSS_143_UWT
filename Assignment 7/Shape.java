/*
* 
* Shape.java
* TCSS 143 – Autumn 2014
* Assignment 7
* 
*/

//import java.util.ArrayList;

/**
* Abstract shape class
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/11/2014
*/

public abstract class Shape implements Comparable<Shape> {

   /**
   * @method Absract method - returns double of area
   * @return double area of shape
   */
   public abstract double calculateArea();
   
      /**
   * @method method - compares shape
   * @return double area of shape
   */
   public int compareTo(final Shape theOther) {  
      int value = 0;
      double difference = calculateArea() - theOther.calculateArea();
      if (difference < 0){
         value = -1;
      } else if (difference == 0) {
         value = 0;
      } else { // difference > 0
         value = 1;
      }
      return value;
   }


}



