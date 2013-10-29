package com.Grateds.Reversi.AI;

import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.MODEL.Board;

import java.util.ArrayList;
import java.util.Random;

public class AI {
	
	private static final int[] sOFFSET_MOVE_ROW = {-1, -1, -1,  0,  0,  1,  1,  1}; // move offset for row 
	private static final int[] sOFFSET_MOVE_COL = {-1,  0,  1, -1,  1, -1,  0,  1}; // move offset for column	
	public static final int sSUGGEST_BLACK_PIECE = 2; // susggest piece for black 
	public static final int sSUGGEST_WHITE_PIECE = 1; // susggest piece for white 
	private static int sEMPTY_PIECE = 0;
	private static int sBLACK_PIECE = 2;
	private static int sWHITE_PIECE = 1;
	
	private Controller controller;
	private Board b;

	public AI(Controller c){
		controller = c;
		b = c.getBoard();
	} // end constructor
	
	/**
	 * Check whether a move is valid
	 * @param b, the board
	 * @param piece, the piece need to check
	 * @param row, row of the move
	 * @param col, column of the move
	 * @return true if the move is valid, false otherwise	
	 */
	public boolean isValidMove(int piece, int row, int col) {		
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
	public ArrayList<Integer> findValidMove(int piece) {
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j) {
				if (isValidMove(piece, i, j)){
					b.set_suggest(i, j, 1);
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
	public boolean findAtNorth(int piece, int x, int y){
		if(x==0 || b.get(x-1, y)==sEMPTY_PIECE) return false;
		else if(b.get(x-1, y)==piece) return true;
		else return findAtNorth(piece,x-1,y); // there is an opponent
	} // end findAtNorth
	
	/**
	 * piece = iece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtSouth(int piece, int x, int y){
		if(x==7 || b.get(x+1, y)==sEMPTY_PIECE) return false;
		else if(b.get(x+1, y)==piece) return true;
		else return findAtSouth(piece,x+1,y); // there is an opponent
	}
	
	/**
	 * piece = piece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtWest(int piece, int x, int y){
		if(y==0 || b.get(x, y-1)==sEMPTY_PIECE) return false;
		else if(b.get(x, y-1)==piece) return true;
		else return findAtWest(piece,x,y-1); // there is an opponent
	} // end findAtWest
	
	/**
	 * piece = piece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtEast(int piece, int x, int y){
		if(y==7 || b.get(x,y+1)==sEMPTY_PIECE) return false;
		else if(b.get(x,y+1)==piece) return true;
		else return findAtEast(piece,x,y+1); // there is an opponent
	} // end findAtEast
	
	/**
	 * piece = piece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtNE(int piece, int x, int y){
		if(x==0 || y==7 || b.get(x-1,y+1)==sEMPTY_PIECE) return false;
		else if(b.get(x-1,y+1)==piece) return true;
		else return findAtNE(piece,x-1,y+1); // there is an opponent
	} // end findAtNE

	/**
	 * piece = piece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtSE(int piece, int x, int y){
		if(x==7 || y==7 || b.get(x+1,y+1)==sEMPTY_PIECE) return false;
		else if(b.get(x+1,y+1)==piece) return true;
		else return findAtSE(piece,x+1,y+1); // there is an opponent
	} // end findAtSE
	
	/**
	 * piece = piece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtSW(int piece, int x, int y){
		if(x==7 || y==0 || b.get(x+1,y-1)==sEMPTY_PIECE) return false;
		else if(b.get(x+1,y-1)==piece) return true;
		else return findAtSW(piece,x+1,y-1); // there is an opponent
	} // end findAtSW
	
	/**
	 * piece = piece to find from the position (x,y)
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean findAtNW(int piece, int x, int y){
		if(x==0 || y==0 || b.get(x-1,y-1)==sEMPTY_PIECE) return false;
		else if(b.get(x-1,y-1)==piece) return true;
		else return findAtNW(piece,x-1,y-1); // there is an opponent
	} // end findAtNW
	
	/**
	 * 
	 * @param b
	 * @param piece
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isValid(int piece, int x, int y){
		return 	findAtNorth(piece,x,y) ||
				findAtSouth(piece,x,y) ||
				findAtEast(piece,x,y)  ||
				findAtWest(piece,x,y)  ||
				findAtNE(piece,x,y)	 ||
				findAtSE(piece,x,y)	 ||
				findAtNW(piece,x,y)	 ||
				findAtSW(piece,x,y);
	} // end isValid
	
	/**
	 * 
	 * @param b, the board
	 * @param piece
	 * @param x
	 * @param y
	 */
	public void solve(int piece, int x, int y){
		int oppPiece = (piece == sBLACK_PIECE) ? sWHITE_PIECE : sBLACK_PIECE;
		int auxRow = x;
		int auxCol = y;
		if (findAtNorth(piece,x,y)){
			while(b.get(auxRow-1, y)==oppPiece){
				b.set(auxRow-1, y, piece);
				auxRow--;
			}
		}
		if (findAtSouth(piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow+1, y)==oppPiece){
				b.set(auxRow+1, y, piece);
				auxRow++;
			}
		}
		if (findAtWest(piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(x, auxCol-1)==oppPiece){
				b.set(x, auxCol-1, piece);
				auxCol--;
			}
		}
		if (findAtEast(piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(x, auxCol+1)==oppPiece){
				b.set(x, auxCol+1, piece);
				auxCol++;
			}
		}
		if (findAtNE(piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow-1, auxCol+1)==oppPiece){
				b.set(auxRow-1, auxCol+1, piece);
				auxRow--;
				auxCol++;
			}
		}
		if (findAtSE(piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow+1, auxCol+1)==oppPiece){
				b.set(auxRow+1, auxCol+1, piece);
				auxRow++;
				auxCol++;
			}
		}
		if (findAtSW(piece,x,y)){
			auxRow = x;
			auxCol = y;
			while(b.get(auxRow+1, auxCol-1)==oppPiece){
				b.set(auxRow+1, auxCol-1, piece);
				auxRow++;
				auxCol--;
			}
		}
		if (findAtNW(piece,x,y)){
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
	public void simulation(Board b, ArrayList<Integer> pMoves){
//		ArrayList<Integer> pMoves = findValidMove(1);
		Random rand = new Random();
		int numRan; // random number to select a valid move
		if (pMoves.size() != 0) {
			numRan = rand.nextInt(pMoves.size());
			if ((numRan % 2) != 0) numRan--;
			controller.set_piece(pMoves.get(numRan), pMoves.get(numRan+1), sWHITE_PIECE);
			solve(sWHITE_PIECE, pMoves.get(numRan), pMoves.get(numRan+1));
		}
	} // end simulation
}
