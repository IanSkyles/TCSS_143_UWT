/*
* 
* Programming9Driver.java
* TCSS 143 – Autumn 2014
* Assignment 9
* 
*/

import java.io.*;
import java.util.*;

/**
* Programming9Driver is driver for assignment9
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/28/2014
*/
public class Programming9Driver {

   public static void main(String[] theArgs) {
   long startTime = System.nanoTime();



       Scanner inputFile = null;
       PrintStream outputFile = null;
       try{
          inputFile = new Scanner(new File("words.txt"));
          outputFile = new PrintStream(new File("out9.txt"));
       } catch (Exception e){
          System.out.println("Difficulties opening the file! " + e);
          System.exit(1);
       }
       List<Word> words = new LinkedList<Word>(create(inputFile));
       Collections.sort(words);
       List<AnagramFamily> familyList = new LinkedList<AnagramFamily>();
       List<AnagramFamily> families = new LinkedList<AnagramFamily>(createFamilyList(familyList, words));
       Collections.sort(families, new AnagramFamilyCompare());
       Collections.reverse(families);
       printTopTenFamilies(families, outputFile);
       long endTime = System.nanoTime();
       long duration = (endTime - startTime);       
       double seconds = (double)duration / 1000000000.0;
       System.out.print("Total Seconds: " + seconds);
   }
   
   /**
   * creates a list of words (from file) and returns it
   * @param Scanner theInputFile used to read the data
   * @return List<Word> the returned list contains the shapes
   */
   public static List<Word> create(Scanner theInputFile) {
          List<Word> myList = new LinkedList<Word>();
          
          while (theInputFile.hasNextLine()) {          
             String currentLine = theInputFile.nextLine();
             Scanner line = new Scanner(currentLine);
             while(line.hasNext()) {
               myList.add(new Word(line.next()));
             }                 
          }
          return myList;
   
   }
   
   /**
   * returns a set (of strings) that contains all unique words
   * @param List<Word> - the words to be added to families
   * @param List<AnagramFamily> empty list
   * @return List<AnagramFamily> list filled with words
   */
   public static List<AnagramFamily> createFamilyList(List<AnagramFamily> familyList, List<Word> theWords) {      
      Iterator<Word> readWords = theWords.iterator();
      Word previous = theWords.get(0);
      familyList.add(new AnagramFamily());
      int count = 0;
      while(readWords.hasNext()) {
         Word current = readWords.next();
         if(current.getCanonical().equals(previous.getCanonical())) { //is in family, add
            familyList.get(count).add(current);
         } else { // isnt in family, create new family
            count++;
            familyList.add(new AnagramFamily()); 
            familyList.get(count).add(current);
         }
         previous = current;
      }
      
      
      return familyList;
   }
   
   /**
   * prints top 10 families info
   * @param List<AnagramFamily> - the families
   * @param PrintStream - theOutput file
   */
   public static void printTopTenFamilies(List<AnagramFamily> theFamilies, PrintStream theOutput) {
		for(int i = 0; i < 10; i++) {         
         theOutput.print("#" + i + "\r\n");
			theOutput.println("Anagram Family: " + theFamilies.get(i).getCanonical() + "\r\n");
			theOutput.println("Family Size: " + theFamilies.get(i).getFamilySize() + "\r\n");
			theOutput.println("Words: " + theFamilies.get(i) + "\r\n");
		}
	}

   
}