package com.Grateds.Reversi.CONTROLLER;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.GUI.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;

public class Controller {
	
	private Board table;
    private SaveAndLoad save;
	private AI solver;
	private boolean turn; // true -> player turn | false -> cpu turn
    
	public Controller(){
		table = new Board();
		solver = new AI();
		save = new SaveAndLoad();
		turn = true;
	} // end constructor
	
	public void initialization(){
		
	} // end initialization
	
	public void change_skin(){
		
	} // end change_skin
	
	public void reset_game() {
		start_game();
	} // end reset_game
		
	public void start_game(){
		table.initialization();
	} // end start_game
	
	public void set_piece(int x, int y, int piece){
		if (isValidMove(piece,x,y)) table.set(x, y, piece);
		solver.solve(table, piece, x, y);
	} // end set_piece
	
	public boolean isValidMove(int piece, int x, int y){
		return solver.isValidMove(table, piece, x, y);
	} // end isValidMove
	
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
		
	public void saveBoard(){	
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
	}
}
