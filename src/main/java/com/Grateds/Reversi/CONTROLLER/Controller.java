package com.Grateds.Reversi.CONTROLLER;

import java.util.Vector;

import com.Grateds.Reversi.GUI.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;

public class Controller {
	
	private Board table;
	
	public Controller(){
		table = new Board();
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
	
	public void set_piece(int x, int y, String piece){
		if (piece == "WHITE") table.set(x, y, 1);
		else table.set(x, y, 2);
	} // end set_piece
	
	public int getWhiteScore() {
    	// Get white's score
    	return table.get_score().elementAt(1);
    } // end getWhiteScore
       
    public int getBlackScore() {
    	// Get black's score
    	return table.get_score().elementAt(0);
    } // end getBlackScore
}