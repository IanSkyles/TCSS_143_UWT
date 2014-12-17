/*
 * Class CritterModel "CritterModel.java."
 * TCSS 143.
 */

// imports.  Note the sorted order:

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class CritterFrame provides the user interface for a simple simulation
 * program.
 *
 * @author Stuart Reges
 * @author David Schuessler <dschues1@uw.edu>
 *
 * @version 19 October 2014
 */
public class CritterFrame extends JFrame {

    /**  A reference to the actual grid simulation. */
    private CritterModel myModel;
    
    /** Panel on which the Critter simulation grid is painted. */
    private CritterPanel myPicture;
    
    /**  Timer with each interval triggering a move of a Critter. */
    private javax.swing.Timer myTimer;
    
    /** None functioning buttons to display the count of remaining Critters. */
    private JButton[] myCounts;

    /**
     * Contructor to set up the Frame on which the simulation grid
     * is drawn.
     */
    public CritterFrame() {
        // create frame and order list
        setTitle("TCSS143 critter simulation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        myModel = new CritterModel(100, 50);

        // set up critter picture panel and set size
        myPicture = new CritterPanel(myModel);
        add(myPicture, BorderLayout.CENTER);

        addTimer();

        // add timer controls to the south
        JPanel p = new JPanel();
        JButton b1 = new JButton("start");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myTimer.start();
            }
        });
        p.add(b1);
        JButton b2 = new JButton("stop");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myTimer.stop();
            }
        });
        p.add(b2);
        JButton b3 = new JButton("step");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doOneStep();
            }
        });
        p.add(b3);
        add(p, BorderLayout.SOUTH);
    }

    /** Starts the simulation...assumes all critters have already been added. */
    public void start() {
        addClassCounts();
        pack();
        setVisible(true);
    }

    /** Add right-hand column showing how many of each critter are alive. */
    private void addClassCounts() {
        Set<Map.Entry<String, Integer>> entries = myModel.getCounts();
        JPanel p = new JPanel(new GridLayout(entries.size(), 1));
        myCounts = new JButton[entries.size()];
        for (int i = 0; i < myCounts.length; i++) {
            myCounts[i] = new JButton();
            p.add(myCounts[i]);
        }
        add(p, BorderLayout.EAST);
        setCounts();
    }
    /** Initialize the starting counts of all Critters in the simulation. */
    private void setCounts() {
        Set<Map.Entry<String, Integer>> entries = myModel.getCounts();
        int i = 0;
        for (Map.Entry<String, Integer> entry: myModel.getCounts()) {
            myCounts[i].setText(entry.toString());
            i++;
        }
    }

    /** 
     * Add a certain number of critters of a particular 
     * class to the simulation.
     *
     * @param theNumber contains how many objects of the class to add. 
     * @param theClass is the class to be added to the simulator.
     */
    public void add(int theNumber, Class theClass) {
        myModel.add(theNumber, theClass);
    }

    /**
     * post: creates a timer that calls the model's update
     *       method and repaints the display.
     */
    private void addTimer() {
        ActionListener updater = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doOneStep();
            }
        };
        myTimer = new javax.swing.Timer(100, updater);
        myTimer.setCoalesce(true);
    }

    /**
     * Performs one step of the simulation.
     */
    private void doOneStep() {
        myModel.update();
        setCounts();
        myPicture.repaint();
    }
 }
