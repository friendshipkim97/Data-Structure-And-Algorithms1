package week2;
public class factorialIteration {
	public static int result=1; //공유메모리
	
	public static void facto1(int n) {
		if(n<=0) {
			System.out.println("Input Error!");
			return;
		}
		for(int i=1; i<=n; i++) {
			result *= i;
		}
	}
	
	public static void main(String[] args) {
		int inputSize = 5;
		facto1(inputSize);
		System.out.println("Result : " +result);
	}

}
