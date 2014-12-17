/*
 * Class CritterModel "CritterModel.java."
 * TCSS 143.
 */

/**
 * The CritterInfo interface defines a set of methods for querying the
 * state of a critter simulation.  The getX and getY methods return a
 * critter's current location in the world.  The getNeighbor method
 * takes a direction as a parameter (one of the constants NORTH,
 * SOUTH, EAST, WEST or CENTER from the Critter interface).  It
 * returns the display character for the critter that is one unit away
 * in that direction (a period if the square is empty).  The getHeight
 * and getWidth methods return the height and width of the world.
 *
 * @author Stuart Reges
 * @author David Schuessler <dschues1@uw.edu>
 *
 * @version 19 October 2014
 */
public interface CritterInfo {

    /**
     * Accessor for the Critter's x coordinate location.
     *
     * @return the Critter's x coordinate location.
     */
    public int getX();

    /**
     * Accessor for the Critter's y coordinate location.
     *
     * @return the Critter's y coordinate location.
     */
    public int getY();

    /**
     * Returns a Critter's neighbor based on the Critter's direction.
     *
     * @param theDirection is the current direction the Critter is travelling.
     *
     * @return a Critter's neighbor base on the Critter's direction.
     */
    public char getNeighbor(int direction);

    /**
     * Accessor for the height of the Critters' environment grid.
     *
     * @return the Critters' environment grid height.
     */
    public int getHeight();
 
    /**
     * Accessor for the width of the Critters' environment grid.
     *
     * @return the Critters' environment grid width.
     */
    public int getWidth();
}
