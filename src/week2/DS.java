package week2;

public class DS {
	
	public static long count=0;
	public static int fibo1(int n) {
		if(n<0) return -1;
		if(n<=1) return n;
		
		int f1=0;
		int f2=1;
		int fn=0;
		for(int i=2; i<=n; i++) {
			count++;
			fn=f1+f2;
			f1=f2;
			f2=fn;
		}
		
		return fn;
	}
	
	public static void  main(String[] args) {
		int result=0;
		for(int n=2; n<=40; n++) {
			result=fibo1(n);
			if(result==1) {
				System.out.println("Input Error!");
			}
			else
				System.out.println("Fibonacci Result of "+n+" : " +result);
		}
		
		System.out.println("Count : " +count);
	}
}
