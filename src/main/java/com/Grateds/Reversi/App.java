package com.Grateds.Reversi;

import com.Grateds.Reversi.CONTROLLER.*;
import com.Grateds.Reversi.GUI.MainWindow;
import com.Grateds.Reversi.GUI.SmallWindow;

public class App {
    public static void main( String[] args ) throws InterruptedException{
    	Controller controller = new Controller();
    	MainWindow window = new MainWindow(controller);
        SmallWindow sWindow = new SmallWindow(controller);
        controller.setWindows(window, sWindow);
    	controller = window.getController();
        sWindow.setVisible(true);
    	controller.start_game(1); // cpu with WHITE_PIECE  
    }
}