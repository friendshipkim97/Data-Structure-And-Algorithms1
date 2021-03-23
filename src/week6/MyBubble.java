package week6;

public class MyBubble extends SortBase{
	
	public MyBubble(int[] myData) {
		super(myData.length);// parent클래스의 생성자를부른것
		data=myData;
		title="Bubble Sort";
	}
	
	public int[] sort(){
			for(int i=size-1; i>=0; i--) {
				for(int j=0; j<i; j++) {
					nOfIteration++;
					if(data[j]>(data[j+1])) swapData(data, j,j+1); //0보다 크다는 건 data[i]가 더크다는것이다. 크면바꿔야함
				}
			}
			
			result = data;
			return result; 
			
		}
	
	private void swapData(int [] data, int i, int j) {
		nOfSwap++;
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	}


