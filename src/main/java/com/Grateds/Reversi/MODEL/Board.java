package com.Grateds.Reversi.MODEL;

public class Board implements Model{
	
	private final int COL=8; // num of columns
	private final int ROW=8; // num of rows
	private Cell[][] board = null;  //board of cells
	private int n_cell=0;  // num of busy cells
	
	public Board(){
		board = new Cell[ROW][COL];
		initialization();
		board[3][3].set_value(1);
		board[4][4].set_value(1);
		board[4][3].set_value(2);
		board[3][4].set_value(2);
		n_cell = 4;
	} // end constructor
	
	public void initialization() {
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				board[i][j]= new Cell();
			}
		}
	} // end initialization
	
	public void set(int x, int y, int value){
		board[y][x].set_value(value);
		n_cell++;
	} // end set
	
	public int get(int x, int y){
		return board[y][x].get_value();
	} // end get
	
	public boolean valid_move(int x, int y){
		return board[y][x].is_settable();
	} // end valid_move
	
	public boolean is_complete(){
		return n_cell==ROW*COL;
	} // end is_complete
}