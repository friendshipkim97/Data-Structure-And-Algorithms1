package week2;
public class factorialRecursion {
	
	public static int facto2(int n) {
		if(n==1) return 1;
		return n*facto2(n-1);
	}
	
	public static void main(String[] args) {
		int inputSize = 5;
		System.out.println("Result : " +facto2(inputSize));
	}

}
