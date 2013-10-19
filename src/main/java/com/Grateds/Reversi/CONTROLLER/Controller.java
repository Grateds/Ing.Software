package com.Grateds.Reversi.CONTROLLER;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.GUI.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;
import java.util.Observable;
import java.util.Observer;

public class Controller {
	
	private Board table;
    private SaveAndLoad save;
	private AI solver;
    
	public Controller(){
		table = new Board();
	} // end constructor
	
	public void initialization(){
		
	} // end initialization
	
	public void change_skin(){
		
	} // end change_skin
	
	public void reset_game() {
		table.initialization();
	} // end reset_game
		
	public void start_game(){
		table.initialization();
	} // end start_game
	
	public void set_piece(int x, int y, int piece){
		 table.set(x, y, piece);
	} // end set_piece
	
	public boolean isValidMove(Board b, int piece, int x, int y){
		return solver.isValidMove(b, piece, x, y);
	}
	
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
	
	public void drawBoard(){
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				System.out.print(table.get(i, j)+" ");
			}
			System.out.println("");
		}
	}
	
	public void saveBoard(){	
		save.saveBoard(table);
	} // end saveBoard
	
	public Board loadBoard(){
		return save.loadBoard();
	} // end loadBoard
}
