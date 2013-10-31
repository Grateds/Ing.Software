package com.Grateds.Reversi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.UUID;
import java.util.Vector;

public class User {

	private String Name;   // user name
	private int Score;    // user score
	private int id;       // UNIQUE user id 
	
	public User(){
		Name = "";
		Score = 0;
		id = 0;
	} // end constructor
	
	public void create(String new_name, int new_score){
		Name = new_name;
		Score = new_score;
		id = generateUniqueId();
		writeToFile(this);
	} // end delete
	
	public void delete(Integer id){
		Vector<String> usr = fileToVector();
		FileWriter usersFile = null;
		PrintWriter pw = null;
		String key = id.toString();
		try{
			usersFile = new FileWriter("src/main/java/com/Grateds/Reversi/users.txt");
			pw = new PrintWriter(usersFile);
			int i=0;
			while(i<usr.size()){
				if(!usr.get(i).equals(key)){
					pw.print(usr.get(i)+" ");
					pw.print(usr.get(i+1)+" ");
					pw.println(usr.get(i+2));
				}
				i=i+3;
			}
			usersFile.close();
		}catch (IOException e){
			e.getStackTrace();
		}
	} // end delete
	
	private Vector<String> fileToVector(){
		Vector<String> usr = new Vector<String>();
		String id;
		String name;
		String score;
		try{
			Scanner usersFile = new Scanner(new FileReader("src/main/java/com/Grateds/Reversi/users.txt"));
			while(usersFile.hasNext()){
				id = usersFile.next();
				name = usersFile.next();
				score = usersFile.next();
				usr.add(id);
				usr.add(name);
				usr.add(score);
			}
			usersFile.close();
		}catch (IOException e){
			e.getStackTrace();
		}
		return usr;
	} // end fileToVector
	
	
	private void writeToFile(User usr){
		FileWriter usersFile = null;
		PrintWriter pw = null;
		try{
			usersFile = new FileWriter("src/main/java/com/Grateds/Reversi/users.txt",true);
			pw = new PrintWriter(usersFile);
			pw.print(usr.id+" ");
			pw.print(usr.Name+" ");
			pw.println(usr.Score);
			usersFile.close();
		}catch (IOException e){
			e.getStackTrace();
		}
	} // end writeToFile
	
	private int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    } // end generateUniqueId
}
