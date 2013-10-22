package com.Grateds.Reversi.AI;

import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.MODEL.Board;
import com.Grateds.Reversi.MODEL.Cell;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Random;

public class AI {
	
	private static final int[] sOFFSET_MOVE_ROW = {-1, -1, -1,  0,  0,  1,  1,  1}; // move offset for row 
	private static final int[] sOFFSET_MOVE_COL = {-1,  0,  1, -1,  1, -1,  0,  1}; // move offset for column	
	public static final int sSUGGEST_BLACK_PIECE = 2; // susggest piece for black 
	public static final int sSUGGEST_WHITE_PIECE = 1; // susggest piece for white 
	private static int sEMPTY_PIECE = 0;
	private static int sBLACK_PIECE = 2;
	private static int sWHITE_PIECE = 1;

	public AI(){
		
	} // end constructor
	
	/**
	 * Check whether a move is valid
	 * @param b, the board
	 * @param piece, the piece need to check
	 * @param row, row of the move
	 * @param col, column of the move
	 * @return true if the move is valid, false otherwise	
	 */
	public boolean isValidMove(Board b, int piece, int row, int col) {		
		if (b.get(row, col) != sEMPTY_PIECE) // check whether this square is empty
			return false;		
		int oppPiece = (piece == sBLACK_PIECE) ? sWHITE_PIECE : sBLACK_PIECE;
		boolean isValid = false;
		// check 8 directions
		for (int i = 0; i < 8; ++i) {
			int curRow = row + sOFFSET_MOVE_ROW[i];
			int curCol = col + sOFFSET_MOVE_COL[i];
			boolean hasOppPieceBetween = false;
			while (curRow >=0 && curRow < 8 && curCol >= 0 && curCol < 8) {	
				if (b.get(curRow, curCol) == oppPiece)
					hasOppPieceBetween = true;
				else if ((b.get(curRow,curCol) == piece) && hasOppPieceBetween)
				{
					isValid = true;
					break;
				}
				else
					break;
				curRow += sOFFSET_MOVE_ROW[i];
				curCol += sOFFSET_MOVE_COL[i];
			}
			if (isValid)
				break;
		}
		return isValid;
	} // end isValidMove
	
	/**
	 * Finds valid moves for specific piece
	 * @param b, the board
	 * @param piece, piece the piece need to find move
	 * @param isSuggest, true to indicate suggested pieces on the board
	 * @return return an array list of moves
	 */	 
	public ArrayList<Integer> findValidMove(Board b, int piece, boolean isSuggest) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j) {
	
				if (isValidMove(b,piece, i, j)){
					moveList.add(i);
					moveList.add(j);
				}
			}
		return moveList;
	} // end findValidMove
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtNorth(Board b, int piece, int x, int y){
		if(x==0 || b.get(x-1, y)==sEMPTY_PIECE) return false;
		else if(b.get(x-1, y)==piece) return true;
		else return findAtNorth(b,piece,x-1,y); // there is an opponent
	} // end findAtNorth
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtSouth(Board b, int piece, int x, int y){
		if(x==7 || b.get(x+1, y)==sEMPTY_PIECE) return false;
		else if(b.get(x+1, y)==piece) return true;
		else return findAtSouth(b,piece,x+1,y); // there is an opponent
	}
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtWest(Board b, int piece, int x, int y){
		if(y==0 || b.get(x, y-1)==sEMPTY_PIECE) return false;
		else if(b.get(x, y-1)==piece) return true;
		else return findAtWest(b,piece,x,y-1); // there is an opponent
	} // end findAtWest
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtEast(Board b, int piece, int x, int y){
		if(y==7 || b.get(x,y+1)==sEMPTY_PIECE) return false;
		else if(b.get(x,y+1)==piece) return true;
		else return findAtEast(b,piece,x,y+1); // there is an opponent
	} // end findAtEast
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtNE(Board b, int piece, int x, int y){
		if(x==0 || y==7 || b.get(x-1,y+1)==sEMPTY_PIECE) return false;
		else if(b.get(x-1,y+1)==piece) return true;
		else return findAtNE(b,piece,x-1,y+1); // there is an opponent
	} // end findAtNE

	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtSE(Board b, int piece, int x, int y){
		if(x==7 || y==7 || b.get(x+1,y+1)==sEMPTY_PIECE) return false;
		else if(b.get(x+1,y+1)==piece) return true;
		else return findAtSE(b,piece,x+1,y+1); // there is an opponent
	} // end findAtSE
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtSW(Board b, int piece, int x, int y){
		if(x==7 || y==0 || b.get(x+1,y-1)==sEMPTY_PIECE) return false;
		else if(b.get(x+1,y-1)==piece) return true;
		else return findAtSW(b,piece,x+1,y-1); // there is an opponent
	} // end findAtSW
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	// piece = piece to find from the position (x,y)
	public boolean findAtNW(Board b, int piece, int x, int y){
		if(x==0 || y==0 || b.get(x-1,y-1)==sEMPTY_PIECE) return false;
		else if(b.get(x-1,y-1)==piece) return true;
		else return findAtNW(b,piece,x-1,y-1); // there is an opponent
	} // end findAtNW
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isValid(Board b, int piece, int x, int y){
		return findAtNorth(b,piece,x,y) ||
				findAtSouth(b,piece,x,y) ||
				findAtEast(b,piece,x,y)  ||
				findAtWest(b,piece,x,y)  ||
				findAtNE(b,piece,x,y)	 ||
				findAtSE(b,piece,x,y)	 ||
				findAtNW(b,piece,x,y)	 ||
				findAtSW(b,piece,x,y);
	} // end isValid
	
	public void solve(Board b, int piece, int x, int y){
		int oppPiece = (piece == sBLACK_PIECE) ? sWHITE_PIECE : sBLACK_PIECE;
		int auxRow = x;
		int auxCol = y;
		if (findAtNorth(b,piece,x,y)){
			while(b.get(auxRow-1, y)==oppPiece){
				b.set(auxRow-1, y, piece);
				auxRow--;
			}
		}
		if (findAtSouth(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow+1, y)==oppPiece){
				b.set(auxRow+1, y, piece);
				auxRow++;
			}
		}
		if (findAtWest(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(x, auxCol-1)==oppPiece){
				b.set(x, auxCol-1, piece);
				auxCol--;
			}
		}
		if (findAtEast(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(x, auxCol+1)==oppPiece){
				b.set(x, auxCol+1, piece);
				auxCol++;
			}
		}
		if (findAtNE(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow-1, auxCol+1)==oppPiece){
				b.set(auxRow-1, auxCol+1, piece);
				auxRow--;
				auxCol++;
			}
		}
		if (findAtSE(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow+1, auxCol+1)==oppPiece){
				b.set(auxRow+1, auxCol+1, piece);
				auxRow++;
				auxCol++;
			}
		}
		if (findAtSW(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow+1, auxCol-1)==oppPiece){
				b.set(auxRow+1, auxCol-1, piece);
				auxRow++;
				auxCol--;
			}
		}
		if (findAtNW(b,piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow-1, auxCol-1)==oppPiece){
				b.set(auxRow-1, auxCol-1, piece);
				auxRow--;
				auxCol--;
			}
		}
	} // end solve
	
	/**  
	 * Simulates a cpu move
	 * @param b, the board
	 * @return boolean
	 */	
	public boolean simulation(Board b){
		ArrayList<Integer> pMoves = findValidMove(b,1,false);
		Random rand = new Random();
		int numRan; // random number to select a valid move
		if (pMoves.size() == 0) return false;
		else{
			numRan = rand.nextInt(pMoves.size());
			if ((numRan % 2) != 0) numRan--;
			b.set(pMoves.get(numRan), pMoves.get(numRan+1), 1);
			solve(b, 1, pMoves.get(numRan), pMoves.get(numRan+1));
			return true;
		}
	} // end simulation
}