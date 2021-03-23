package week6;
public class SortBase {
     int nOfIteration; // <- n.of recursive calls
     int nOfSwap;
     int [] data;
     int [] result;
     int size;
     String title;
     
     public SortBase(int n) {
    	 nOfIteration =0;
    	 nOfSwap=0;
    	 size=n;
    	 data= new int [size];
    	 result = new int [size];
    	 title="Base";
     }
     
     public int[] createData() {
    	 for(int i=0; i<size; i++) 
    		 data[i] = (int) (Math.random()*size*10);//math.random함수는 0에서1까지의아무값이나옴 double형태 앞의 int는 타입캐스팅이다
    	 
    	 return data; 
     }
     
     public int[] sort() {
    	 result = data;
    	 return result; 
     }
     
     public void showInfo() {
    	 System.out.println("\n>>> "+title+" <<<");
    	 System.out.print("-- result : ");
    	 for(int e : result) //명확하게 쭉나열해줄때 갯수르모를때도사용한다. 
    		 System.out.print(e+" ");
    	 System.out.println("\n-- Iteration(RecursiveCalls) = " + nOfIteration +
    			 "\n-- Swap(Merge) = " + nOfSwap);
     }
}
