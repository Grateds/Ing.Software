package com.Grateds.Reversi.GUI;

import java.util.Observable;
import java.util.Observer;
import com.Grateds.Reversi.CONTROLLER.Controller; 
import com.Grateds.Reversi.MODEL.Board;

/**
 *
 * @author pablo
 */
public class MainWindow extends javax.swing.JFrame implements Observer {
    
    /**
	 * 
	 */
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
        //super("Reversi");     // changed dastorga
        controller = c;
        board = c.getBoard();
        board.addObserver(this);
        menuBar = new GameMenu();
        setJMenuBar(menuBar);
        controller.initialization(); // fix
        initComponents();
        setResizable(false);
        setVisible(true);        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
            	controller.initialization();
            	gameGraphicsPanel1.repaint();
            	update(controller.getBoard(),"");
            }
        });

        jButton2.setText("Undo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	controller.drawBoard();
            }
        });

        jButton3.setText("Redo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Black: "+2);	// score of Black piece
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel1.setForeground(new java.awt.Color(0, 18, 18));        
        add(jLabel1, java.awt.BorderLayout.SOUTH);

        jLabel2.setText("White: "+2);	// score of White piece
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel2.setForeground(new java.awt.Color(10, 20, 0));        
        add(jLabel2, java.awt.BorderLayout.SOUTH);

        jLabel3.setText("Time:");
        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));        
        add(jLabel3, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout gamePanel1Layout = new javax.swing.GroupLayout(gamePanel1);
        gamePanel1.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameGraphicsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public void update(Observable o, Object arg) {
		setScores(controller.getBlackScore(),controller.getWhiteScore());
		jLabel1.setText("Black: "+BlackScore);	// score of Black piece
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel1.setForeground(new java.awt.Color(0, 18, 18));        
        jLabel2.setText("White: "+WhiteScore);	// score of White piece
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); 
        jLabel2.setForeground(new java.awt.Color(10, 20, 0));        

	}
    
//    /**  Comented for Vercryger
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch(Exception e) {}
//        //</editor-fold>
//        
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainWindow().setVisible(true);
//            }
//        });
//    }
//    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.Grateds.Reversi.GUI.GameGraphicsPanel gameGraphicsPanel1;
    private com.Grateds.Reversi.GUI.gamePanel gamePanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
