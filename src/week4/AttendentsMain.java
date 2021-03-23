package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AttendentsMain {
	public static void main(String[] args) {
	NewChild me = new NewChild(); //부모에서 상속받은 것 때문에 똑같이 돌아간다.
		
	Scanner keyboard;
	keyboard = new Scanner(System.in);
	
	while(true) {
		System.out.println("\n  command ? ");
		String command = keyboard.next();
			if(command.equals("s")) {
				me.mySort();
			}
			
			else if(command.equals("f")) {
				try {
					Scanner inFile = new Scanner(new File("File/input2.txt"));
					while(inFile.hasNext()) {
						String str = inFile.next();
						me.add(str);
					}
					inFile.close();
				} catch (FileNotFoundException e) {
					System.out.println(" >>> Input File not found");
				}
			}
	
			else  if(command.equals("i")) {
		String name = keyboard.next();
		//insert the name 
             me.add(name);
		}
	
	else if(command.equals("d")) {
		String name = keyboard.next();
		
		boolean result = me.remove(name);
		System.out.println("Delete : "+ result);
		}
		
	else if(command.equals("h"))
	{
		System.out.println("Number of Data :" + me.size());
	}
	else if(command.equals("a")) {
		String name = keyboard.next();
		int result = me.indexOf(name);
		System.out.println("Search Result : "+ result);
		
	}
	
	else if(command.equals("p")) {
	
		System.out.println("[ArrayList]");
		//System.out.println(me.toString());
		me.newPrint();
	}
	
	else if(command.equals("x")) {
		break;
	}
	else
		System.out.println("\n  Wrong Command .... Try Again !");
	
	
}
	keyboard.close();
}
}
