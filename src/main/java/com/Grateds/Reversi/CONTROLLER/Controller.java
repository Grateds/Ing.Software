package com.Grateds.Reversi.CONTROLLER;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;

public class Controller {
	
	private Board table;
    private SaveAndLoad save;
	private AI solver;
	private boolean turn; // true -> player turn | false -> cpu turn
	private int BLACK_PIECE = 2;
	private int WHITE_PIECE = 1;
	private Boolean runGame;	
	private ArrayList<Integer> blackValidMoves = new ArrayList<Integer>();
	private ArrayList<Integer> whiteValidMoves = new ArrayList<Integer>();
	
	public Controller(){
		table = new Board();
		solver = new AI(this);
		save = new SaveAndLoad();
		turn = true;
		runGame = true;
		blackValidMoves.add(2); // just for init
	} // end constructor
	
	public void initialization(){
		table.initialization();
	} // end initialization
        
        public void reset_game() {
		table.reset();
		initialization();
		turn = true;
	} // end reset_game
     
	public void start_game() throws InterruptedException{
		boolean win = true;
		boolean loose = true;
		boolean draw = true;
		
		while (!game_over() || runGame){
			if(!turn || (turn && blackValidMoves.size()==0)){
				TimeUnit.SECONDS.sleep(1);
				update_whiteValidMoves();
				cpu_move(whiteValidMoves);
				setTurn(true);
			}
			update_blackValidMoves();
            // Player turn
            if(game_over()){
            	if(getBlackScore()>getWhiteScore() && win){
//            		JOptionPane.showMessageDialog(null, "YOU WIN");
//            		win = false;
            	}else if (getBlackScore()<getWhiteScore() && loose) {
//            		JOptionPane.showMessageDialog(null, "CPU WINS");
//            		loose = false;
            	}else if(getBlackScore()==getWhiteScore() && draw){
//            		JOptionPane.showMessageDialog(null, "DRAW");
//            		draw = false;
            	}
            }
		}
	} // end start_game
	
	public boolean game_over(){
		return table.is_complete() || getWhiteScore()==0 || getBlackScore() == 0;
	}
	
	public void update_blackValidMoves(){
		blackValidMoves = solver.findValidMove(BLACK_PIECE);
	}
	
	public void update_whiteValidMoves(){
		whiteValidMoves = solver.findValidMove(WHITE_PIECE);
	}
	
	public boolean set_piece(int x, int y, int piece){
		if (isValidMove(piece,x,y)){
			table.set(x, y, piece);
			solver.solve(piece, x, y);
			if (piece == BLACK_PIECE) turn = false;
			else turn = true;
			System.out.println("in set_piece -> turn = "+turn);
			return true;           // succesful
		}else return false;       // not possible
	} // end set_piece
	
	public boolean isValidMove(int piece, int x, int y){
		return solver.isValidMove(piece, x, y);
	} // end isValidMove
	
	public void cpu_move(ArrayList<Integer> playerMoves){
		solver.simulation(table,playerMoves);
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
		
	public void saveBoard(Board b){  
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
	} // end drawBoard
	
	public void setBoard(Board board){	
		table.reset();
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				table.set(i, j, board.get(i, j));
			}
		}
	} // end setBoard
	
    public void quitGame() {
        System.exit(0);
    } // end quitGame
}
