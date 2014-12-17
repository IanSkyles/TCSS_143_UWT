/*
* 
* Stone.java
* TCSS 143 – Autumn 2014
* Assignment 5
* stone class 
*/

/**
* Stone class represents the stone that will be plaed on the map 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public class Stone extends AbstractCritter {

   /**
   * CONSTRUCTOR Stone assigns theChar to critter_character
   */  
   public Stone() {
      super('S');
   }
   /**
   * implements method from critter interface()
   * @param CritterInfo object
   * @return int - center
   */  
   public int getMove(CritterInfo theInfo) {
      return CENTER;
   }

}