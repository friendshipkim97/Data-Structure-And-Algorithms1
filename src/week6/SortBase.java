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
    		 data[i] = (int) (Math.random()*size*10);//math.random�Լ��� 0����1�����Ǿƹ����̳��� double���� ���� int�� Ÿ��ĳ�����̴�
    	 
    	 return data; 
     }
     
     public int[] sort() {
    	 result = data;
    	 return result; 
     }
     
     public void showInfo() {
    	 System.out.println("\n>>> "+title+" <<<");
    	 System.out.print("-- result : ");
    	 for(int e : result) //��Ȯ�ϰ� �߳������ٶ� �������𸦶�������Ѵ�. 
    		 System.out.print(e+" ");
    	 System.out.println("\n-- Iteration(RecursiveCalls) = " + nOfIteration +
    			 "\n-- Swap(Merge) = " + nOfSwap);
     }
}
