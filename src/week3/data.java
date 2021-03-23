package week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class data {
	
	int arraySize;
	String [] data ;
	int numberOfData;
	boolean found=false;
	String i=" ";
	
	public data(int maxSize) {
		arraySize = maxSize;
		data = new String[arraySize];
		numberOfData=0;
	}
	
	public void fileadd() {   //파일을 입력받아 값을 저장
			try {
				Scanner inFile = new Scanner(new File("File/input.txt"));
				while(inFile.hasNext()) {
					String str = inFile.next();
					add(str);
				}
				inFile.close();
			} catch (FileNotFoundException e) {
				System.out.println(" >>> Input File not found");
			}
		}
	
	
	public void add(String name) {        //키보드로 입력받은 값을 저장
		if(numberOfData==arraySize)
	           System.out.println("Array is Full");
		else {
		data[numberOfData]=name;
		System.out.println(data[numberOfData]);
		numberOfData++;
	}
	}
	
	public boolean remove(String name) {
		for(int i=0; i<numberOfData; i++) {
			if(name.equals(data[i]))
			{
				found = true;
				
				numberOfData--;
				for(int j=i; j<numberOfData; j++)
					data[j]=data[j+1];
				break;
					
			}
	}
		
		return found;
	}
	
	public void sizeOf() {
		System.out.println(numberOfData);
	}
	
	public boolean attend(String name) {
		for(int i=0; i<numberOfData; i++) {
			if(name.equals(data[i])) {
			found =true;
			}
		}
		return found;
	}
	
	public void printList() {
		System.out.println("현재 명단");
		
		for(int i=0; i<numberOfData; i++)
			System.out.println(" "+ i + " " + data[i] );
	}
	
	public static void main(String[] args) {
		data me = new data(10);
		
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n  command ? ");
			String command = keyboard.next();
			
			if(command.equals("f")) {          //파일로 입력받아 배열에 추가하기 
				System.out.println("input.txt에 추가할 내용을 적고 저장하고 추가하십시오.");
				me.fileadd();
			}
				
		
			else if(command.equals("add")) {            //키보드로 입력받은 값 
			String name = keyboard.next();
			//insert the name 
	             me.add(name);
			}
	    
		
		else if(command.equals("r")) {
			String name = keyboard.next();
			
			boolean result = me.remove(name);
			System.out.println("Search Result :"+ result);
			}
			
		else if(command.equals("h"))
		{
			me.sizeOf();
		}
		else if(command.equals("attend")) {
			String name = keyboard.next();
			boolean result = me.attend(name);
			System.out.println("Search Result :"+ result);
			
		}
		
		else if(command.equals("p")) {
		
			System.out.println("[ArrayList]");
			me.printList();
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
