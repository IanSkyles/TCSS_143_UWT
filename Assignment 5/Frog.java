/*
* 
* Frog.java
* TCSS 143 – Autumn 2014
* Assignment 5
* stone class 
*/

/**
* Frog class represents the Frog that will be plaed on the map 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public class Frog extends AbstractCritter {
   /**
   @field myDirection - int - remembers current direction
   */
   private int myDirection;
   /**
   @field myCount - int - holds number of moves b4 direction changes
   */
   private int myCount;  

   /**
   * CONSTRUCTOR Frog assigns theChar to critter_character assigns values to 2 fields
   */  
   public Frog() {
      super('F');
      myDirection = EAST;
      myCount = 0;
      
   }
   /**
   * getMove
   * implements method from critter interface()
   * @param CritterInfo object
   * @return int - center
   */  
   public int getMove(CritterInfo theInfo) {
      //Random rand = new Random();
      int result = 0;
      double random = Math.random();
      //rand.nextDouble() * (1-0) + 0;
      if(myCount == 0)  {
         if(random < .25) {
            myDirection = NORTH;
         } else if (random < .5) {
            myDirection = EAST;
         } else if (random < .75) {
            myDirection = SOUTH;
         } else {
            myDirection = WEST;
         }
      }
      myCount++;
      if(myCount == 3){
         myCount = 0;
      }
      if(theInfo.getNeighbor(myDirection) == 'S') {
          result = CENTER; // If a Stone, sit still.
      }else{
          result = myDirection;
      }      
      return result;
   }
}

