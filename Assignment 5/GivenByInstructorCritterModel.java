/*
 * Class CritterModel "CritterModel.java."
 * TCSS 143.
 */

// imports.  Note the sorted order:
import java.awt.Point;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class CritterModel keeps track of the state of the critter simulation.
 *
 * @author Stuart Reges
 * @author David Schuessler <dschues1@uw.edu>
 *
 * @version 19 October 2014
 */
public class CritterModel {

  // CritterModel instance fields:
  
  /** The height of the Critter environment grid. */
  private int myHeight;

  /** The width of the Critter environment grid. */
  private int myWidth;

  /** A grid (2DArray) containing all living Critters at their 
   * current locations. */
  private Critter[][] myGrid;
  
  /** A char representation of myGrid used to draw on the 
   *  CritterPanel (a JPanel). */
  private char[][] myDisplay;
  
  /** A mapping of each living critter and it's location. */
  private Map<Critter, Point> myList;
  
  /** A map to keep track each type of critter count. */
  private SortedMap<String, Integer> myCritterCount;
    
  /**
   * Instantiates the Critter environment model.
   *
   * @param theWidth is the grid width.
   * @param theHeight is the grid height.
   */
  public CritterModel(int theWidth, int theHeight) {
    myWidth = theWidth;
    myHeight = theHeight;
    myGrid = new Critter[theWidth][theHeight];
    myDisplay = new char[theWidth][theHeight];
    updateDisplay();
    myList = new HashMap<Critter, Point>();
    myCritterCount = new TreeMap<String, Integer>();
  }

  /**
   * Instantiates number, number of Critter objects and randomly
   * places them on the Critter environment grid.
   *
   * @param theNumber is how many of theCritter to place on the grid.
   * @param theCritter is the Critter object to place on the grid.
   */ 
  public void add(int theNumber, Class theCritter) {
    if (myList.size() + theNumber > myWidth * myHeight) {
      throw new RuntimeException("adding too many critters");
    }
    for (int i = 0; i < theNumber; i++) {
      Object instance;
      try {
        instance = theCritter.newInstance();
      } catch (Exception e) {
          throw new RuntimeException("no zero-argument constructor for "
                                     + theCritter);
      }
      if (!(instance instanceof Critter)) {
        throw new RuntimeException(theCritter + " does not implement Critter");
      }
      Critter next = (Critter)instance;
      int x, y;
      do {
        x = randomInt(0, myWidth - 1);
        y = randomInt(0, myHeight - 1);
      } while (myGrid[x][y] != null);
      myGrid[x][y] = next;
      myDisplay[x][y] = next.getChar();
      myList.put(next, new Point(x, y));
    }
    String name = theCritter.getName();
    if (!myCritterCount.containsKey(name)) {
      myCritterCount.put(name, theNumber);
    } else {
      myCritterCount.put(name, myCritterCount.get(name) + theNumber);
    }
  }

  /**
   * Used by the add method to randomly place Critters on the Critter
   * environment grid during initial setup of the grid.
   *
   * @param theLow is the smallest coordinate value to return.
   * @param theHigh is the highest coordinate value to return.
   *
   * @return a random valid coordinate for placing a Critter on the grid.
   */
  private static int randomInt(int theLow, int theHigh) {
    return theLow + (int)(Math.random() * (theHigh - theLow + 1));
  }

  public int getWidth() {
    return myWidth;
  }

  public int getHeight() {
    return myHeight;
  }

  /**
   * Used to acquire the single character representation of a
   * Critter based on an x/y coordinate.
   *
   * @param theX is the x coordinate.
   * @param theY is the y coordinate.
   *
   * @return a character representing a Critter at the given coordinate.
   */
  public char getChar(final int theX, final int theY) {
    return myDisplay[theX][theY];
  }

  /**
   * Asks each critter once on each round how to display it.
   * This method does the asking, storing the result in display.
   */
  private void updateDisplay() {
    // set it to all dots
    for (int x = 0; x < myWidth; x++) { 
      for (int y = 0; y < myHeight; y++) {
        if (myGrid[x][y] == null) {
          myDisplay[x][y] = '.';
        } else {
          myDisplay[x][y] = myGrid[x][y].getChar();
        }
      }
    }
  }

  /**
   * The state of the Critter environment grid, the count of still
   * living critters (myCritterCount), and the list of living critters
   * (myList) are all updated according the the most recent move.
   */
  public void update() {
    Critter[][] newGrid = new Critter[myWidth][myHeight];
    Object[] list = myList.keySet().toArray();
    Collections.shuffle(Arrays.asList(list));
    for (int i = 0; i < list.length; i++) {
      Critter next = (Critter) list[i];
      Point p = myList.get(next);
      int move = next.getMove(new Info(p.x, p.y));
      movePoint(p, move);
      String name = next.getClass().getName();            
//      if (name.equals("Stone")) {
//        newGrid[p.x][p.y] = next;
//      } else {
        if (newGrid[p.x][p.y] != null) {
          String c = newGrid[p.x][p.y].getClass().getName();
          if (c.equals("Stone")) {
 if (!(name.equals("Stone"))) {              
            myCritterCount.put(name, myCritterCount.get(name) - 1);
            myList.remove(next);
}            
          } else {
            myCritterCount.put(c, myCritterCount.get(c) - 1);
            myList.remove(newGrid[p.x][p.y]);
            newGrid[p.x][p.y] = next;                
          }
        } else {
          newGrid[p.x][p.y] = next;
        }
     // }            
    }
    myGrid = newGrid;
    updateDisplay();
  }

  /**
   * Accessor for a Set of Critters and their counts still alive.
   *
   * @return a set of the Critters and their counts pairs.
   */
  public Set<Map.Entry<String, Integer>> getCounts() {
    return Collections.unmodifiableSet(myCritterCount.entrySet());
  }

  /**
   * Translates a point's coordinates 1 unit in a particular direction.
   *
   * @param theP is the coordinate location of a Critter.
   * @param theDirection is the current direction the Critter is travelling.
   */
  private void movePoint(Point theP, final int theDirection) {
    if (theDirection == Critter.NORTH) {
      theP.y = (theP.y + myHeight - 1) % myHeight;
    } else if (theDirection == Critter.SOUTH) {
      theP.y = (theP.y + 1) % myHeight;
    } else if (theDirection == Critter.EAST) {
      theP.x = (theP.x + 1) % myWidth;
    } else if (theDirection == Critter.WEST) {
      theP.x = (theP.x + myWidth - 1) % myWidth;
    } else if (theDirection != Critter.CENTER) {
      throw new RuntimeException("Illegal direction");
    }
  }

  /**
   * Private inner class object used to query a critter's 
   * state (position, neighbors).
   */
  private class Info implements CritterInfo {
  
    /** A Critter's x coordinate location. */
    private int myX;

    /** A Critter's y coordinate location. */
    private int myY;

    /**
     * Constructor to set a Critter's x/y coordinate locations.
     *
     * @param theX used to set the Critter's x coordinate location.
     * @param theY used to set the Critter's y coordinate location.
     */
    public Info(final int theX, final int theY) {
      myX = theX;
      myY = theY;
    }

    /**
     * Accessor for the Critter's x coordinate location.
     *
     * @return the Critter's x coordinate location.
     */
    public int getX() {
      return myX;
    }

    /**
     * Accessor for the Critter's y coordinate location.
     *
     * @return the Critter's y coordinate location.
     */
    public int getY() {
      return myY;
    }

    /**
     * Returns a Critter's neighbor based on the Critter's direction.
     *
     * @param theDirection is the current direction the Critter is travelling.
     *
     * @return a Critter's neighbor base on the Critter's direction.
     */
    public char getNeighbor(final int theDirection) {
      Point other = new Point(myX, myY);
      movePoint(other, theDirection);
      return myDisplay[other.x][other.y];
    }

    /**
     * Accessor for the height of the Critters' environment grid.
     *
     * @return the Critters' environment grid height.
     */
    public int getHeight() {
      return myHeight;
    }

    /**
     * Accessor for the width of the Critters' environment grid.
     *
     * @return the Critters' environment grid width.
     */
    public int getWidth() {
      return myWidth;
    }
  }
}
