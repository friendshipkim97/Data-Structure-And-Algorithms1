package week4;

public class MyArrayList {
	int initSize = 5;
	int arraySize;
	String [] data ;
	int numberOfData;
	boolean found=false;
	
	public MyArrayList() {
		arraySize = initSize;
		data = new String[arraySize];
		numberOfData=0;
	}
	
	public void add(String name) {
		if(numberOfData==arraySize)
		{    arraySize*=2;
			String [] bigArray = new String[arraySize*2];
			for(int i=0; i<numberOfData; i++)
				bigArray[i]=data[i];
			data = bigArray;	
		}
		
		data[numberOfData]=name;
		System.out.println(data[numberOfData]);
		numberOfData++;
		
		mySort();
	}
	
	
	public boolean remove(String name) {
		for(int i=0; i<numberOfData; i++) {
			if(name.equals(data[i]))
			{
				found = true;
				
				numberOfData--;
				for(int j=1; j<numberOfData; j++)
					data[j]=data[j+1];
				break;				
			}
	}	
		return found;
	}
	
	public int size() {
		return numberOfData;
	}
	
	public int indexOf(String name) {
//		int found = -1;
//		for(int i=0; i<numberOfData; i++) 
//			if(name.equals(data[i])) {
//			found = i;
//			break;
//			}
		
		return mySearch(name);
	
	}
	
	public String toString() {
		System.out.println("현재 명단");
		String result ="";
		for(int i=0; i<numberOfData; i++)
		result = result + " "  +data[i];
		
		return result;

	}
	
    public int mySearch(String name) {
    	
    	
    	return seqSearch(name);
 //   	return binSearch(data, 0, numberOfData-1, name );
    }
    
    private int binSearch(String[] data, int low, int high, String name) {
		if(low>high) return -1;
		
		int middle = (low+high)/2;
		if(name.compareTo(data[middle])==0) return middle;  //compareTo는 앞의 것과 비교해서 앞의 것이 작으면 음수 크면 양수 같으면 0이다.
		else if (name.compareTo(data[middle])<0) return binSearch(data, low, middle-1, name);
		else return binSearch(data, middle+1, high, name);
		
	}

	private int seqSearch(String name) //private은 외부에서 부를 수 없다
    {
    	int i=0;
    	while(i<numberOfData && !data[i].equals(name)) {
    		i++;
    	}
    	if(i<numberOfData) return i;
    	else return -1;
    	
    	//return indexOf(name);
		
	}

	public void mySort() {
    
		selectionSort();
    }

	private void selectionSort() {
		for(int i=0; i<numberOfData-1; i++) {
			for(int j=i+1; j<numberOfData; j++) {
				if(data[i].compareTo(data[j])>0) swapData(i,j); //0보다 크다는 건 data[i]가 더크다는것이다. 
			}
		}
		
	}

	private void swapData(int i, int j) {
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
}

