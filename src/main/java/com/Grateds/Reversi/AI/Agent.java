package com.Grateds.Reversi.AI;

import com.Grateds.Reversi.MODEL.Board;

public interface Agent {
	
//	  Method to make a move. game state is stored in the class variables
//	  Method for you to implement. You want to make your modifications here.
//	  Agent: return Returns a move.
	
	MoveCoord findMove(Board b, int piece);

	//class that implements a pair of integer coordinates 
	public class MoveCoord {
		private int row;
		private int col;

		//constructor for a Pair of coordinates
		public MoveCoord(int row, int col) {
			this.row = row;
			this.col = col;
		} // end MoveCoord
	
		public int getRow() { 
			// accessor methods 
			return this.row;
		} // end getRow

		public int getCol() {
			return this.col;
		} // end getCol

		public void setRow(int row) { 
			// mutation methods 
			this.row = row;
		} // end setRow

		public void setCol(int col) {
			this.col = col;
		} // end setCol
	
		public static String encode(int row, int col) {
			// takes a pair of x,y coordinates, converts to standard board notation 
			return ("" + new Character((char) ('A' + col)) + (row + 1));
		} // end encode
	}

	//Class for presenting the move and the score together
	public class MoveScore implements Comparable<MoveScore>{
		private MoveCoord move ;
	    private int score ;
	    
	    public MoveScore(MoveCoord move, int score){
	        this.move = move;
	        this.score = score;
	    } // end MoveScore
	    
	    public int getScore(){ 
	    	return score ;
	    } // end getScore
	    
	    public MoveCoord getMove(){ 
		  	return move ;
	   } // end getMove

		public int compareTo(MoveScore o) {
			if(o.score > this.score)
				return 1;
			else if (o.score < this.score)
				return -1;
			else
				return 0;
		} // end compareTo
	}
}
