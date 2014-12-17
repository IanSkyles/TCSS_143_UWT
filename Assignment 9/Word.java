/*
* 
* Word.java
* TCSS 143 – Autumn 2014
* Assignment 9
* 
*/

import java.util.*;

/**
* Word is used in Programming9Driver
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/28/2014
*/

public class Word implements Comparable<Word> {
   private String normal;
   private String canonical;
   /**
   * creates a word object
   * @param String - theWord - used to store in field
   */
   public Word(final String theWord) {
      normal = theWord;
      canonical = convertToCanonical(normal);
   }
   
   /**
   * returns a cannonical string of the original string passed
   * @param String theWord
   * @return String canonical version of theWord
   */
   public String convertToCanonical(String theWord) {
      char[] chars = theWord.toCharArray();
      Arrays.sort(chars);
      String newWord = new String(chars);
      return newWord;
   }
   
   /**
   * Getter method for canonical- returns canonical string
   * @return String 
   */
   public String getCanonical(){
      return canonical;
   }
   
   //override
   /**
   * returns an int based on cannonical comparison
   * @param Word - Other 
   * @return int 
   */
   public int compareTo(Word other) {     
     return (other.getCanonical()).compareTo(canonical);
     
   }
   
   //override
   /**
   * returns a string of normal
   * @return String 
   */
   public String toString() {
      return normal;
   }
   
   

}