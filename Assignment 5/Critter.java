/*
* 
* Critter.java
* TCSS 143 – Autumn 2014
* Assignment 5
* Interface 
*/

/**
* This is an interface to by an abstract class that will be implemented
* by all critters (any class that is a critter)
*             
*               
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public interface Critter {
   
   /**
   @constant Final int for north
   */
   public final int NORTH = 0;
   /**
   @constant Final int for west
   */
   public final int WEST = 1;
   /**
   @constant Final int for south
   */
   public final int SOUTH = 2;
   /**
   @constant Final int for east
   */
   public final int EAST = 3;
   /**
   @constant Final int for center
   */
   public final int CENTER = 4;
   
   public char getChar();
   
   public int getMove(CritterInfo theInfo);
   
   
}