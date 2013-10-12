package com.Grateds.Reversi.GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class gamePanel extends JPanel{

    private BufferedImage img;

    public gamePanel() {
        try {
            img = ImageIO.read(new File("img/wood8.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        setBorder(null);
    }
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}