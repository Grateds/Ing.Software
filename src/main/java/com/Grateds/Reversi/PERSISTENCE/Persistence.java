package com.Grateds.Reversi.PERSISTENCE;

import com.Grateds.Reversi.MODEL.Board;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Persistence {

	public void saveBoard(Board b){
       	FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("src/main/java/com/Grateds/Reversi/savedBoard.txt");
            pw = new PrintWriter(fichero);                   						
            for (int i = 0; i < 8; i++){
            	for (int j = 0; j < 8; j++){
            		pw.print(b.get(i, j)+" ");
                }
                pw.println("");
			} 
        }catch (Exception e) {
                e.printStackTrace();
        } finally{
               try{
            	   if (null != fichero) // I make sure to close the file
            		   fichero.close();
               }catch (Exception e2) {
                  e2.printStackTrace();
               }
        }
    } // end saveBoard
	
    public Board loadBoard(){
    	ArrayList<Integer> numArray = new ArrayList<Integer>();	
    	Board b = new Board();  	
        File f = new File("src/main/java/com/Grateds/Reversi/savedBoard.txt");
        int numero;
        Scanner entrada = null;  
        try {
             entrada = new Scanner(f);
             while (entrada.hasNextInt()) {
            	 numero = entrada.nextInt();
                 numArray.add(numero);	 
             } // end while
        }catch (FileNotFoundException e) {
             System.out.println(e.getMessage());
        }finally{
             entrada.close();
        } 
        int index = 0;
        for (int i = 0; i < 8; i++){
        	for (int j = 0; j < 8; j++){
            	b.set_load(i, j, numArray.get(index++));
            } 
        }
        return b;
    } //end loadBoard  
	
}
