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
		
		newNode.next=head; //newNode의 next에 head를 넣는과정
		head=newNode;
		System.out.println(head.name);
	
	}
	
	
	public boolean remove(String name) {
		boolean found = false;

//		Node position = head;
//		if(position!=null && name.equals(position.name)) { //if문첫번째것테스트  여기서첫번째것은 제일최근것을의미
//			found = true;
//			head = position.next;
//		}
//		else {
//			while(position.next!=null && found==false) { //이경우에는 첫번째일경우 못찾는다.
//				if(name.equals(position.next.name))
//				{
//					found = true;
//					position.next=position.next.next;			
//				}
//				else 
//					position= position.next; // 다음 걸로 넘어가는것 
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
			    previous.next = position.next; //이건 포지션이 2번째라면 첫번째것이 세번째를가리키게해준다는뜻 
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
   			position = position.next; //다음 값으로 넘어가는과정 
       }
   		return -1; //없으면 -1반환 
   	
	}
	
	public String toString() {
		String result ="";
		Node position = head;
		while(position!=null) {  
			System.out.println(position.name); //출력하는 과정에서 arraylist와 다르게 제일 오른쪽 값이 인덱스번호 0이 된다. 그러므로 출력할땐 거꾸로 출력된다.
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
//		if(name.compareTo(data[middle])==0) return middle;  //compareTo는 앞의 것과 비교해서 앞의 것이 작으면 음수 크면 양수 같으면 0이다.
//		else if (name.compareTo(data[middle])<0) return binSearch(data, low, middle-1, name);
//		else return binSearch(data, middle+1, high, name);
//		
//	}
//
//	private int seqSearch(String name) //private은 외부에서 부를 수 없다
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
//				if(data[i].compareTo(data[j])>0) swapData(i,j); //0보다 크다는 건 data[i]가 더크다는것이다. 크면바꿔야함
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

