/*
* 
* Assignment7.java
* TCSS 143 – Autumn 2014
* Assignment 7
* 
*/

//import java.;
import java.util.*;
import java.io.*;
import java.lang.String;

/**
* Assignment7 is the driver class
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/11/2014
*/

public class Assignment7 {
   /**
   * main is the main applet/driver method
   * @param String[] theArgs
   */
   public static void main(String[] theArgs) {
       Scanner inputFile = null;
       PrintStream outputFile = null;
       try{
          inputFile = new Scanner(new File("In7.txt"));
          outputFile = new PrintStream(new File("out7.txt"));
       } catch (Exception e){
          System.out.println("Difficulties opening the file! " + e);
          System.exit(1);
       }
       
       List<Shape> myList = new LinkedList<Shape>(create(inputFile));
       outputFile.println("Original List[unsorted]:");
       print(myList, outputFile);
       List<Shape> copyList = new ArrayList<Shape>(myList);
       Collections.sort(copyList);
       outputFile.println("\r\nCopied List[sorted]:");
       print(copyList, outputFile);
       outputFile.println("\r\nOriginal List[unsorted]:");
       print(myList, outputFile);

   }
   
   /**
   * creates a list of shapes and returns it
   * @param theInputFile used to read the data
   * @return List<Shape> the returned list contains the shapes
   */
   public static List<Shape> create(Scanner theInputFile) {
          List<Shape> myList = new LinkedList<Shape>();
          int wordCount = 0, totalTokens = 0;
          double first = 0.0, second = 0.0, third = 0.0;

          while (theInputFile.hasNextLine()) {          
          String currentLine = theInputFile.nextLine();
          String[] tokens = currentLine.split(" "); 
          Scanner line = new Scanner(currentLine);
          wordCount = 0;
          totalTokens = tokens.length;
          while(((line.hasNextDouble()) || (line.hasNextInt())) && wordCount <= 3) {
             wordCount++;
             if(wordCount == 1) {
               first = line.nextDouble();
             } else if(wordCount == 2) {
               second = line.nextDouble(); 
             } else {
               third = line.nextDouble();  //((line.nextDouble()) || (line.nextInt()))
            }                  
          
          } 
          if(totalTokens != wordCount) {
            wordCount = 0;
          }                                                          
                try {
                   if(wordCount == 1) { // if one word on line
                        myList.add(new Circle(first));
                   } else if(wordCount == 2) { // if 2 words on line
                        myList.add(new Rectangle(first, second));
                   } else if (wordCount == 3) { // if 3 words on line
                        myList.add(new Triangle(first, second, third));
                   } //else do nothing
                } catch (Exception e) {
                     System.out.println(e);
                }
          
       }
      return myList;
   
   }
   
   /**
   * prints every shape object within the list 
   * @param List<Shap> theList used to print arraylist/linkedlist
   * @param PrintStream theOutputFile - used for outputing to txt file
   */
   public static void print(List<Shape> theList, PrintStream theOutputFile) {
      for(Shape s : theList) {
         theOutputFile.println(s);
      }
   
   }

}
