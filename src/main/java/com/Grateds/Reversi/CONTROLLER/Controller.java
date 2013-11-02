package com.Grateds.Reversi.CONTROLLER;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.GUI.NewWinner;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;

public class Controller {
	
	private Board table;
    private SaveAndLoad save;
	private AI solver;
	private boolean turn; // true -> player turn | false -> cpu turn
	private int BLACK_PIECE = 2;
	private int WHITE_PIECE = 1;
	private int BLACK_SCORE;
	private int WHITE_SCORE;
	private Boolean runGame;	
	private Boolean stopped;
	public Boolean finishMoveCPU;
	public Boolean finishMovePlayer;
	private int totalScore;
	private ArrayList<Integer> blackValidMoves = new ArrayList<Integer>();
	private ArrayList<Integer> whiteValidMoves = new ArrayList<Integer>();
	
	public Controller(){
		table = new Board();
		solver = new AI(this);
		save = new SaveAndLoad();
		turn = true;
		totalScore = 0;
		runGame = true;
		stopped = false;
		finishMoveCPU = true;
		finishMovePlayer = true;
		blackValidMoves.add(2); // just for init
	} // end constructor
	
	public void initialization(){
		table.reset();
	} // end initialization
        
    public void reset_game(){
		initialization();
		turn = true;
		stopped = false;
		update_blackValidMoves();
	} // end reset_game
     
	public void start_game(){
		boolean win = true;
		boolean loose = true;
		boolean draw = true;
		
		while (!game_over() || runGame){
//			if( !stopped && (!turn || (turn && blackValidMoves.size()==0))){
			if(!turn && finishMovePlayer && !stopped || (turn && blackValidMoves.size()==0)){
				not_done_moveCPU();
				update_whiteValidMoves();
				cpu_move(whiteValidMoves);
				setTurn(true);
				done_moveCPU();
			}
            // Player turn
            if(game_over() && finishMovePlayer && finishMoveCPU){
            	if(getBlackScore()>getWhiteScore() && win){
            		JOptionPane.showMessageDialog(null, "YOU WIN");
            		NewWinner winer = new NewWinner(this);
            		win = false;
            	}else if (getBlackScore()<getWhiteScore() && loose) {
            		JOptionPane.showMessageDialog(null, "CPU WINS");
            		loose = false;
            	}else if(getBlackScore()==getWhiteScore() && draw){
            		JOptionPane.showMessageDialog(null, "DRAW");
            		draw = false;
            	}
            }
		}
	} // end start_game
	
	public boolean game_over(){
		return table.is_complete()  || 
				WHITE_SCORE ==0      || 
				BLACK_SCORE == 0     || 
				(blackValidMoves.size()==0 && whiteValidMoves.size()==0);
	} // end game_over
	
	public void update_blackValidMoves(){
		blackValidMoves = solver.findValidMove(BLACK_PIECE);
	} // end update_blackValidMoves
	
	public void update_whiteValidMoves(){
		whiteValidMoves = solver.findValidMove(WHITE_PIECE);
	} // end update_whiteValidMoves
	
	public void done_moveCPU(){
		finishMoveCPU = true;
	} 
	
	public void not_done_moveCPU(){
		finishMoveCPU = false;
	}
	
	public void done_movePlayer(){
		finishMovePlayer = true;
	} 
	
	public void not_done_movePlayer(){
		finishMovePlayer = false;
	}
	
	public void stop(){
		stopped = true;
	} 
	
	public void resume(){
		stopped = false;
	}
	
	public boolean set_piece(int x, int y, int piece){
		if (isValidMove(piece,x,y)){
			table.set(x, y, piece);
			if (piece == BLACK_PIECE) turn = false;
			else turn = true;
			solver.solve(piece, x, y);
			return true;// succesful
		}else return false;
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
	
	public void update_totalScore(){
		totalScore = (BLACK_SCORE-WHITE_SCORE)*324;
	}
	
	public int get_totalScore(){
		return totalScore;
	}
	
	public void get_scores(){
		Vector<Integer> v =	table.get_score();
		BLACK_SCORE = v.get(0);
		WHITE_SCORE = v.get(1);
	}
	
	public int getWhiteScore() { 
		return WHITE_SCORE;
	}// end getwhitescore 

	public int getBlackScore() {  
		return BLACK_SCORE;
	} // endgetblackscore
	
	public void setBoard(Board board){	
		table.change_board(board);
	} // end setBoard

		 public void reset_game_first(boolean b){ 
		  initialization();
		  turn = b;
		  stopped = false;
		  if (b) update_blackValidMoves();
		  else update_whiteValidMoves();
	 } // reset_game_first
}
