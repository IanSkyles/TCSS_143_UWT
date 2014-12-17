/*
* 
* Bat.java
* TCSS 143 – Autumn 2014
* Assignment 5
* stone class 
*/
import java.util.Random;
/**
* Bat class represents the bat that will be on map and move
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public class Bat extends AbstractCritter {

   /**
   * CONSTRUCTOR Bat assigns theChar to critter_character
   */  
   public Bat() {
      super('B');
   }
  /**
   * implements method from critter interface()   
   * @param CritterInfo object
   * @return int - 1/4 chance north,west,south,east
   */  
   public int getMove(CritterInfo theInfo) {
      Random rand = new Random();
      int direction = 0;
      int random = rand.nextInt(4); // 0,1,2,3
      if(random == 0) {
         direction = NORTH;
      } else if(random == 1) {
         direction = WEST;
      } else if(random == 2) {
         direction = SOUTH;
      } else if(random == 3) {      
         direction = EAST;
      }
      //if error always return north
      return direction;
   }
}
