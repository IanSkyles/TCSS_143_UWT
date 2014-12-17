/*
* 
* Assignment8.java
* TCSS 143 – Autumn 2014
* Assignment 8
* 
*/

//import java.;
import java.util.*;
import java.io.*;
import java.lang.String;

/**
* Assignment8 
*     The purpose of this programming project is to demonstrate 
* the functionality of Recursion while reviewing such 
* things as the use of Sets (here only a single Set will be
* implemented), String manipulation, file I/O using the 
* Scanner class for the input file.
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/19/2014
*/

public class Assignment8 {

   /**
   * gets all the words in a file that contain a said
   * character and returns them in a string
   * @param Scanner theFile - the file to be read
   * @param char theC - the character to be read 
   * @return String that has all words in the file that contain the char 
   */
   public static String getWordsString(Scanner theFile, char theC) {
      if(theFile.hasNext()) {
         String word = theFile.next();
         if(hasCharacter(word, theC)) {
            return word + " " + getWordsString(theFile, theC);
         } else {
            return getWordsString(theFile, theC);
         }
      }
      return "";
   }
   
   /**
   * finds out if the string passed contains a character
   * @param String theS - the string to be checked for the char
   * @param char theC - the char that will be searched for in the string
   * @return true or false based on if the char is inside the string
   */
   public static boolean hasCharacter(String theS, char theC) {
      //boolean flag = false;
      int upperOrLower = (int) theC;
      if(theS.length() >= 1) {
         if((upperOrLower >= 97) && (upperOrLower <=122)) { //its lowercases, check for upper
            if((theS.charAt(0) == theC) || (theS.charAt(0) == (char) (theC - 32))) {  //implement check for upper or lower case
               return true;
            }else {
               return hasCharacter(theS.substring(1), theC);
            }
         } else if((upperOrLower >= 65) && (upperOrLower <=90)) {
            if((theS.charAt(0) == theC) || (theS.charAt(0) == (char) (theC + 32))) {  //implement check for upper or lower case
               return true;
            }else {
               return hasCharacter(theS.substring(1), theC);
            }
         }
      } 
      return false; // string length is 0 or negative
    }
    
   /**
   * returns a set (of strings) that contains all unique words
   * @param String - theS : adds all words (split by ' ') to a set
   * @return a set (of strings) 
   */
   public static Set<String> getWordSet(String theS) {
      Set<String> setA = new HashSet<String>();
      int indexOfSpace = theS.indexOf(' ');
         if(indexOfSpace > 0) {
            setA.add(theS.substring(0,indexOfSpace));
            setA.addAll(getWordSet(theS.substring(indexOfSpace + 1)));
         } else if(indexOfSpace == -1) {
            setA.add(theS); 
         }
      return setA;      
   }
   
   /**
   * main is the main applet/driver method
   * @param String[] theArgs
   */
   public static void main(String[] theArgs) {
       Scanner inputFile = null;
       PrintStream outputFile = null;
       try{
          inputFile = new Scanner(new File("In8.txt"));
          outputFile = new PrintStream(new File("out8.txt"));
       } catch (Exception e){
          System.out.println("Difficulties opening the file! " + e);
          System.exit(1);
       }       
     String wordSet = "";
     wordSet = getWordsString(inputFile, 'a');
     Set<String> setB = new HashSet<String>(getWordSet(wordSet));
     setB.remove("");
     //outputFile.println(allUniqueWordsInFileContainingChar);
     outputFile.println(setB);
    } 
}
