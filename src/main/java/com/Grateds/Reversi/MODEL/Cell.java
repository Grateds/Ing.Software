package com.Grateds.Reversi.MODEL;

public class Cell implements Model {
	
	private int value; // value of the cell
	private int suggest;
	
	public Cell() {
		value = 0; //	EMPTY_PIECE
		suggest = 0;
	} // end constructor
	
	public void initialization() {
		value = 0;
	} // end initialization
	
	public void set_value(int new_value) {
		value = new_value;
	} // end set_value
	
	public void suggest(int value){
		suggest = value;
	}
	
	public int get_suggest(){
		return suggest;
	}
	
	public int get_value() {
		return value;
	}// end get value
}
