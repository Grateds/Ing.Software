package com.Grateds.Reversi;

import com.Grateds.Reversi.AI.AI;
import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.GUI.MainWindow;
import com.Grateds.Reversi.MODEL.Board;

public class App {

    public static void main( String[] args ){
    	 Controller controller = new Controller();
    	 controller.start_game();
    	 controller.set_piece(2,4,1);
    	 controller.set_piece(3,4,1);
    	 controller.drawBoard();
    	 System.out.println("===============");
    	 System.out.println("Score BLACK PIECES = "+controller.getBlackScore());
    	 System.out.println("Score WHITE PIECES = "+controller.getWhiteScore());  
    	 System.out.println( "It's OK" );
    }
}




