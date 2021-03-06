package com.Grateds.Reversi.GUI;

import com.Grateds.Reversi.CONTROLLER.Controller;
import com.Grateds.Reversi.MODEL.Board;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class SmallWindow extends JFrame implements Observer{
  
	private static final long serialVersionUID = 1L;
	private GameMenu menuBar;
	private Controller controller;
	private Board board;

    public SmallWindow(Controller c) {
        setTitle("Reversi");
        controller = c;
        board = c.getBoard();
        board.addObserver(this);
        menuBar = new GameMenu(c);
        setJMenuBar(menuBar);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        controller.initialization(); // fix
        GameGraphicsPanel gameGraphicsPanel1 = new GameGraphicsPanel(c,1);
        this.add(gameGraphicsPanel1);
        this.setSize(565, 605);
        setResizable(false);
        this.setLocationRelativeTo(getOwner());
        //setVisible(true);   
    } // end MainWindow
   
    public Controller getController(){
    	return controller;
    }
       
    public void update(Observable o, Object arg) {
        controller.get_scores();
        controller.update_totalScore();
        this.repaint();
    }
    
}
