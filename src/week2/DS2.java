package week2;
public class DS2 {

	public static long count=0;
	public static int fibo2(int n) {
		if(n<0) return -1;
		if(n<=1) return n;
		
		count++;
		return fibo2(n-1)+fibo2(n-2);
	}
	
	public static void main(String[] args) {
		int result=0;
		for(int n=2; n<=40; n++) {
			result=fibo2(n);
			if(result==1) {
				System.out.println("Input Error!");
			}
			else
				System.out.println("Fibonacci Result of "+n+" : " +result);
		}
		
		System.out.println("Count : " +count);
	}


	}
