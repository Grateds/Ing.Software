package com.Grateds.Reversi.MODEL;

public class Cell implements Model {
	
	private int value; // value of the cell
	private boolean settable; // field that indicates if cell is settable

	public Cell() {
		value = 0;
		settable = true; // default
	} // end constructor
	
	public void initialization() {
		value = 0;
		settable = true; // default
	}
	
	public void set_value(int new_value) {
		value = new_value;
		settable=false;
	} // end set_value
	
	public int get_value() {
		return value;
	}// end get value
	
	public boolean is_settable() {
		return settable;
	}// end is_settable
}
