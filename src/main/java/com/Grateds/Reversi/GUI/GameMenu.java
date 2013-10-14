package com.Grateds.Reversi.GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu.Separator;

public class GameMenu extends JMenuBar{
    
    public GameMenu(){
        // Menu Game
        this.add(jMenu1);
        jMenu1.setText("Game");
        jMenuItem1.setText("New game");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);
        jMenuItem2.setText("Save game");
        jMenu1.add(jMenuItem2);
        jMenuItem3.setText("Load game");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator2);
        jMenuItem4.setText("Undo");
        jMenu1.add(jMenuItem4);
        jMenuItem5.setText("Redo");
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator3);
        jMenuItem6.setText("Top scores");
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator4);
        jMenuItem7.setText("Options");
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator5);
        jMenuItem8.setText("Exit");
        jMenu1.add(jMenuItem8);
        // Menu Help
        this.add(jMenu2);
        jMenu2.setText("Help");
        jMenuItem9.setText("About");
        jMenu2.add(jMenuItem9);
    }
    
    JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
    JMenu jMenu1 = new javax.swing.JMenu();
    JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
    Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
    JMenuItem jMenuItem2 = new javax.swing.JMenuItem();
    JMenuItem jMenuItem3 = new javax.swing.JMenuItem();
    Separator jSeparator2 = new javax.swing.JPopupMenu.Separator();
    JMenuItem jMenuItem4 = new javax.swing.JMenuItem();
    JMenuItem jMenuItem5 = new javax.swing.JMenuItem();
    Separator jSeparator3 = new javax.swing.JPopupMenu.Separator();
    JMenuItem jMenuItem6 = new javax.swing.JMenuItem();
    Separator jSeparator4 = new javax.swing.JPopupMenu.Separator();
    JMenuItem jMenuItem7 = new javax.swing.JMenuItem();
    Separator jSeparator5 = new javax.swing.JPopupMenu.Separator();
    JMenuItem jMenuItem8 = new javax.swing.JMenuItem();
    JMenu jMenu2 = new javax.swing.JMenu();
    JMenuItem jMenuItem9 = new javax.swing.JMenuItem();

}
