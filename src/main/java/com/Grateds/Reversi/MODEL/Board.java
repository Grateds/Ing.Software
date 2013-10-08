package com.Grateds.Reversi.MODEL;

public class Board implements Model{
	
	private final int COL=8;
	private final int ROW=8;
	private Cell[][] board;
	
	public void initialization() {
		board = new Cell[ROW][COL];  
	}
	
	public boolean valid_move(int x, int y){
		return false;
	}
	
	public boolean is_complete(){
		return false;
	}
}