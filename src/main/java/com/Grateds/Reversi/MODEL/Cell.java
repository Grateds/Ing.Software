package com.Grateds.Reversi.MODEL;

public class Cell implements Model {
	
	private int value; // value of the cell

	public Cell() {
		value = 0; //	EMPTY_PIECE
	} // end constructor
	
	public void initialization() {
		value = 0;
	} // end initialization
	
	public void set_value(int new_value) {
		value = new_value;
	} // end set_value
	
	public int get_value() {
		return value;
	}// end get value
}
