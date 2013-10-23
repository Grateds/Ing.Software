package com.Grateds.Reversi.MODEL;

import java.util.Observable;
import java.util.Vector;

public class Board extends Observable{
	
	private final int BLACK_PIECE = 2; // represents black piece
	private final int WHITE_PIECE = 1; // represents white piece
	private final int EMPTY_PIECE = 0; // represents no-piece
	
	private int BLACK_SCORE; // score of black piece
	private int WHITE_SCORE; // score of white piece 
	
	private final int COL=8; // num of columns
	private final int ROW=8; // num of rows
	private Cell[][] board = null; // board of cells
	private int n_cell=0;  // num of busy cells
	
	public Board(){
		board = new Cell[ROW][COL];
	} // end constructor
	
	public void initialization() {
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				board[j][i]= new Cell();
			}
		}
		board[3][3].set_value(WHITE_PIECE);
		board[4][4].set_value(WHITE_PIECE);
		board[4][3].set_value(BLACK_PIECE);
		board[3][4].set_value(BLACK_PIECE);
		n_cell = 4;
		BLACK_SCORE = 2;
		WHITE_SCORE = 2;
		this.setChanged();
		this.notifyObservers();
	} // end initialization

	public void set(int x, int y, int value){
		if (board[x][y].get_value()==EMPTY_PIECE){
			board[x][y].set_value(value);
			if (value == WHITE_PIECE) ++WHITE_SCORE;
			else ++BLACK_SCORE;
		}else if (board[x][y].get_value()==WHITE_PIECE){
			board[x][y].set_value(value);
			WHITE_SCORE--;
			BLACK_SCORE++;
		}else{
			board[x][y].set_value(value);
			WHITE_SCORE++;
			BLACK_SCORE--;
			n_cell++;
		}
		this.setChanged();
		this.notifyObservers();
	} // end set
	
	public int get(int x, int y){
		return board[x][y].get_value();
	} // end get
	
	public boolean is_complete(){
		return n_cell==ROW*COL;
	} // end is_complete
		
	public Vector<Integer> get_score() {
		Vector<Integer> v = new Vector<Integer>();
		v.add(BLACK_SCORE);
		v.add(WHITE_SCORE);
		return v;		
	} // end calScore	
}
