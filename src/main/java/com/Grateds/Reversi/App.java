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
    	 controller.set_piece(2, 2, "BLACK");
    	 System.out.println("Score BLACK PIECES = "+controller.getBlackScore());
    	 System.out.println("Score WHITE PIECES = "+controller.getWhiteScore());  
    	 
    	 
    	 // functionality test
    	 Board b = new Board();
    	 AI a = new AI();
    	 System.out.println(a.isValidMove(b, 1, 3, 2)); // isValidMove(b, 1, 3, 2) should return: false
    	 System.out.println(a.isValidMove(b, 2, 4, 5)); // isValidMove(b, 2, 4, 5) should return: true
   }
}




