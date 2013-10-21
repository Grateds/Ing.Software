package com.Grateds.Reversi;

import java.util.ArrayList;
import com.Grateds.Reversi.AI.AI;
import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.GUI.MainWindow;
import com.Grateds.Reversi.SAVEANDLOAD.SaveAndLoad;

public class App {

    public static void main( String[] args ){
    	 Controller controller = new Controller();
    	 controller.start_game();
    	 controller.drawBoard();
    	 System.out.println("===================");
    	 System.out.println("BLACK SCORE = "+controller.getBlackScore());
    	 System.out.println("WHITE SCORE = "+controller.getWhiteScore());
//    	 AI a = new AI();
//    	 ArrayList<Integer> list = a.findValidMove(controller.getBoard(), 2, false);
//    	 int i=0;
//    	 System.out.println("Possibles Valid Moves");
//    	 while(i<list.size()){
//    		 System.out.println("("+list.get(i)+","+list.get(i+1)+")");
//    		 i = i + 2;
//    	 }
    	 controller.set_piece(2,4,1);
    	 controller.drawBoard();
    	 System.out.println("===================");
    	 System.out.println("BLACK SCORE = "+controller.getBlackScore());
    	 System.out.println("WHITE SCORE = "+controller.getWhiteScore());
    	 controller.saveBoard();
    }
}