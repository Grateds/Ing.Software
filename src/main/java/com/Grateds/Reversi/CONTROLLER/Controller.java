package com.Grateds.Reversi.CONTROLLER;

import java.util.ArrayList;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;

public class Controller {
	
	private Board table;
    private SaveAndLoad save;
	private AI solver;
	private boolean turn; // true -> player turn | false -> cpu turn
	private int BLACK_PIECE = 2;
	private int WHITE_PIECE = 1;
	
	private ArrayList<Integer> whiteValidMoves;
	private ArrayList<Integer> blackValidMoves;
	
	
	public Controller(){
		table = new Board();
		solver = new AI(this);
		save = new SaveAndLoad();
		turn = true;
	} // end constructor
	
	public void initialization(){
		table.initialization();
	} // end initialization
	
	public void change_skin(){
		
	} // end change_skin
	
	public void reset_game() {
		initialization();
	} // end reset_game
		
	public void start_game(){
		while (!game_over()){  
			if(!turn || (turn && solver.findValidMove(BLACK_PIECE, false).size()==0)){
	       		 setTurn(cpu_move());
	       		 if(!turn) System.out.println("PASS");
			}
	   	}
		System.out.println("GAME OVER");
	   	if(getBlackScore()>getWhiteScore()) System.out.println("YOU WIN!");
	   	else if (getBlackScore()<getWhiteScore()) System.out.println("CPU WIN!");
	   	else System.out.println("= DRAW =");
	} // end start_game
	
	public boolean game_over(){
		return table.is_complete() || getWhiteScore()==0 || getBlackScore() == 0;
	}
	
	public boolean set_piece(int x, int y, int piece){
		if (isValidMove(piece,x,y)){
			table.set(x, y, piece);
			solver.solve(piece, x, y);
			if (piece == BLACK_PIECE) turn = false;
			else turn = true;
			System.out.println("in set_piece -> turn = "+turn);
			System.out.println("BLACK SCORE = "+getBlackScore());
	   	    System.out.println("WHITE SCORE = "+getWhiteScore());
			return true;           // succesful
		}else return false;       // it can't be possible
	} // end set_piece
	
	public boolean isValidMove(int piece, int x, int y){
		return solver.isValidMove(piece, x, y);
	} // end isValidMove
	
	public void manager(){
		if (!turn){  // CPU turn
			whiteValidMoves = solver.findValidMove(WHITE_PIECE, false);
			if (whiteValidMoves.size()==0) turn = true;
		}else{      // Player turn
			blackValidMoves = solver.findValidMove(BLACK_PIECE, false);
			if (blackValidMoves.size()==0) turn = false;
		}
	}
	
	public boolean cpu_move(){
		return solver.simulation(table);
	} // end cpu_move
	
	public Board getBoard(){
		// Get current table
		return table;
	} // end getBoard
	
	public int getWhiteScore() {
		// Get white's score
		return table.get_score().elementAt(1);
	}// end getWhiteScore

	public int getBlackScore() {
		// Get black's score
		return table.get_score().elementAt(0);
	} // end getBlackScore
	
	public boolean getTurn(){
		return turn;
	} // end getTurn
	
	public void setTurn(boolean new_turn){
		turn = new_turn;
	} // end setTurn
		
	public void saveBoard(Board b){  // Le agregue pase la tabla como parametro (Board table). 2013/10/25
		save.saveBoard(table);
	} // end saveBoard
	
	public Board loadBoard(){
		return save.loadBoard();
	} // end loadBoard
	
	public void drawBoard(){
		System.out.println("    0 1 2 3 4 5 6 7");
		System.out.println("    ---------------");
		for(int i=0; i<8; i++){
			System.out.print(i+" | ");
			for(int j=0; j<8; j++){
				System.out.print(table.get(i, j)+" ");
			}
			System.out.println("");
		}
	} // end drawBoard
	
    public void quitGame() {
        System.exit(0);
    } // end quitGame
}
