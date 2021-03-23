package week10;

import java.util.NoSuchElementException;

public class MyLinkedList<E extends Comparable<E>>{ //확장된 부분까지 파라미터로 받는 것 

	int size = 0; //이렇게쓰면 week10에서는 public이나 다름없다. 같은 패키지안이므로 public이라고 선언해줘야 다른 패키지에서쓸수있다. 

	Node<E> first; //파워포인트에서의 head이다.
	Node<E> last;
	
	public MyLinkedList() {
		
	}
	
	public E removeFirst() {
		Node<E> f = first;
		if(f==null)
			throw new NoSuchElementException();
		else {
		    first = f.next; //지우는 과정 
		    size--;
		    if(first==null) { //노드가 원래 하나뿐인데 지웠을 때 
		    	last=null;
		    }
		    else { //노드가 원래 두개 이상이였을 때 
		    	first.prev=null;
		    }
		    	
		    return f.item;
		}
	}

    public E removeLast() { //double linkedlist의 앞지우기와 뒤지우기가 구조가같아짐 
    	
    	Node<E> l = last;
    	if(l==null) //아무것도없는 linkedlist라는 뜻이다. 
    		throw new NoSuchElementException();
    	else {
    		 last=l.prev;
    		 size--;
    		if(last==null) {
    			first=null;
    	}
    		else {
    			last.next=null;
               
    		}
    		return l.item;
    	}
		
	}
    
    public boolean remove(E e) { //같은 값을 갖고 있는 것을 찾아서 제거 
    	
    	Node<E> f = first;
    	
    	while(f!=null) { //마지막값이 아닐 때까지 반복
    		if(e.equals(f.item)) {
    			if(f.prev==null) {//첫번째
    				removeFirst();
    			return true;
    		}
    			else if(f.next==null) { //마지막
    				removeLast();
    				return true;
    			}
    			else {
    				f.prev.next=f.next;
    				f.next.prev = f.prev;
    				size--;
    				return true;
    			}
    		}
    		else {
    			f=f.next;
    		}
    	}
    	return false;
    	
    }
    
    public void addFirst(E e) {
    	Node<E> newNode = new Node<>(null, e, first); //무조건 처음은  prev가 null이므로 
    	first=newNode;
    	size++;
    	if(newNode.next==null) { //노드가 아무것도 없었는데 추가한것이라면
    		last=newNode;
    	}
    	else {
    		newNode.next.prev = newNode;
    	}
    	
    }
    
    public void addLast(E e) { //addfirst와 완전 반대 
    	Node<E> newNode = new Node<>(last, e, null); //무조건 처음은  prev가 null이므로 
    	last=newNode;
    	size++;
    	if(newNode.prev==null) {
    		first=newNode;
    	}
    	else {
    		newNode.prev.next = newNode;
    		
    	}
    }
    
    public boolean add(E e) {
    	addLast(e);
    	
    	return true;
    }
    
    public boolean contains(E e) {
    	
    	return (indexOf(e) >= 0); //만일 0이상일경우 true를 반환 아니면 false를 반환 
    }
    
    public int indexOf(E e) {
		int index=0;
		for(Node<E> x = first; x!=null; x=x.next) {
			if(e.equals(x.item)) {
				System.out.println(index);
				return index;
			}
			index++; //return이니까 else가 없어도된다. 
		}
		return -1;
	}

	public int size() {
    	 return size;
    }
    
    public E get(int index) { // index는 0부터 size-1까지 
    	checkElementIndex(index); 	
    	return node(index).item;
    }
    
    
    private void checkElementIndex(int index) {
    	if(index>=0 && index<size) 
    		return;
    	else 
    		throw new IndexOutOfBoundsException(index);
 
	}
    
    Node<E> node(int index){
    	checkElementIndex(index);
    	if(index==0)
    		return first;
    	else {
    		Node<E> f = first;
    		for(int i=1; i<=index; i++)
    			f=f.next;
    		return f;
    	}
    }
    
    public E set(int index, E element) {
    	checkElementIndex(index);
    	Node<E> f = node(index); //index값에 뭐가들어있는지 찾는 과정 
    	E oldVal = f.item;
    	f.item = element;
    	return oldVal;
    	
    }
    //LinkedList
//    public void add(int index, E element) { // 교수님이해주신코드 
//    	checkPositionIndex(index);
//    	if(index==1)
//    		addFirst(element);
//    	else
//    		addAfter(element, node(index-1)); //이 노드에집어넣어라 여기서의 node는 이미존재하는것, 앞에서 checkpositionindex로이미체크됨
//    }
//    
    public void add(int index, E element) { // 이렇게 해야 모든인덱스에 값을 삽입가능한것아닌지?
    	checkPositionIndex(index);
    	if(index==0)
    		addFirst(element);
    	else
    		addAfter(element, node(index-1)); //이 노드에집어넣어라 여기서의 node는 이미존재하는것, 앞에서 checkpositionindex로이미체크됨
    }


	private void addAfter(E element, Node<E> node) {
        Node<E> newNode = new Node<>(node, element, node.next);
        node.next = newNode;
        size++;
        
        if(newNode.next==null) {
        	last=newNode;
        }
        else {
        newNode.next.prev=newNode;
        }
	}

//	private void checkPositionIndex(int index) {
//		if(index>0 && index<=size)
//			return;
//		else
//			throw new IndexOutOfBoundsException();
//	}
	
	private void checkPositionIndex(int index) {
		if(index>=0 && index<=size)
			return;
		else
			throw new IndexOutOfBoundsException();
	}
	
	public E remove(int index) {
		checkElementIndex(index);
		if(index==0)
			return removeFirst();
		else if(index==size-1)//맨 마지막것 
			return removeLast();
		else {

		}
		Node<E> temp = node(index);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size--;
		return temp.item;

	}

    public void sort() {
		if(size<=1)
			return;
		E temp =null;
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				if(get(i).compareTo(get(j))<0) {    //get(i)<get(j)는 일반적이지 않다.
				
					temp = get(i);
				    set(i, get(j));
				    set(j, temp);
			}
		}
		}
	
	}
    

	private class Node<E> { //private 외부에서모르게하도록 
    	E item;
    	Node<E> next;
    	Node<E> prev;
    	
    	Node(Node<E> prev, E element, Node<E> next){
    		
    		this.item = element;
    		this.next = next;
    		this.prev = prev;
    	}
    }
	


	
}
