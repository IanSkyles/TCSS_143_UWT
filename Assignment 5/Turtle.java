/*
* 
* Turtle.java
* TCSS 143 – Autumn 2014
* Assignment 5
* stone class 
*/
import java.util.Random;
/**
* Turtle class represents the Turtle that will be placed on the map 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public class Turtle extends AbstractCritter {
   /**
   @field myTarget which is an int that holds total moves
   */
   private int myTotalMoves;
   /**
   @field myDirection which is an int that holds direction for move
   */
   private int myDirection;
   
   

   /**
   * CONSTRUCTOR Turtle assigns theChar to critter_character assigns values to 4 fields
   */  
   public Turtle() {
      super('T');
      myTotalMoves = 0;
      myDirection = NORTH;
      
   }
   /**
   * getMove
   * implements method from critter interface()
   * @param CritterInfo object
   * @return int - center
   */  
   public int getMove(CritterInfo theInfo) {
      Random rand = new Random();
      boolean random_2 = false;
      int random_1 = 0;
      int randomKeeper_2 = rand.nextInt(2) + 1; // 1,2
      int randomKeeper_1 = rand.nextInt(4); // 0,1,2,3
      myTotalMoves++;
      if((myTotalMoves % 3) == 0) {
         //determines random boolean
         if(randomKeeper_2 == 1) {
            random_2 = false;
         }else {
            random_2 = true;
         }
         //determines random direction
         if(random_2 = false) {      
            if(random_1 == 0) {
               myDirection = NORTH;
            }else if(random_1 == 1) {
               myDirection = EAST;
            }else if(random_1 == 2) {
               myDirection = SOUTH;
            }else if(random_1 == 3) {
               myDirection = WEST;
            }
         }else {
            if(random_1 == 0) {
               myDirection = SOUTH;
            }else if(random_1 == 1) {
               myDirection = WEST;
            }else if(random_1 == 2) {
               myDirection = NORTH;
            }else if(random_1 == 3) {
               myDirection = EAST;
            }
         }
      }else { //not a multiple of 3
         myDirection = CENTER;
      }
      return myDirection;
   }
}