/*
* 
* Library.java
* TCSS 143 – Autumn 2014
* Assignment 6
* 
*/

import java.util.ArrayList;
import java.util.Collections;

/**
* Book class 
* 
*               
* @author Ian Skyles iskyles@uw.edu
* @version 11/4/2014
*/

public class Library {
   /**
   @field ArrayList of Book objects
   */
   private ArrayList<Book> myBooks;
   
   
   /**
   * Constructor - creats library with arraylist of books populating 
   *              my books with book objects
   * @param ArrayList<Book> which contains the book objects
   */ 
   
   public Library(final ArrayList<Book> theOther) {
      if(theOther == null) {
         throw new NullPointerException("null pointer");
      } else {
          this.myBooks = new ArrayList<Book>();
          for(int i = 0; i < theOther.size(); i++) {
            myBooks.add(i, theOther.get(i));
          }
      }
   }
   
   /**
   * Constructor - creates library (and empty arraylist of book objects)
   */ 
   public Library() {
      this.myBooks = new ArrayList<Book>();
   }
   
   /**
   * Adds a book object to the library array list
   * @Book theBook the book that will be added to library
   * @return boolean based on whether it was succesfully added
   */ 
   public boolean add(final Book theBook) {
      boolean flag = true;
      if((theBook == null) || (theBook.equals(""))) {
         flag = false;
         throw new IllegalArgumentException("you tried to add a null or empty book");          
      }
      myBooks.add(theBook);
      
      return flag;
   }
   
   /**
   * finds all books that have specified title
   * @param String of the title to find
   * @return ArrayList<Book> that contains all the books that share titles
   */ 
   public ArrayList<Book> findTitles(final String theTitle) {
       ArrayList<Book> sameTitle = new ArrayList<Book>();
       for(Book b: myBooks) {
            if((b.getTitle()).equals(theTitle)) {
                sameTitle.add(b);
            }
        }
       return sameTitle;
   }
   
   /**
   * sorts the books in myBooks arraylist by book titles
   * @return void
   */ 
   public void sort() {   
      Collections.sort(myBooks);
   }
   
   /**
   * formats the myBooks arraylist for output
   * @return String formatted string of books titles/authors
   */ 
   public String toString() {
      String all = ""; //all titles and authors
      for(int i = 0; i < myBooks.size(); i++) {
         //all += ((myBooks.get(i)).getTitle());
         all += ((myBooks.get(i)).toString());  
      }
      return all;      
   }
}