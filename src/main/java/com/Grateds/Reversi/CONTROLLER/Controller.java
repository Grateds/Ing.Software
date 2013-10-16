package com.Grateds.Reversi.CONTROLLER;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.GUI.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
	
	private Board table;
    private MainWindow Window;
    private SaveAndLoad save;
	
	public Controller(){
		table = new Board();
		Window = new MainWindow();
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
		Window.drawBoard(table);
	} // end start_game
	
	public void set_piece(int x, int y, String piece){
		if (piece == "WHITE") table.set(x, y, 1);
		else table.set(x, y, 2);
	} // end set_piece
	
	public int getWhiteScore() {
		// Get white's score
		return table.get_score().elementAt(1);
	}// end getWhiteScore

	public int getBlackScore() {
		// Get black's score
		return table.get_score().elementAt(0);
	} // end getBlackScore

	public void update(Observable o, Object o1) {
	}
	
	public void saveBoard(){	
		save.saveBoard(table);
	} // end saveBoard
	
	public Board loadBoard(){
		return save.loadBoard();
	} // end loadBoard
}
