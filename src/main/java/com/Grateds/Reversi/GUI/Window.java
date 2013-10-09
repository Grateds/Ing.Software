package com.Grateds.Reversi.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Window extends javax.swing.JPanel implements MouseListener {
    
        /******************************/
	/* CONSTANT FOR DRAWING BOARD */
	/******************************/
    
	/** size of board */
	private static final int sBOARD_SIZE = 8;
	
	/** border offset */
	private static final int sBORDER_OFFSET = 30;
	
	/** board offset */
	private static final int sBOARD_OFFSET = 20;
	
	/** border and board offset */
	private static final int sBORDER_BOARD_OFFSET = sBORDER_OFFSET + sBOARD_OFFSET;
	
	/** size of a square. */
	private static final int sSQUARE_WIDTH = 45;
	
	/** size of the board in pixels */
	private static final int sBOARD_SIZE_PIXEL = (sBOARD_OFFSET + sBORDER_OFFSET) * 2 + 
													sSQUARE_WIDTH * sBOARD_SIZE;
	
	/** radius of a piece */
	private static final int sPIECE_WIDTH = 35;
	
	/** offset piece inside a square */
	private static final int sSQUARE_OFFSET = (sSQUARE_WIDTH - sPIECE_WIDTH) >> 1;
	
	/** width of the border */
	private static final int sBORDER_WIDTH = 3;
	
	/** width of the division between square */
	private static final int sDIVIDE_WIDTH = 1;
	
	/** board color */
	private static final Color sBOARD_COLOR = new Color(176, 140, 0, 255);
	
	/** squares' divide color */
	private static final Color sDIVIDE_COLOR = Color.BLACK;
	
	/** color for susggest black piece */
	private static final Color sSUGGEST_BLACK_COLOR = new Color(0, 0, 0, 50);
	
	/** color for susggest white piece */
	private static final Color sSUGGEST_WHITE_COLOR = new Color(255, 255, 255, 80);
	
	/** color for board's texts */
	private static final Color sBOARD_TEXT_COLOR = Color.WHITE;
	
	/** font for board's texts */
	private static final Font sBOARD_FONT = new Font("SansSerif", Font.BOLD, 16);
	
	/** board column texts */
	private static final String[] sBOARD_COL_TEXT = {"A", "B", "C", "D", "E", "F", "G", "H"};
	
	/** board row texts */
	private static final String[] sBOARD_ROW_TEXT = {"1", "2", "3", "4", "5", "6", "7", "8"};
	

	/** image of black piece */
	public static BufferedImage mBlackPieceImg = null;
	
	/** image of white piece */
	public static BufferedImage mWhitePieceImg = null;
    
  
        public Window() {
        // add mouse listener
        addMouseListener(this);
        
        // set panel size to board size
        this.setPreferredSize(new Dimension(sBOARD_SIZE_PIXEL, sBOARD_SIZE_PIXEL));
        
        init();
        }
    
        private void init() {
    	// load image for pieces
		try {
                    mBlackPieceImg = ImageIO.read(new File("img/blackpiece.png"));
                    mWhitePieceImg = ImageIO.read(new File("img/whitepiece.png"));
                    //mBlackPieceImg = ImageIO.read(this.getClass().getResourceAsStream("/img/blackpiece.png"));
                    //mWhitePieceImg = ImageIO.read(this.getClass().getResourceAsStream("/img/whitepiece.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        }
    
    
        public void mouseClicked(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mousePressed(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseReleased(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseEntered(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseExited(MouseEvent arg0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    

}
