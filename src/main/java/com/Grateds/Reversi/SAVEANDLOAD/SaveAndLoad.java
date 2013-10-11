package com.Grateds.Reversi.SAVEANDLOAD;
import com.Grateds.Reversi.MODEL.Board;
import java.io.*;

public class SaveAndLoad {

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
			pw.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
               try{
            	   if (null != fichero) // I make sure to close the file
            		   fichero.close();
               }catch (Exception e2) {
                  e2.printStackTrace();
               }
            }
     } // end saveBoard
    
    public void loadBoard(){
    	File archivo = null;
    	FileReader fr = null;
    	BufferedReader br = null;
    	try {
    		 // Open the file and creating BufferedReader to
    		 // make a comfortable reading (dispose of the method readLine ()).
    		 archivo = new File ("src/main/java/com/Grateds/Reversi/savedBoard.txt");
    		 fr = new FileReader (archivo);
    		 br = new BufferedReader(fr);
    		 // reading file
    		 String linea;
    		 while((linea=br.readLine())!=null)
    			 System.out.println(linea);
    		 }
    		 catch(Exception e){
    		        e.printStackTrace();
    		 }finally{
    			 // In finally close the file, to make sure is closed if all goes well both as if an exception occurs
    		     try{                    
    		         if (null != fr ){
    		        	 fr.close();
    		          }                       
    		      }catch (Exception e2){ 
    		           e2.printStackTrace();
    		      }
    		 }	 
    }// end loadBoard
	
} 
