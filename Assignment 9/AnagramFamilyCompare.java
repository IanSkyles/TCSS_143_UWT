/*
* 
* AnagramFamilyCompare.java
* TCSS 143 – Autumn 2014
* Assignment 9
* 
*/

import java.util.*;

/**
* AnagramFamilyCompare is used to compare for AnagramFamily.java
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/28/2014
*/

public class AnagramFamilyCompare implements Comparator<AnagramFamily> {

   /**
   * compares two family sizes 
   * @param AnagramFamily family one
   * @param AnagramFamily family two
   * @return int based on comparison results 
   */
   public int compare(AnagramFamily familyOne, AnagramFamily familyTwo) {
      /*if(familyOne.getFamilySize() < familyTwo.getFamilySize()) {
         return -1;
      } else if(familyOne.getFamilySize() > familyTwo.getFamilySize()) {
         return 1;
      } else {               
         return 0;
      }   */
      return familyOne.getFamilySize() - familyTwo.getFamilySize();   
   }
}