package jorn.letnes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.io.IOException;

class MyPanel extends JPanel implements ActionListener {

    private BufferedImage bufferedImage;
    private BufferedImage bufferedImageOriginal;
    private Timer timer = new Timer(0, this);
    private int counter = 0;
    private int increment = 1;

    public MyPanel() {

        readImage();

        setPreferredSize(new Dimension(this.bufferedImage.getWidth(), this.bufferedImage.getHeight()));
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();

        this.timer.start();
    }

    private void readImage() {
        ImageReader imageReader = new ImageReader();
        try {
            this.bufferedImageOriginal = imageReader.read("C:\\Users\\Pappa\\repos\\IdeaProjects\\PictureMorph\\src\\jorn\\letnes\\robban.bmp");
            this.bufferedImage = this.bufferedImageOriginal;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, 1000, 1000);

        g.drawImage(bufferedImage, 0, 0, null);
        System.out.println("Hello nordkalott " + this.counter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.timer) {
            repaint();
            incrementColors();
        }
    }

    private void incrementColors() {

        var op = new RescaleOp((float)counter/100.0f, 0f, null);

        bufferedImage = op.filter(bufferedImageOriginal, null);

        counter += increment;
        if (counter == 200 || counter == 0)
            increment = -increment;
    }
}

