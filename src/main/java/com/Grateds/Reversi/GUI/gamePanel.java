package com.Grateds.Reversi.GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class gamePanel extends JPanel{

    private BufferedImage background;

    public gamePanel() {
        try {
            background = ImageIO.read(new File("img/skin_1/background.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        setBorder(null);
    }
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}