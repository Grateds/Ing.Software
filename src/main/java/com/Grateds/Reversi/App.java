package com.Grateds.Reversi;

import java.util.ArrayList;
import java.util.Scanner;

import com.Grateds.Reversi.AI.AI;
import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.GUI.MainWindow;
import com.Grateds.Reversi.SAVEANDLOAD.SaveAndLoad;

public class App {

    public static void main( String[] args ){
    	 Controller controller = new Controller();
//    	 controller.start_game();
//    	 Scanner in = new Scanner(System.in);
//    	 int row;
//    	 int col;
//    	 while (!controller.game_over()){ // AGREGAR CASO DONDE NO HAY MAS MOVIMIENTOS
//    		 System.out.println("=====================");
//        	 System.out.print("BLACK = "+controller.getBlackScore()+" | ");
//        	 System.out.println("WHITE = "+controller.getWhiteScore());
//        	 System.out.println("=====================");
//    		 controller.drawBoard();
//        	 System.out.println("=====================");
//        	 if(controller.getTurn()){
//        		 System.out.print("ROW = ");row = in.nextInt();
//        		 System.out.print("COL = ");col = in.nextInt();
//        		 controller.set_piece(row, col, 2);
//        		 controller.setTurn(false);
//        	 }else{
//        		 controller.setTurn(controller.cpu_move());
//        	 }
//    	 }
//    	 if(controller.getBlackScore()>controller.getWhiteScore()) System.out.println("YOU WIN!");
//    	 else if (controller.getBlackScore()<controller.getWhiteScore()) System.out.println("CPU WIN!");
//    	 else System.out.println("= DRAW =");
    	
    	
//    	 controller.drawBoard();
//    	 System.out.println("===================");
//    	 System.out.println("BLACK SCORE = "+controller.getBlackScore());
//    	 System.out.println("WHITE SCORE = "+controller.getWhiteScore());
//    	 AI a = new AI();
//    	 ArrayList<Integer> list = a.findValidMove(controller.getBoard(), 2, false);
//    	 int i=0;
//    	 System.out.println("Possibles Valid Moves");
//    	 while(i<list.size()){
//    		 System.out.println("("+list.get(i)+","+list.get(i+1)+")");
//    		 i = i + 2;
//    	 }
//    	 controller.set_piece(5,4,2);
//    	 controller.drawBoard();
//    	 System.out.println("===================");
//    	 System.out.println("BLACK SCORE = "+controller.getBlackScore());
//    	 System.out.println("WHITE SCORE = "+controller.getWhiteScore());
//    	 
//    	 controller.cpu_move();
//    	 controller.drawBoard();
//    	 System.out.println("===================");
//    	 System.out.println("BLACK SCORE = "+controller.getBlackScore());
//    	 System.out.println("WHITE SCORE = "+controller.getWhiteScore());
    	MainWindow window = new MainWindow(controller);
    }
}