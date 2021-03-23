package week6;
public class MyQuick extends SortBase{
	
	public MyQuick(int[] myData) {
		super(myData.length);
		data=myData;
		title="Quick Sort";
	}
	
	public int[] sort() {
		result = quickSort(data, 0, size-1);
		return result;
	}
	
	private int[] quickSort(int[] data2, int p, int r) {
	     
		nOfIteration++;
    	if(p<r) {
    		int q = partition(data2, p, r);
    		quickSort(data2, p, q-1);
    		quickSort(data2, q+1, r);
    	}
    	
    	return data2;
	}

private int partition(int[] data2, int p, int r) {
	int pivot = r;
	
	int left = p;
	int right = r; //r�� ���� pivot�ΰ��̴�.
	
	while(left<right) {  //left�� right���� �����������ݺ� 
		
		while(data2[left]<data2[pivot] && left<right) left++; //left�� pivot���� ���� ������ left�� �߰��ϰ� ���������ΰ��°� , integer�ϱ�ٲ۴�
		while(data2[right]>=data2[pivot] && left<right) right--;
		if(left<right) swapData(data2, left, right);
	}
	swapData(data2, pivot, right); //right�� left���� �� ũ�ų� �������� 
	return right; //left�� �������. 
}

private void swapData(int[] data2, int i, int j) {

	nOfSwap++;
	int temp = data2[i];
	data2[i] = data2[j];
	data2[j] = temp;
}

}
