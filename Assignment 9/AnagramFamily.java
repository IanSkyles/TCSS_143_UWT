/*
* 
* AnagramFamily.java
* TCSS 143 – Autumn 2014
* Assignment 9
* 
*/

import java.util.*;

/**
* AnagramFamily is used in Programming9Driver
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/28/2014
*/
public class AnagramFamily {

   private List<Word> family;
   private int familySize;
   
   /**
   * creates an anagramfamily object
   */
   public AnagramFamily() {
      family = new LinkedList<Word>();
   }
   
   /**
   * addds word to family and increases family size counter
   * @param String theWord adds the word to family and increases family size
   */
   public void add(Word theWord) {
      family.add(theWord);
      familySize++;
   }   
   
   /**
   * getter method for familysize
   * @return int of family size 
   */
   public int getFamilySize() {
      return familySize;
   }
   
   /**
   * returns the anagram family name (checks if it has any words in family)
   * @return String cannonical word
   */
   public String getCanonical() {
      if(family.isEmpty()) {
         return "error";
      } else {
         return family.get(0).getCanonical();
      }
   }
   
   /**
   * returns a string representation of the family
   * @return String of family
   */
   public String toString() {
      return family.toString();
   }
   
}