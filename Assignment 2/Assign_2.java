/*
* 
* Assign2.java
* TCSS 143 – Autumn 2014
* Assignment 2
*
*/

import java.util.Scanner; // import scanner class
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
* This program will perform a basic multiplication of two matrices
*
* @author Ian Skyles iskyles@uw.edu
* @version 10/5/2014
*/

public class Assign_2 {

   /**
    * Driver method of the class average processing.
    *
    * @param theArgs is used for command line input.
    * @return void
    */
   public static void main(String[] theArgs) {
   
      
       Scanner input = null;
       PrintStream output = null;
       String inFileName = "in2.txt";
       String outFileName = "out.txt";
       
            
       boolean filesOk = false; // Indicates if the files are accessable.
       try {
          input = new Scanner(new File(inFileName));
          output = new PrintStream(new File(outFileName));
          filesOk = true;
       }
       catch (FileNotFoundException e) {
          System.out.println("Can't open file - " + e);
       }
       if (filesOk) {         
         
         //calls getArraysFromFile to populate each array with proper numbers and size
         int [][] firstArray = getArraysFromFile(input);
         int [][] secondArray = getArraysFromFile(input);
         int [][] multipliedArray = multiplyArrays(firstArray, secondArray);
         printArraysToOutputFile(firstArray, secondArray,
                                 multipliedArray, output);
         
         
         
         
       }
   }
   
   /**
    * reads array row/col size and creates an array of that size, populates said array
    * by reading numbers from file until array is full     
    *(assumes you have proper info in file)
    *
    * @param theInput is a Scanner to read from file specified in main.
    * @return a 2d integer array containing the numbers
    */
 
   public static int[][] getArraysFromFile(Scanner theInput) {
      //reads col and row size from input file
      int rowSize = theInput.nextInt();
      int colSize = theInput.nextInt();
      
      //creates 2d array with rowSize and colSize read from file
      int [][] populatedArray = new int[rowSize][colSize];
      
      //reads numbers into array from file using row major order
      for(int i = 0; i < populatedArray.length; i++) {
         for(int j = 0; j < populatedArray[i].length && theInput.hasNextInt(); j++) {
            populatedArray[i][j] = theInput.nextInt();
         }
      }
      return populatedArray;
   
   }
   
   /**
    * multiplies first and second array to find out values for third array,
    * also finds proper size, populates multipledArray and returns to main
    *   
    * @param theFirstArray is the first arrray of numbers
    * @param theSecondArray is the second array of numbers
    * @return multipled matrix from first and second array
    */
   
   public static int[][] multiplyArrays(int theFirstArray[][], int theSecondArray[][]) {
      int rowsInFirstArray = theFirstArray.length;
      int columnsInFirstArray = theFirstArray[0].length;
      int columnsInSecondArray = theSecondArray[0].length;
      int multipliedArray[][] = new int[rowsInFirstArray][columnsInSecondArray];
      
      /*
         first for loop: while we still have rows left in first array
         second for loop: while we still have columns in second array
         third for loop: used to traverse rows in second array and 
      */ 
      for(int i = 0; i < rowsInFirstArray; i++) {
         for(int j = 0; j < columnsInSecondArray; j++) {
            for(int k = 0; k < columnsInFirstArray; k++) {
               //keeps sum and adds next multipled number to sum
               multipliedArray[i][j] = multipliedArray[i][j] +
               theFirstArray[i][k] * theSecondArray[k][j];
            }
         }
      }
      return multipliedArray;
   }
   
   /**
    * Prints first, second, multipled arrays to output text file specified in main
    *   
    * @param theFirstArray is the first arrray of numbers
    * @param theSecondArray is the second array of numbers
    * @param theMultipliedArray is the multipled (answered) array from the matrix problem
    * @param theOutput is a printstream to a textfile
    * @return void - 
    */
    
   public static void printArraysToOutputFile(int theFirstArray[][], int theSecondArray[][],
                                              int theMultipliedArray[][], PrintStream theOutput) {
      theOutput.println("First Array: ");
      for (int i = 0; i < theFirstArray.length; i++) {
         for (int j = 0; j < theFirstArray[i].length; j++) {
            theOutput.print(theFirstArray[i][j] + " ");
         }
            theOutput.println();
            
      }
      theOutput.println();
      theOutput.println("Second Array: ");
      for (int i = 0; i < theSecondArray.length; i++) {
         for (int j = 0; j < theSecondArray[i].length; j++) {
            theOutput.print(theSecondArray[i][j] + " ");
         }
            theOutput.println();
      }
      theOutput.println();
      theOutput.println("Multiplied Array: ");
      for (int i = 0; i < theMultipliedArray.length; i++) {
         for (int j = 0; j < theMultipliedArray[i].length; j++) {
            theOutput.print(theMultipliedArray[i][j] + " ");
         }
            theOutput.println();
      }
      
      
   
   }
   
}

/*
   ideas 2 solve after viewing assignment:  
   
   read array width/heigth
   create array and populate
   read array width/height for second array
   create arraay and populate 2nd array
   
   multiply 1st and 2nd array
   
   print 1st,2nd and resulting array to out file 
   */