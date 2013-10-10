package com.Grateds.Reversi;

import com.Grateds.Reversi.CONTROLLER.*;

public class App {
    public static void main( String[] args ){
    	 System.out.println( "It's OK" );
    	 User u = new User();
    	 u.create("Antoni45", 456123);
    	 u.create("El_pabo", 45123749);
    	 Controller controller = new Controller();
    	 controller.start_game();	
    	 controller.set_piece(1, 1, "WHITE");
    	 System.out.println("Score BLACK PIECES = "+controller.get_score().elementAt(0));
    	 System.out.println("Score WHITE PIECES = "+controller.get_score().elementAt(1));
    }
}
