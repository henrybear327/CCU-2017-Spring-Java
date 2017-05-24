/**
 * Created by henrybear327 on 18/05/2017.
 */
// A simple Swing application.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingDemo {
    public void swingDemo() {
        // Create a new JFrame container.
        JFrame jframe = new JFrame("A Simple Swing Application (title bar)");

        // Give the frame an initial size.
        jframe.setSize(400, 300);

        // Terminate the program when the user closes the application.
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create a text-based label.
        JLabel jlabel = new JLabel("JLabel!");

        // Add the label to the content pane.
        jframe.add(jlabel);

        // Display the frame.
        jframe.setVisible(true);
    }

    private JLabel jlab;

    public void eventDemo() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("An Event Example");

        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(220, 90);

        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Make two buttons.
        JButton jbtnAlpha = new JButton("Alpha");
        JButton jbtnBeta = new JButton("Beta");

        // Add action listener for Alpha.
        jbtnAlpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jlab.setText("Alpha was pressed.");
            }
        });

        // Add action listener for Beta.
        jbtnBeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jlab.setText("Beta was pressed.");
            }
        });

        // Add the buttons to the content pane.
        jfrm.add(jbtnAlpha);
        jfrm.add(jbtnBeta);

        // Create a text-based label.
        jlab = new JLabel("Press a button.");

        // Add the label to the content pane.
        jfrm.add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingDemo swing = new SwingDemo();
                swing.eventDemo();
            }
        });
    }
}