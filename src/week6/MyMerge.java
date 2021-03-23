package week6;
public class MyMerge extends SortBase{

	public MyMerge(int[] myData) {
		super(myData.length); 
		data=myData;
		title="Merge Sort";
	}
	
	public int[] sort() {
	//	result = mergeSort(data, 0, size-1);
		return result;
	}
	
    public int[] sort(int[] data, int p, int r) {    //�����̸��Ǹ޼ҵ尡 2���� ���͵��ȴٴ� ���� �� �� �ִ�. �Ķ������ ������ �������ٸ� �̷� ��쿡 �̰��� �������̶��θ���. 
      nOfIteration++;
      
		if(p<r) {
			int q = (p+r)/2;
			data=sort(data, p, q);
			data=sort(data, q+1, r);
			data=merge(data, p, q, r);
			
		}
		result = data;
		return result;
	}
	
	 private int[] merge(int[] data2, int p, int q, int r) {
		 nOfSwap++; //swap�̾��� ������ merge��������� �Ͼ���� swap���δ�ü 
		 int [] sorted = new int[data2.length];
			
			int i = p;
			int j = q+1;
			int k = p;
			
			while(i<=q && j<=r) {
				if(data2[i]<data2[j])
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
			
			return data2;
		}

	public void arrayLength() {
		// TODO Auto-generated method stub
		
	}
}
