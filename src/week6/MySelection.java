package week6;
public class MySelection extends SortBase{
	
	public MySelection(int[] myData) {
		super(myData.length);  //sortbase�����ھ��ǳ������ 
		data = myData;
		title = "Selection Sort"; 
	}
	
	public int[] sort() { 
			for(int i=0; i<size-1; i++) {
				for(int j=i+1; j<size; j++) {
					nOfIteration++;
					if(data[i]>(data[j])) swapData(data,i,j); //0���� ũ�ٴ� �� data[i]�� ��ũ�ٴ°��̴�. ũ��ٲ����
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
