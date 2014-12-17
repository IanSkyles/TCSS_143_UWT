/*
 * Class CritterPanel "CritterPanel.java."
 * TCSS 143.
 */

// imports.  Note the sorted order:
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Draws/redraws the JPanel environment grid in which all Critters
 * traverse and live.
 *
 * @author Stuart Reges
 * @author David Schuessler <dschues1@uw.edu>
 *
 * @version 19 October 2014
 */
public class CritterPanel extends JPanel {

  // Constant fields:
  
  /** Used for consistent font size on the grid. */
  public static final int FONT_SIZE = 12;

  // Instance fields:
  
  /** The model used for the Critter grid environment. */
  private CritterModel myModel;
  
  /** The font characteristics for drawing on the Critter grid. */
  private Font myFont;

  /**
   * Constructs a CritterPanel.
   *
   * @param theModel contains the locations of all existing Critters
   * and what to be drawn on the CritterPanel.
   */
  public CritterPanel(CritterModel theModel) {
    myModel = theModel;
    // construct font and compute char width once in constructor
    // for efficiency
    myFont = new Font("Monospaced", Font.BOLD, FONT_SIZE);
    setBackground(Color.cyan);
    setPreferredSize(new Dimension(FONT_SIZE * theModel.getWidth() / 2 + 125,
                                   FONT_SIZE * theModel.getHeight() + 20 ));
  }

  /**
   * Draws/redraws the CritterPanel on each movement of the Critters.
   *
   * @param theG is the Graphics object used for drawing.
   */
  public void paintComponent(Graphics theG) {
    super.paintComponent(theG);
    theG.setFont(myFont);
    int height = myModel.getHeight();
    int width = myModel.getWidth();
    // because font is monospaced, all widths should be the same;
    // so we can get char width from any char (in this case x)
    int charWidth = theG.getFontMetrics().charWidth('x');
    int extraX = getWidth() - (width + 1) * charWidth;
    int extraY = getHeight() - (height - 1) * FONT_SIZE;
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        theG.drawString("" + myModel.getChar(i, j),
                        extraX/2 + i * charWidth,
                        extraY/2 + j * FONT_SIZE);
      }
    }
  }
}
