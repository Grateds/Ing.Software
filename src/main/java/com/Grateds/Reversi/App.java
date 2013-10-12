package com.Grateds.Reversi;

import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.MODEL.Board;
import com.Grateds.Reversi.SAVEANDLOAD.SaveAndLoad;

public class App {

    public static void main( String[] args ){
    	 System.out.println( "It's OK" );
    	 User u = new User();
    	 u.delete(2122286520);
    	 Controller controller = new Controller();
    	 controller.start_game();	
    	 controller.set_piece(1, 1, "WHITE");
    	 System.out.println("Score BLACK PIECES = "+controller.getBlackScore());
    	 System.out.println("Score WHITE PIECES = "+controller.getWhiteScore());   
    	 
    	 /**
    	  * Writing and Reading test board
    	  * 
    	  * Board b = new Board();
    	  * SaveAndLoad save = new SaveAndLoad();
    	  *	b.set(3, 3, 0);
    	  *	b.set(4, 3, 0);
    	  *	b.set(3, 4, 0);
    	  *	save.saveBoard(b);
    	  *	b = save.loadBoard();
    	  *	b.draw(); 
    	  *
    	  **/ 
   }
}




