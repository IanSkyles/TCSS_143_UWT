/*
* 
* Book.java
* TCSS 143 – Autumn 2014
* Assignment 6
* 
*/

import java.util.ArrayList;

/**
* Book class 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/4/2014
*/

public class Book implements Comparable<Book> {
   /**
   * @Field : title of the book
   * @Final Constant
   */  
   private final String MY_TITLE;
   
   /**
   * @Field : author(s) name(s)
   * @Final constant
   */  
   private final ArrayList<String> MYAUTHORS;
   
   /**
   * Constructor Book : builds a book object
   * @param String theTitle takes string for title
   * @param ArrayList<String> the Authors takes list of authors
   */  
   public Book(final String theTitle, final ArrayList<String> theAuthors) {
      if((theTitle == null) || (theTitle == "") || (theAuthors == null)
          || (theAuthors.size() == 0)) {
         throw new IllegalArgumentException("null or empty");
      } else {
         this.MYAUTHORS = new ArrayList<String>();
         for(int i = 0; i < theAuthors.size(); i++) {
            MYAUTHORS.add(i, theAuthors.get(i));
         }
      this.MY_TITLE = theTitle;      
      }
   }
   
   /**
   *  This method returns the title field - gettter
   * @return String MY_TITLE field
   */  
   public String getTitle() {
      return this.MY_TITLE;
   }
   
   /**
   *  This method returns the Authors field - gettter
   * @return ArrayList<String> MYAUTHORS field
   */  
   public ArrayList<String> getAuthors() {
      return this.MYAUTHORS;   
   }
   
   /**
   *  This method returns the formatted string - overrides toString
   * @return String - formatted string
   */ 
   public String toString() {
      String b_a = ""; // book and authors
      b_a = "\"" + MY_TITLE + "\" by ";
      for(int i = 0; i < MYAUTHORS.size(); i++) {
         b_a += " " + MYAUTHORS.get(i);
         if(i != MYAUTHORS.size() - 1) {
            b_a += ";";
         }
      }
      b_a += " \r\n";
      return b_a;
   }
   
   /**
   * comapres 2 books
   * @param Book Object that will be used to compare title/authors
   * @return int based on results of comparison
   */ 
   public int compareTo(final Book theOther) {     
      if(MY_TITLE.equals(theOther.MY_TITLE)) {
         return ((MYAUTHORS.get(0)).compareTo(theOther.MYAUTHORS.get(0)));
      }else {      
         return MY_TITLE.compareTo(theOther.MY_TITLE); 
      }
   }
   
   /**
   * compares 2 objects to findout if the other is a book
   * @param Book Object that will be used to compare objects
   * @return boolean based on results of comparison
   */ 

   public boolean equals(final Object theOther) {   
      boolean flag = false;   
      if(!(theOther instanceof Book)) {
             return false;
      }
      Book b = (Book) theOther;
      flag = b.MY_TITLE.equals(MY_TITLE)&& b.MYAUTHORS.equals(MYAUTHORS);      
      return flag;
   }   
}