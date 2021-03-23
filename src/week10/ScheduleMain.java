package week10;

import java.util.Scanner;

public class ScheduleMain {

	public static void main(String[] args) {
         Scheduler me = new Scheduler("F");
		
		Scanner keyboard;
		
		keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.print("\n>> command ? 스케줄 관리\n");
			String command = keyboard.next();
			
			if(command.equals("add")) {
				String newEvent = keyboard.next();  
				int pri = keyboard.nextInt();
				me.addEvent(newEvent, pri);  
			}
			else if(command.equals("del")) {
				String event = keyboard.next();
				me.deleteEvent(event);
			}
			else if(command.equals("prt")) {
				me.printEvent();
			}
			else if(command.equals("size")) {
				me.numberOfEvent();
			}
			else if(command.equals("x")){
				break;
			}
			else 
				System.out.println("\n Wrong Command .... Try Again !");
		}
		keyboard.close();
	}

}
