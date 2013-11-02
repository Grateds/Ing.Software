package com.Grateds.Reversi.CONTROLLER;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.Grateds.Reversi.SAVEANDLOAD.*;
import com.Grateds.Reversi.GUI.NewWinner;
import com.Grateds.Reversi.MODEL.*;
import com.Grateds.Reversi.AI.*;

public class Controller {
	
	private Board table;
    private SaveAndLoad save;
	private AI solver;
	private int BLACK_PIECE = 2;
	private int WHITE_PIECE = 1;
	private boolean CPU_TURN;
	private boolean PLAYER_TURN;
	private int PLAYER_PIECE;
	private int CPU_PIECE;
	private int BLACK_SCORE;
	private int WHITE_SCORE;
	private Boolean runGame;	
	private Boolean stopped;
	public Boolean finishMoveCPU;
	public Boolean finishMovePlayer;
	private int totalScore;
	private ArrayList<Integer> cpuValidMoves = new ArrayList<Integer>();
	private ArrayList<Integer> playerValidMoves = new ArrayList<Integer>();
	
	public Controller(){
		table = new Board();
		solver = new AI(this);
		save = new SaveAndLoad();
		PLAYER_PIECE = 2;
		PLAYER_TURN = true;
		totalScore = 0;
		runGame = true;
		stopped = false;
		finishMoveCPU = true;
		finishMovePlayer = true;
		playerValidMoves.add(2);
	} // end constructor
	
	public void initialization(){
		table.reset();
	} // end initialization
    
    public void reset_game(int player_piece){ 
		initialization();
		stopped = false;
		PLAYER_PIECE = player_piece;
		CPU_PIECE = (player_piece == BLACK_PIECE) ? WHITE_PIECE : BLACK_PIECE;
		if(CPU_PIECE == 1){
			PLAYER_TURN = true;
			CPU_TURN = false;
		}else {
			PLAYER_TURN = false;
			CPU_TURN = true;
		}
	} // reset_game_first_computer
    
	public void start_game(int cpu_piece) throws InterruptedException{
		boolean win = true;
		boolean loose = true;
		boolean draw = true;
		CPU_PIECE = cpu_piece;
		PLAYER_PIECE = (cpu_piece == BLACK_PIECE) ? WHITE_PIECE : BLACK_PIECE;
		if(CPU_PIECE == 1){
			PLAYER_TURN = true;
			CPU_TURN = false;
		}else {
			PLAYER_TURN = false;
			CPU_TURN = true;
		}
		while (!game_over() || runGame){
			TimeUnit.SECONDS.sleep(1);
			get_scores();
			if(CPU_TURN && finishMovePlayer && !stopped || (PLAYER_TURN && solver.findValidMove(PLAYER_PIECE).size()==0)){
				not_done_moveCPU();
				update_validMoves(CPU_PIECE);
				cpu_move(cpuValidMoves, CPU_PIECE);
				update_validMoves(PLAYER_PIECE);
				setPlayerTurn();
				done_moveCPU();
			}
			
            // Player turn
            if(game_over() && finishMovePlayer && finishMoveCPU){
            	if(PLAYER_PIECE == BLACK_PIECE && getBlackScore()>getWhiteScore() && win){
            		JOptionPane.showMessageDialog(null, "YOU WIN");
            		NewWinner winer = new NewWinner(this);
            		win = false;
            	}else if (PLAYER_PIECE == WHITE_PIECE && getBlackScore()<getWhiteScore() && win){
            		JOptionPane.showMessageDialog(null, "YOU WIN");
            		NewWinner winer = new NewWinner(this);
            		win = false;
            	}else if (PLAYER_PIECE == BLACK_PIECE && getBlackScore()<getWhiteScore() && loose) {
            		JOptionPane.showMessageDialog(null, "CPU WINS");
            		loose = false;
            	}else if (PLAYER_PIECE == WHITE_PIECE && getBlackScore()>getWhiteScore() && loose){
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
				(cpuValidMoves.size()==0 && playerValidMoves.size()==0);
	} // end game_over
	
	public void update_validMoves(int current_piece){
		if (current_piece == CPU_PIECE)	cpuValidMoves = solver.findValidMove(CPU_PIECE);
		else cpuValidMoves = solver.findValidMove(PLAYER_PIECE);
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
			solver.solve(piece, x, y);
			return true;// succesful
		}else return false;
	} // end set_piece
	
	public boolean isValidMove(int piece, int x, int y){
		return solver.isValidMove(piece, x, y);
	} // end isValidMove
	
	public void cpu_move(ArrayList<Integer> playerMoves, int piece){
		solver.simulation(table,playerMoves, piece);
	} // end cpu_move
	
	public Board getBoard(){
		// Get current table
		return table;
	} // end getBoard
	
	public int get_playerPiece(){
		return PLAYER_PIECE;
	}
	
	public void setPlayerTurn(){
		PLAYER_TURN = true;
		CPU_TURN = false;
	} // end setTurn
	
	public void setCpuTurn(){
		CPU_TURN = true;
		PLAYER_TURN = false;
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
		if (PLAYER_PIECE == BLACK_PIECE) totalScore = (BLACK_SCORE-WHITE_SCORE)*324;
		else totalScore = (WHITE_SCORE-BLACK_SCORE)*324;
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
}
