package com.Grateds.Reversi.GUI;

import com.Grateds.Reversi.CONTROLLER.Controller;
import com.Grateds.Reversi.MODEL.Board;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameGraphicsPanel extends JPanel implements MouseListener, Observer{
    
    int sizeRect = 70;

    private BufferedImage blackPieceImg = null;
    private BufferedImage whitePieceImg = null;
    private BufferedImage background = null;
    private int BLACK_PIECE = 2;
	private int WHITE_PIECE = 1;
    private Board b;
    private Controller controller;
    
    public GameGraphicsPanel(Controller c){
        loadImages();
        addMouseListener(this);
        setBorder(null);
        controller = c;
        b = controller.getBoard();
        b.addObserver(this);
    }

    private void loadImages() {
        try {
        																				
            background = ImageIO.read(new File("img/blue012.jpg"));// Changed values for Vercryger
            blackPieceImg = ImageIO.read(new File("img/blackpiece.png"));
            whitePieceImg = ImageIO.read(new File("img/whitepiece.png"));
            System.out.println("Images load");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) {
//        System.out.println("painting..");
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, WIDTH, WIDTH, this);
        g2d.setStroke(new BasicStroke(3));
        //Draw lines
        //Comented for Vercryger
//        for(int i= 1; i < 9; i++){
//            for(int j= 1; j < 9; j++){
//                g.setColor(Color.black);
//                g2d.drawRect(0, 0, i*sizeRect, j*sizeRect);
//            }
//        }
        //Draw the model
        if(controller.getBoard()!=null){
            drawBoard(g,controller.getBoard());
        }
    }
    
    private void drawPiece(Graphics g, BufferedImage img, int row, int col) {
        g.drawImage(img,((col-1) * sizeRect+2),((row-1) * sizeRect)+2, null);
    }
    
    private void makeMoveIn(int col, int row, int piece) {
        Graphics g = getGraphics();
        // update model with the move of the player
        if (piece == BLACK_PIECE) drawPiece(g,blackPieceImg, row, col);
        else drawPiece(g,blackPieceImg, row, col);
    }
    
    public void drawBoard(Graphics g,Board b){
        for(int i= 0; i < 8; i++){
            for(int j= 0; j < 8; j++){
                if (b.get(i, j) == 1){
                    drawPiece(g,whitePieceImg, i+1, j+1);
                }else if (b.get(i, j)== 2){
                    drawPiece(g,blackPieceImg, i+1, j+1);
                }
            }
        }
    }
    
    public void mouseClicked(MouseEvent me) {
        int x=me.getX();
        int y=me.getY();
        int col = (x/sizeRect+1);
        int row = (y/sizeRect+1);
//        System.out.println("click in " + (row-1) + " y " + (col-1));
        if(controller.set_piece(row-1, col-1, BLACK_PIECE)) makeMoveIn(col, row, BLACK_PIECE);
    }
    
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
