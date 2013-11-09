package com.Grateds.Reversi.MODEL;

import java.util.Observable;
import java.util.Vector;

public class Board extends Observable implements Model{
	
	private final int BLACK_PIECE = 2; // represents black piece
	private final int WHITE_PIECE = 1; // represents white piece
	private final int EMPTY_PIECE = 0; // represents no-piece
	
	private int BLACK_SCORE=0; // score of black piece
	private int WHITE_SCORE=0; // score of white piece 
	
	private final int COL=8; // num of columns
	private final int ROW=8; // num of rows
	private Cell[][] board = null; // board of cells
	private int n_cell=0;  // num of busy cells
	
	public Board(){
		board = new Cell[ROW][COL];
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				board[j][i]= new Cell();
			}
		}
	} // end constructor
	
	public void reset(){
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				board[j][i]= new Cell();
			}
		}
		initialization();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void initialization() {
		board[3][3].set_value(WHITE_PIECE);
		board[4][4].set_value(WHITE_PIECE);
		board[4][3].set_value(BLACK_PIECE);
		board[3][4].set_value(BLACK_PIECE);
		n_cell = 4;
		BLACK_SCORE = 2;
		WHITE_SCORE = 2;
	} // end initialization

	public void set(int x, int y, int value){
		if (board[x][y].get_value()==EMPTY_PIECE){
			board[x][y].set_value(value);
			n_cell++;
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
		}
		resetSuggest();
		this.setChanged();
		this.notifyObservers();
	} // end set
	
	public void set_suggest(int x, int y, int value){
		board[x][y].suggest(value);	
	} // end set_suggest
	
	public int getSuggest(int x, int y){
		return board[x][y].get_suggest();
	} // end getSuggest
	
	public void resetSuggest(){
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				board[j][i].suggest(0);
			}
		}
	} // end resetSuggest
	
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
	
	public void change_board(Board b){
		reset();
		n_cell = 0;
		BLACK_SCORE = 0;
		WHITE_SCORE = 0;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if (b.get(i, j)==BLACK_PIECE){
					board[i][j].set_value(b.get(i, j));
					n_cell++;
					BLACK_SCORE++;
				}else if(b.get(i, j)==WHITE_PIECE){
					board[i][j].set_value(b.get(i, j));
					n_cell++;
					WHITE_SCORE++;
				}
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	public void set_load(int x, int y, int value){
		board[x][y].set_value(value);
	} // end set_load
}
