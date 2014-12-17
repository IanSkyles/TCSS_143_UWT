/*
* 
* AbstractCritter.java
* TCSS 143 – Autumn 2014
* Assignment 5
* abstract class 
*/

/**
* This is an abstract class the  implements the critter interface and
* this will be extended by all critter classes            
*               
*               
* @author Ian Skyles iskyles@uw.edu
* @version 10/28/2014
*/

public abstract class AbstractCritter implements Critter {
   /**
   @field character field for representing which critter
   */
   private char critter_Character;
   
   /**
   * CONSTRUCTOR AbstractCritter assigns theChar to critter_character
   * @param final char theChar represents the critter
   */  
   public AbstractCritter(final char theChar) {
      critter_Character = theChar;
   }
   /**
   * Abstract method getChar()
   * @return char - acceses critter_Character;
   */  
   public char getChar() {
      return critter_Character;
   }
   
}