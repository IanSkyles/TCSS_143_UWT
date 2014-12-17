/*
* 
* Wolf.java
* TCSS 143 – Autumn 2014
* Assignment 5
* stone class 
*/

/**
* Wolf class represents the wolf that will be plaed on the map 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public class Wolf extends AbstractCritter {
   /**
   @field myDirection - int - remembers current direction
   */
   private int myDirection;
   /**
   @field myCount - int - holds number of moves b4 direction changes
   */
   private int myCount;
   /**
   @field myFirst which is a boolean that holds direction change
   */
   private boolean myFirst;
   /**
   @field myTarget which is an int that holds target
   */
   private int myTarget;
   

   /**
   * CONSTRUCTOR Wolf assigns theChar to critter_character assigns values to 4 fields
   */  
   public Wolf() {
      super('W');
      myDirection = EAST;
      myCount = 0;
      myFirst = true;
      myTarget = 1;
      
   }
   /**
   * getMove
   * implements method from critter interface()
   * @param CritterInfo object
   * @return int - center
   */  
   public int getMove(CritterInfo theInfo) {
      int direction = myDirection;
      myCount++;
      if(myCount == myTarget) {
         if(myFirst == false) {
            myTarget++;
         }
         if(myFirst == false) {
            myFirst = true;
         } else if(myFirst == true) {
            myFirst = false;
         }
         myCount = 0;
         if(myDirection == NORTH) {
            myDirection = EAST;
         } else if(myDirection == EAST) {
            myDirection = SOUTH;
         } else if(myDirection == SOUTH) {
            myDirection = WEST;
         } else if(myDirection == WEST) {
            myDirection = NORTH;
         }
      }
      return direction;
   }

}