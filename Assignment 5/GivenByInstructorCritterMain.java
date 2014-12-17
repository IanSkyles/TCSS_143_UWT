/*
 * Class CritterMain "CritterMain.java."
 * TCSS 143.
 */

import java.awt.EventQueue;

/**
 * CritterMain provides method main for a simple simulation program.
 *
 * @author Stuart Reges
 * @author David Schuessler <dschues1@uw.edu>
 *
 * @version 19 October 2014
 */
public final class CritterMain {

  /** private constructor to inhibit instantiation. */
  private CritterMain() {
    // Do not instantiate objects of this class
    throw new IllegalStateException();
  }

  /**
   * The start point for the CritterMain application.
   * 
   * @param theArgs command line arguments - ignored
   */
  public static void main(String[] theArgs) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        CritterFrame frame = new CritterFrame();

        frame.add(50, Bat.class);
        frame.add(25, Frog.class);
        frame.add(25, Mouse.class);
        frame.add(25, Turtle.class);
        frame.add(25, Wolf.class);
        frame.add(100, Stone.class);

        frame.start();
      }
    });
  }
}