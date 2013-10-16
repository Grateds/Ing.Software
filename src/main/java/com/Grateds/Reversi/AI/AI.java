package com.Grateds.Reversi.AI;
import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.MODEL.Board;
import java.util.ArrayList;

public class AI {
	
	private static final int[] sOFFSET_MOVE_ROW = {-1, -1, -1,  0,  0,  1,  1,  1}; // move offset for row 
	private static final int[] sOFFSET_MOVE_COL = {-1,  0,  1, -1,  1, -1,  0,  1}; // move offset for column
	private static int sEMPTY_PIECE = 0;
	private static int sBLACK_PIECE = 2;
	private static int sWHITE_PIECE = 1;
	
	public AI(){
	} // end constructor
	
	 //Check whether a move is valid
	 //parameters: board the board-piece the piece need to check-row row of the move-col column of the move
	 //return: true if the move is valid, false otherwise
	 
	public static boolean isValidMove(Board b, int piece, int row, int col) {
		// pre: 1 <= piece <=2
		// pos: true if the move is valid, false otherwise		
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
		
}
