package jorn.letnes;

import javax.swing.*;

public class PictureMorpher {

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Picture morpher");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Panel
        MyPanel myPanel = new MyPanel();
        frame.getContentPane().add(myPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void doTheThing() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

