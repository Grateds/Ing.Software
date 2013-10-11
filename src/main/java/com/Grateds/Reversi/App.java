package com.Grateds.Reversi;

import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.MODEL.Board;
import com.Grateds.Reversi.SAVEANDLOAD.SaveAndLoad;

public class App {
    public static void main( String[] args ){
    	 System.out.println( "It's OK" );
    	 User u = new User();
    	 u.create("Antoni45", 456123);
    	 u.create("El_pabo", 45123749);
    	 Controller controller = new Controller();
    	 controller.start_game();	
    	 controller.set_piece(1, 1, "WHITE");
    	 System.out.println("Score BLACK PIECES = "+controller.getBlackScore());
    	 System.out.println("Score WHITE PIECES = "+controller.getWhiteScore());
    	 
    	 
    	Board b = new Board();
    	SaveAndLoad save = new SaveAndLoad();
    	//save.saveBoard(b);
    	//save.loadBoard();
   }
}

