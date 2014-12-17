/*
* 
* Mouse.java
* TCSS 143 – Autumn 2014
* Assignment 5
* stone class 
*/
import java.util.Random;
/**
* Mouse class represents the mouse that will be plaed on the map 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public class Mouse extends AbstractCritter {
   /**
   @field myDirection - int - remembers current direction
   */
   private int myDirection;
   /**
   @field myCount - int - holds number of moves b4 direction changes
   */
   private int myCount;
   /**
   @field myLastDirection - int - holds number of moves b4 direction changes  
   */
   private int myZigDirection;
   /**
   @field myTarget which is an int that holds target
   */
   private int myTarget;
   

   /**
   * CONSTRUCTOR Wolf assigns theChar to critter_character assigns values to 4 fields
   */  
   public Mouse() {
      super('M');
      myDirection = EAST;
      myCount = 0;
      myZigDirection = 1; // 1 = n/e 2 = n/w 3 = s/w 4 = s/e
      myTarget = 1;
      
   }
   /**
   * getMove
   * implements method from critter interface()
   * @param CritterInfo object
   * @return int - center
   */  
   public int getMove(CritterInfo theInfo) {     
      Random rand = new Random();
      int randomDirection = rand.nextInt(4);
      int randomCount = rand.nextInt(6) + 1; // 1,2,3,4,5,6     
                                             //random number of steps in zig      
      myCount++;
      if(myCount == myTarget) { // CHANGE DIRECTION IF WE HIT THE TARGET
         myZigDirection = randomDirection;   // assigns random zig direction                          
         myTarget = randomCount; // changes number of steps in direction 
      }
      //IF OUR LAST DIRECTION WAS XX WE GO ZIG ZAG
          if(myZigDirection == 0) {
            if((myCount % 2) == 0) {
               myDirection = EAST;
            }else {
               myDirection = NORTH;
            }
          } else if(myZigDirection == EAST) {
               if((myCount % 2) == 0) {
               myDirection = WEST;
               }else {
               myDirection = NORTH;
               }
          } else if(myZigDirection == 2) {            
               if((myCount % 2) == 0) {
                  myDirection = WEST;
               }else {
                  myDirection = SOUTH;
               }
          } else if(myZigDirection == 3) {
               if((myCount % 2) == 0) {
                  myDirection = EAST;
               }else {
                  myDirection = SOUTH;
               }
          }
      
      
      return myDirection;
   }

}