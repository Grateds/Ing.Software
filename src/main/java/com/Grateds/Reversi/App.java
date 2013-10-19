package com.Grateds.Reversi;

import com.Grateds.Reversi.AI.AI;
import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.GUI.MainWindow;
import com.Grateds.Reversi.MODEL.Board;
import com.Grateds.Reversi.SAVEANDLOAD.SaveAndLoad;

public class App {

    public static void main( String[] args ){
    	 System.out.println( "It's OK" );
    	 User u = new User();
    	 u.delete(2122286520);
    	 //Controller controller = new Controller();
    	 //controller.start_game();
    	 //controller.drawBoard();
    	 //controller.set_piece(1, 1, "WHITE");
    	 //controller.set_piece(2, 2, "BLACK");
    	 //System.out.println("===============");
    	 //controller.drawBoard();
    	 //System.out.println("Score BLACK PIECES = "+controller.getBlackScore());
    	 //System.out.println("Score WHITE PIECES = "+controller.getWhiteScore());  
    	 
    	 
    	 // functionality test
    	 Board b = new Board();
    	 b.initialization();
    	 b.set(1, 1, 1);
    	 AI ai = new AI();
    	 b.draw();
    	 System.out.println(ai.isValidMove(b, 1, 3, 2)); // isValidMove(b, 1, 3, 2) should return: false
    	 System.out.println(ai.isValidMove(b, 2, 4, 5)); // isValidMove(b, 2, 4, 5) should return: true
    	 
    	 System.out.println(ai.getMoveList());
    	 System.out.println(ai.findValidMove(b, 2, true));
    	 b.draw();
   }
}









