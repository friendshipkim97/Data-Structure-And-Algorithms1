package week9;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyLinkedList<E extends Comparable<E>>{ //확장된 부분까지 파라미터로 받는 것 

	int size = 0;
	
	Node<E> first;
	
	public MyLinkedList() {
		
	}
	
	public E removeFirst() {
		Node<E> f = first;
		if(f==null)
			throw new NoSuchElementException();
		else {
		    first = f.next; //지우는 과정 
		    size--;
		    return f.item;
		}
	}

    public E removeLast() {
    	Node<E> f = first;
		if(f==null) //아무것도없을경우 Node<E>클래스안에 예외
			throw new NoSuchElementException();
		else {
			if(f.next==null) { //f.next==null이라는 것은 마지막값 이라는 것을 의미한다. 
				return removeFirst();
				//first=null; size--; return f.item;
			}
			while(f.next.next!=null) {
				f=f.next;	
			}
			E element = f.next.item;
			size--;
			f.next=null;
			return element;
		}
		
	}
    
    public boolean remove(E e) { //같은 값을 갖고 있는 것을 찾아서 제거 
    	
    	Node<E> f1 = first;
    	if(f1==null) 
    		return false;
    	if(e.equals(f1.item)) { //첫번째것에 대한 처리 
    		removeFirst();
    		return true;
    	}
    	Node<E> f2 = f1.next;
    	while(f2!=null) { //마지막값이 아닐 때까지 반복
    		if(e.equals(f2.item)) {
    			f1.next=f2.next;
    			size--;
    			return true;
    		}
    		else {
    			f1=f1.next;
    			f2=f2.next;
    		}
    	}
    	
    	return false;
    	
    }
    
    public void addFirst(E e) {
    	Node<E> newNode = new Node<>(e, first);
    	first=newNode;
    	size++;
    	
    }
    
    public void addLast(E e) {
    	Node<E> f = first;
    	if(f==null)
    		addFirst(e);
    	else {
    		while(f.next!=null) 
    			{f=f.next;
    			}
    			
    			Node<E> newNode = new Node<>(e, null);
    			f.next=newNode;
    			size++;
    		
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
			if(e.equals(x.item))
				return index;
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
    
    public void add(int index, E element) {
    	checkPositionIndex(index);
    	if(index==1)
    		addFirst(element);
    	else
    		addAfter(element, node(index-1)); //이 노드에집어넣어라 
    }


	private void addAfter(E element, Node<E> node) {
        Node<E> next = node.next;
        node.next = new Node<>(element, next);
        size++;
	}

	private void checkPositionIndex(int index) {
		if(index>0 && index<=size)
			return;
		else
			throw new IndexOutOfBoundsException();
	}
	
	public E remove(int index) {
		checkElementIndex(index);
		if(index==0)
			return removeFirst();
		else 
			return removeAfter(node(index-1)); //제거할 위치의 앞에것을 찾아내서 연결해줘야함. 
	}


	private E removeAfter(Node<E> node) {
		E element = node.next.item; // node.next.item이 지워지는 것이므로 저장. 
		node.next=node.next.next;
		size--;
		return element;
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
    	
    	Node(E element, Node<E> next){
    		this.item = element;
    		this.next = next;
    	}
    }
	


	
}
