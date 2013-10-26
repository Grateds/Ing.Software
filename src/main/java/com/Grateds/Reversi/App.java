package com.Grateds.Reversi;

import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.GUI.MainWindow;

public class App {

    public static void main( String[] args ) throws InterruptedException{
    	Controller controller = new Controller();
    	MainWindow window = new MainWindow(controller);
    	controller = window.getController();
    	controller.start_game();
    }
}