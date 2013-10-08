package com.Grateds.Reversi.MODEL;

public class Cell implements Model {
	
	private int value; // value of the cell
	private boolean settable; // field that indicates if cell is settable

	public void initialization() {
		value = 0;
		settable = true; // default
	} // end initialization
	
	public void set_value(int new_value) {
		value = new_value;
	} // end set_value
	
	public int get_value() {
		return value;
	}// end get value
	
	public void is_settable(boolean val) {
		settable = val;
	}// end is_settable
}
