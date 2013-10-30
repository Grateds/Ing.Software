package com.Grateds.Reversi.GUI;

import java.util.Observable;
import java.util.Observer;
import com.Grateds.Reversi.CONTROLLER.Controller; 
import com.Grateds.Reversi.MODEL.Board;

public class MainWindow extends javax.swing.JFrame implements Observer {
  
	private static final long serialVersionUID = 1L;
	private GameMenu menuBar;
	private Controller controller;
	private Board board;
	private String WhiteScore;
	private String BlackScore;
	
    /**
     * Creates new form MainWindow
     */
    public MainWindow(Controller c) {
        controller = c;
        board = c.getBoard();
        board.addObserver(this);
        menuBar = new GameMenu(c);
        setJMenuBar(menuBar);
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(getOwner());
        setVisible(true);
        controller.initialization();
        setScores(controller.getBlackScore(),controller.getWhiteScore());
    } // end MainWindow
    
    public Controller getController(){
    	return controller;
    }
    
    private void setScores(Integer BScore, Integer WScore){
    	BlackScore=BScore.toString();
    	WhiteScore=WScore.toString();      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        gamePanel1 = new gamePanel();
        gameGraphicsPanel1 = new GameGraphicsPanel(controller);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reversi");
        setResizable(false);
        
        javax.swing.GroupLayout gameGraphicsPanel1Layout = new javax.swing.GroupLayout(gameGraphicsPanel1);
        gameGraphicsPanel1.setLayout(gameGraphicsPanel1Layout);
        gameGraphicsPanel1Layout.setHorizontalGroup(
            gameGraphicsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        gameGraphicsPanel1Layout.setVerticalGroup(
            gameGraphicsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jButton1.setText("New Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("First Computer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButton2ActionPerformed(evt);         	
            }
        });

        jButton3.setText("First Human");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton4.setText("Change Piece");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Black: "+2);	// score of Black piece
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));        
        add(jLabel1, java.awt.BorderLayout.SOUTH);

        jLabel2.setText("White: "+2);	// score of White piece
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));        
        add(jLabel2, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout gamePanel1Layout = new javax.swing.GroupLayout(gamePanel1);
        gamePanel1.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameGraphicsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        gamePanel1Layout.setVerticalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanel1Layout.createSequentialGroup()
                .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gameGraphicsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(gamePanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	controller.stop();
    	NewGame window = new NewGame(controller);
//    	controller.stop();
//    	controller.reset_game();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    	controller.reset_game_first(false);
//    	System.out.print("Comienza jugando la computadora.!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    	controller.stop();
   	 	controller.reset_game_first(true);
//   	 	System.out.print("Comienza jugando el humano.!");  
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    	// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void update(Observable o, Object arg) {
    	setScores(controller.getBlackScore_update(),controller.getWhiteScore_update());
    	jLabel1.setText("Black: "+BlackScore);  // score of Black piece
    	jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 22)); 
    	jLabel2.setText("White: "+WhiteScore);  // score of White piece
    	jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 22));       
    	this.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.Grateds.Reversi.GUI.GameGraphicsPanel gameGraphicsPanel1;
    private com.Grateds.Reversi.GUI.gamePanel gamePanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
