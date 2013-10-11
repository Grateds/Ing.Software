package com.Grateds.Reversi;

import com.Grateds.Reversi.CONTROLLER.*;

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
    }
}
    
    
