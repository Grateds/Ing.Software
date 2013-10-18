package com.Grateds.Reversi.CONTROLLER;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.GUI.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;
import java.util.Observable;
import java.util.Observer;

public class Controller {
	
	private Board table;
//    private MainWindow Window;
    private SaveAndLoad save;
	
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
		// set state
		table.initialization();
		//Window.drawBoard(table);
		// get next move
	} // end start_game
	
	public void set_piece(int x, int y, String piece){
		if (piece == "WHITE") table.set(x, y, 1);
		else table.set(x, y, 2);
	} // end set_piece
	
	public Board getBoard(){
		return table;
	}
	
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
