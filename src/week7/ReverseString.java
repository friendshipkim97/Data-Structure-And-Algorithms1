package week7;

public class ReverseString {

	public static void main(String[] args) {
		MyStack me = new MyStack(20);
		String str ="abcdefg";
		
		for(int i=0; i<str.length(); i++)
			me.push(str.charAt(i));  //i가 0일때 a 차례대로넣어진다.
		
		System.out.println(">>> Reverse-String : " + str + "\n");
		while(!me.isEmpty()) {
			System.out.print(me.pop());
		}
		System.out.println();

	}

}
