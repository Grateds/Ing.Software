package com.Grateds.Reversi.MODEL;

public class Board implements Model{
	
	public static final int sBOARD_SIZE = 8; // number of rows 
	
	public static final int sBLACK_PIECE = 2; // piece represents black 
	
	public static final int sWHITE_PIECE = 1; // piece represents white 
	
	public static final int sEMPTY_PIECE = 0; // empty piece 
	
	private int mBlackScore; // score of black piece
	
	private int mWhiteScore; // score of white piece 
	
	private final int COL=8; // num of columns
	private final int ROW=8; // num of rows
	private Cell[][] board = null; // board of cells
	private int n_cell=0;  // num of busy cells
	
	public Board(){
		board = new Cell[ROW][COL];
		initialization();
		board[3][3].set_value(1);
		board[4][4].set_value(1);
		board[4][3].set_value(2);
		board[3][4].set_value(2);
		n_cell = 4;
		mBlackScore = 2;
		mWhiteScore = 2;
	} // end constructor
	
	public void initialization() {
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				board[i][j]= new Cell();
			}
		}
	} // end initialization

	public void set(int x, int y, int value){
		board[x][y].set_value(value);
		n_cell++;
	} // end set
	
	public int get(int x, int y){
		return board[x][y].get_value();
	} // end get
	
	public boolean valid_move(int x, int y){
		return board[x][y].is_settable();
	} // end valid_move
	
	public boolean is_complete(){
		return n_cell==ROW*COL;
	} // end is_complete
	
	public void draw() {
		for(int i=0; i<COL; i++){
			for(int j=0; j<ROW; j++){
				System.out.print(board[i][j].get_value()+" ");
			}
			System.out.println();
		}
	} // end draw
	
	public void reset_game() {
		// reset board
		initialization();
	    board[3][3].set_value(1);
		board[4][4].set_value(1);
		board[4][3].set_value(2);
		board[3][4].set_value(2);
		n_cell = 4;
		mBlackScore = 2;
		mWhiteScore = 2;
	} // end reset_game
		
	public void start_game(){
		// new game 
		reset_game();
	} // end start_game
	
	public void calScore() {
		// Calculate score 
		int mBlackScore = 0;
		int mWhiteScore = 0;
		for (int i = 0; i < sBOARD_SIZE; ++i)
			for (int j = 0; j < sBOARD_SIZE; ++j){
				if (board[i][j].get_value() == sBLACK_PIECE)
					++mBlackScore;
				else if (board[i][j].get_value() == sWHITE_PIECE)
					++mWhiteScore;
			}
	} // end calScore	
	
	public int getWhiteScore() {
    	// Get white's score
    	return mWhiteScore;
    } // end getWhiteScore
       
    public int getBlackScore() {
    	// Get black's score
    	return mBlackScore;
    } // end getBlackScore
}
