/*
* 
* LibraryDriver.java
* TCSS 143 – Autumn 2014
* Assignment 6
* 
*/

import java.util.*;
import java.io.*;
import java.lang.String;

/**
* LibraryDriver class 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/4/2014
*/


public class LibraryDriver{
    public static void main(String[] theArgs){
       String title = "";
       String author = "";       
       Scanner inputFile = null ;
       PrintStream outputFile = null;
       try{
          inputFile = new Scanner(new File("LibraryIn1.txt"));
          outputFile = new PrintStream(new File("LibraryOut.txt"));
       } catch (Exception e){
          System.out.println("Difficulties opening the file! " + e);
          System.exit(1);
       }
       ArrayList<String> authors = new ArrayList<String>();
       ArrayList<Book> books = new ArrayList<Book>();
       inputFile.useDelimiter("\\*");
       while (inputFile.hasNext()) {          
          //read title
          title = inputFile.nextLine();
          //read author(s)
          author = inputFile.nextLine();
          authors.addAll(getAuthors(author));  
                         
          // Insert title & author(s)into a book
         // Book book = new Book(title, authors); 
          
          // Add this book to the ArrayList<Book> of books
         // books.add(book);
         books.add( new Book(title,authors));
          //author = "";
          //dont need above or below because of reset at top of loop
          //title = "";
          authors.clear();
       }
      // Instatiate a Library object filled with the books read thus far
      Library lib = new Library(books); 
      // and write the contents of the library to the output file
      outputFile.println("First print\r\n");
      outputFile.println(lib.toString());
      
      // Sort the current contents of the library
      
      lib.sort();
      // and write the contents of the sorted library to the output file
      outputFile.println("sort print\r\n");
      outputFile.println(lib.toString());
      // Close the first input file and open the second input file.
      inputFile.close();      
      try{
          inputFile = new Scanner(new File("LibraryIn2.txt"));          
       } catch (Exception e){
          System.out.println("Difficulties opening the file! " + e);
          System.exit(1);
       }
      // Read the titles and authors from the second input file,
      // add them to the library, and write the contents of the
      // library to the output file.
      //books.clear(); -- not neccessary only adding one book at a time not an array list
      while (inputFile.hasNext()) {          
          //read title
          title = inputFile.nextLine();
          //read author(s)
          author = inputFile.nextLine();
          authors.addAll(getAuthors(author));                 
          // Insert title & author(s)into a book
          Book book = new Book(title, authors); 
          // Add this book to the ArrayList<Book> of books
          //books.add(book);          
          lib.add(book);
       }
      
      outputFile.println("Prints with new books added\r\n");
      outputFile.println(lib.toString());   

      // Sort the library and write it to the output file
      outputFile.println("Second sort\r\n");
      lib.sort();
      outputFile.println(lib.toString());
      // The following tests the findTitles method:
      // Write only the "Acer Dumpling" books to the output file
      outputFile.println("Acer Dumpling Books\r\n");
      outputFile.println(lib.findTitles("Acer Dumpling"));
      // Write only the "The Bluffs" books to the output file
      outputFile.println("The Bluff Books\r\n");
      outputFile.println(lib.findTitles("The Bluff"));
      // Close all open files and end main. 
      inputFile.close();
      outputFile.close();        
    }
   // Header for method that separates author names and
   // returns an ArrayList<String> containing the author names
    public static ArrayList<String> getAuthors(String s){
       ArrayList<String> findAuthors = new ArrayList<String>();
       int previousStar = 0;
       int currentStar = 0;      
       
       for(int i = 0; i < s.length(); i++) {
         if(s.charAt(i) == '*') {
            currentStar = i;
            findAuthors.add(s.substring(previousStar, currentStar));
            System.out.println(s.substring(previousStar , currentStar));
            previousStar = i + 1;            
         }
       }
         findAuthors.add(s.substring(previousStar, s.length()));
         System.out.println(s.substring(previousStar, s.length()));           
         return findAuthors;
   } 
 }