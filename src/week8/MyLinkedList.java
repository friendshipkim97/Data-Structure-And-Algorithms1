package week8;

public class MyLinkedList {
	
	class Node {
		String name;
		Node next;
		
		public Node(String s) {
			name=s;
			next=null;
		}
	}
	
	Node head;
	
	public MyLinkedList() {
		head=null;
	}
	
	public void add(String name) {
		Node newNode = new Node(name);
		
		newNode.next=head; //newNode�� next�� head�� �ִ°���
		head=newNode;
		System.out.println(head.name);
	
	}
	
	
	public boolean remove(String name) {
		boolean found = false;

//		Node position = head;
//		if(position!=null && name.equals(position.name)) { //if��ù��°���׽�Ʈ  ���⼭ù��°���� �����ֱٰ����ǹ�
//			found = true;
//			head = position.next;
//		}
//		else {
//			while(position.next!=null && found==false) { //�̰�쿡�� ù��°�ϰ�� ��ã�´�.
//				if(name.equals(position.next.name))
//				{
//					found = true;
//					position.next=position.next.next;			
//				}
//				else 
//					position= position.next; // ���� �ɷ� �Ѿ�°� 
//			}
//		}
//		return found;
		
		Node position = head;
		Node previous = null;
		while(position!=null) { 
		if(name.equals(position.name)) {
			found=true;
			if(previous==null)
				head=position.next;
			else
			    previous.next = position.next; //�̰� �������� 2��°��� ù��°���� ����°������Ű�����شٴ¶� 
			position=null;
		}
			
		else {
			previous = position;
			position = position.next;
		}
		
		
	}
		return found;
	}
	
	public int size() {
		int count =0;
		Node position = head;
		while(position!=null) {
			count++;
			position=position.next;
		}
		return count;
	}
	
	public int indexOf(String name) {
       int size = size();
       int count = 0;
       Node position = head;
       while(position!=null) { 
    	   count++;
   		if(name.equals(position.name)) 
   			return size-count;		
   		else 
   			position = position.next; //���� ������ �Ѿ�°��� 
       }
   		return -1; //������ -1��ȯ 
   	
	}
	
	public String toString() {
		String result ="";
		Node position = head;
		while(position!=null) {  
			System.out.println(position.name); //����ϴ� �������� arraylist�� �ٸ��� ���� ������ ���� �ε�����ȣ 0�� �ȴ�. �׷��Ƿ� ����Ҷ� �Ųٷ� ��µȴ�.
		result = result + "->" + position.name;
	
		position=position.next;
		}
		return result;

	}
	
//    public int mySearch(String name) {
//    	
//    	
// // 	return seqSearch(name);
//  //  	return binSearch(data, 0, numberOfData-1, name);
//    	return binSearchIteration(data, 0, numberOfData-1, name);
//    }
//    
//    private int binSearchIteration(String[] data, int low, int high, String name) {
//    	int middle;
//    	while(low<=high) {
//    		middle = (low+high)/2;
//    		System.out.println(middle);
//    		if(name.compareTo(data[middle])==0) return middle;
//    		else if(name.compareTo(data[middle])<0) return high=middle-1;
//    		else low=middle+1;
//    	}
//    	
//    	return -1;
//	}
//
//	private int binSearch(String[] data, int low, int high, String name) {
//		if(low>high) return -1;
//		
//		int middle = (low+high)/2;
//		if(name.compareTo(data[middle])==0) return middle;  //compareTo�� ���� �Ͱ� ���ؼ� ���� ���� ������ ���� ũ�� ��� ������ 0�̴�.
//		else if (name.compareTo(data[middle])<0) return binSearch(data, low, middle-1, name);
//		else return binSearch(data, middle+1, high, name);
//		
//	}
//
//	private int seqSearch(String name) //private�� �ܺο��� �θ� �� ����
//    {
//    	int i=0;
//    	while(i<numberOfData && !data[i].equals(name)) {
//    		i++;
//    	}
//    	if(i<numberOfData) return i;
//    	else return -1;
//    	
//    	//return indexOf(name);
//		
//	}
//
//	public void mySort() {
//    
//		selectionSort();
//    }
//
//	private void selectionSort() {
//		for(int i=0; i<numberOfData-1; i++) {
//			
//			for(int j=i+1; j<numberOfData; j++) {
//				if(data[i].compareTo(data[j])>0) swapData(i,j); //0���� ũ�ٴ� �� data[i]�� ��ũ�ٴ°��̴�. ũ��ٲ����
//			}
//		}
//		
//	}
//
//	private void swapData(int i, int j) {
//		String temp = data[i];
//		data[i] = data[j];
//		data[j] = temp;
//		
//	}
}

