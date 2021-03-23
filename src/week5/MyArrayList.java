package week5;

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
		
		//mySort();
	}
	
	
	public boolean remove(String name) {
		for(int i=0; i<numberOfData; i++) {
			if(name.equals(data[i]))
			{
				found = true;
				
				numberOfData--;
				for(int j=i; j<numberOfData; j++)
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
		System.out.println("���� ���");
		String result ="";
		for(int i=0; i<numberOfData; i++)
		result = result + " "  +data[i];
		
		return result;

	}
	
    public int mySearch(String name) {
    	
 
    	return binSearch(data, 0, numberOfData-1, name);
  
    }
    
	private int binSearch(String[] data, int low, int high, String name) {
		if(low>high) return -1;
		
		int middle = (low+high)/2;
		if(name.compareTo(data[middle])==0) return middle;  //compareTo�� ���� �Ͱ� ���ؼ� ���� ���� ������ ���� ũ�� ��� ������ 0�̴�.
		else if (name.compareTo(data[middle])<0) return binSearch(data, low, middle-1, name);
		else return binSearch(data, middle+1, high, name);
		
	}

	public void mySort() {
		//selectionSort();
		//bubbleSort();
		//quickSort(data, 0, numberOfData-1);
		mergeSort(data, 0, numberOfData-1);
		}
	
//////////////////////////////////////////////////////////////////////
	
private void mergeSort(String[] data2, int p, int r) {

	if(p<r) {
		int q = (p+r)/2;
		mergeSort(data2, p, q);
		mergeSort(data2, q+1, r);
		merge(data2, p, q, r);
		
	}
}
//////////////////////////////////////////////////////////////////////
	
    private void merge(String[] data2, int p, int q, int r) {
	String [] sorted = new String[data2.length];
	
	int i = p;
	int j = q+1;
	int k = p;
	
	while(i<=q && j<=r) {
		if(data2[i].compareTo(data2[j])<0)
			sorted[k++]=data2[i++];
		else 
			sorted[k++]=data2[j++];
	}
	while(i<=q) {
		sorted[k++]=data2[i++];
	}
	while(j<=r) {
		sorted[k++]=data2[j++];
	}
	
	for(int l=p; l<=r; l++) {
		data2[l]=sorted[l];
	}
}

//////////////////////////////////////////////////////////////////////
    
	private void quickSort(String[] data2, int p, int r) {
	     
    	if(p<r) {
    		int q = partition(data2, p, r);
    		quickSort(data2, p, q-1);
    		quickSort(data2, q+1, r);
    	}
		
	}

private int partition(String[] data2, int p, int r) {
	int pivot = r;
	
	int left = p;
	int right = r; //r�� ���� pivot�ΰ��̴�.
	
	while(left<right) {  //left�� right���� �����������ݺ� 
		
		while(data2[left].compareTo(data2[pivot])<0 && left<right) left++; //left�� pivot���� ���� ������ left�� �߰��ϰ� ���������ΰ��°� 
		while(data2[right].compareTo(data2[pivot])>=0 && left<right) right--;
		if(left<right) swapData(data2, left, right);
	}
	swapData(data2, pivot, right); //right�� left���� �� ũ�ų� �������� 
	return right; //left�� �������. 
}

private void swapData(String[] data2, int i, int j) {

	String temp = data2[i];
	data2[i] = data2[j];
	data2[j] = temp;
}

//////////////////////////////////////////////////////////////////////
	
	private void selectionSort() {
		for(int i=0; i<numberOfData-1; i++) {
			
			for(int j=i+1; j<numberOfData; j++) {
				if(data[i].compareTo(data[j])>0) swapData(i,j); //0���� ũ�ٴ� �� data[i]�� ��ũ�ٴ°��̴�. ũ��ٲ����
			}
		}
		
	}
/////////////////////////////////////////////////////////////////////
	private void bubbleSort() {
		for(int i=numberOfData-1; i>=0; i--) {
			
			for(int j=0; j<i; j++) {
				if(data[j].compareTo(data[j+1])>0) swapData(j,j+1); //0���� ũ�ٴ� �� data[i]�� ��ũ�ٴ°��̴�. ũ��ٲ����
			}
		}   
		
	}
	
/////////////////////////////////////////////////////////////////////
	
	
	private void swapData(int i, int j) {
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
}

