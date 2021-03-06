package com.Grateds.Reversi.GUI;

import javax.swing.JPopupMenu.Separator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import com.Grateds.Reversi.CONTROLLER.Controller;
import com.Grateds.Reversi.MODEL.Board;

public class GameMenu extends JMenuBar{ 
	
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private Board board = new Board();

	/**
	 * Game Options Menu
	 * @param c, the Controller
	 */
	public GameMenu(Controller c){
		
		controller = c;
		board = c.getBoard();	
		
        this.add(jMenu1);
        jMenu1.setText("Game"); // Menu Game
        jMenuItem1.setText("New game");
        jMenu1.add(jMenuItem1);
        jMenuItem1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		controller.stop();
            	@SuppressWarnings("unused")
				NewGame window = new NewGame(controller);  		
        	}
        }); 
        jMenu1.add(jSeparator1);
        
        jMenuItem2.setText("Save game"); // Save game
        jMenu1.add(jMenuItem2);
        jMenuItem2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		controller.saveBoard(board); 
        	}
        });
        
        jMenuItem3.setText("Load game"); // Load game
        jMenu1.add(jMenuItem3);
        jMenuItem3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		board = controller.loadBoard();
        		controller.setBoard(board);
        	}
        });
        jMenu1.add(jSeparator2);
        
        jMenuItem6.setText("Top scores"); // Top scores
        jMenu1.add(jMenuItem6);
        jMenuItem6.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event) {
                    TopScoresWindow scoreWindow = new TopScoresWindow();
                    scoreWindow.show();
        	}
        });
        jMenu1.add(jSeparator4);
        
        jMenuItem7.setText("Change view"); // Change view
        jMenu1.add(jMenuItem7);
        jMenuItem7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
                    controller.changeView();
        	}
        });
        jMenu1.add(jSeparator5); 
        
        jMenuItem8.setText("Exit"); // Exit
        jMenu1.add(jMenuItem8);
        jMenuItem8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		System.exit(0);
        	}
        });
          
        this.add(jMenu2); // Menu Help
        jMenu2.setText("Help");
        jMenu2.add(jMenuItem9);
        jMenuItem9.setText("About");     
    } // end GameMenu

    JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
    JMenu jMenu1 = new javax.swing.JMenu();
    JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
    Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
    
    JMenuItem jMenuItem2 = new javax.swing.JMenuItem();
    JMenuItem jMenuItem3 = new javax.swing.JMenuItem();
    Separator jSeparator2 = new javax.swing.JPopupMenu.Separator(); 
    
    JMenuItem jMenuItem6 = new javax.swing.JMenuItem();
    Separator jSeparator4 = new javax.swing.JPopupMenu.Separator();
    
    JMenuItem jMenuItem7 = new javax.swing.JMenuItem();
    Separator jSeparator5 = new javax.swing.JPopupMenu.Separator();
    
    JMenuItem jMenuItem8 = new javax.swing.JMenuItem();
    
    JMenu jMenu2 = new javax.swing.JMenu();
    JMenuItem jMenuItem9 = new javax.swing.JMenuItem();
} // end class GameMenu
