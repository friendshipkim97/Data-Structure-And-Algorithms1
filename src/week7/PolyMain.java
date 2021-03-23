package week7;

import java.util.Scanner;

public class PolyMain {

	public static void main(String[] args) {
		
//		PolynomArray me = new PolynomArray("F");
		Polynom me = new Polynom("F");
		
		Scanner keyboard;
		
		keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.print("\n>> command ? ");
			String command = keyboard.next();
			
			if(command.equals("add")) {
				int c = keyboard.nextInt();  //공백이전까지의 int값을받는다.
				int e = keyboard.nextInt();
				me.addTerm(c,e);  //new Term(c,e)에서 변환
			}
			else if(command.equals("del")) {
				int dExp = keyboard.nextInt();
				me.deleteTerm(dExp);
			}
			else if(command.equals("calc")) {
				int x = keyboard.nextInt();
				System.out.println("calculation result = " + me.calculate(x));
			}
			else if(command.equals("prt")) {
				me.printPoly();
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
