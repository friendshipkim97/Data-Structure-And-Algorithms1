package week9;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyLinkedList<E extends Comparable<E>>{ //Ȯ��� �κб��� �Ķ���ͷ� �޴� �� 

	int size = 0;
	
	Node<E> first;
	
	public MyLinkedList() {
		
	}
	
	public E removeFirst() {
		Node<E> f = first;
		if(f==null)
			throw new NoSuchElementException();
		else {
		    first = f.next; //����� ���� 
		    size--;
		    return f.item;
		}
	}

    public E removeLast() {
    	Node<E> f = first;
		if(f==null) //�ƹ��͵�������� Node<E>Ŭ�����ȿ� ����
			throw new NoSuchElementException();
		else {
			if(f.next==null) { //f.next==null�̶�� ���� �������� �̶�� ���� �ǹ��Ѵ�. 
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
    
    public boolean remove(E e) { //���� ���� ���� �ִ� ���� ã�Ƽ� ���� 
    	
    	Node<E> f1 = first;
    	if(f1==null) 
    		return false;
    	if(e.equals(f1.item)) { //ù��°�Ϳ� ���� ó�� 
    		removeFirst();
    		return true;
    	}
    	Node<E> f2 = f1.next;
    	while(f2!=null) { //���������� �ƴ� ������ �ݺ�
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
    	
    	return (indexOf(e) >= 0); //���� 0�̻��ϰ�� true�� ��ȯ �ƴϸ� false�� ��ȯ 
    }
    
    public int indexOf(E e) {
		int index=0;
		for(Node<E> x = first; x!=null; x=x.next) {
			if(e.equals(x.item))
				return index;
			index++; //return�̴ϱ� else�� ����ȴ�. 
		}
		return -1;
	}

	public int size() {
    	 return size;
    }
    
    public E get(int index) { // index�� 0���� size-1���� 
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
    	Node<E> f = node(index); //index���� ��������ִ��� ã�� ���� 
    	E oldVal = f.item;
    	f.item = element;
    	return oldVal;
    	
    }
    
    public void add(int index, E element) {
    	checkPositionIndex(index);
    	if(index==1)
    		addFirst(element);
    	else
    		addAfter(element, node(index-1)); //�� ��忡����־�� 
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
			return removeAfter(node(index-1)); //������ ��ġ�� �տ����� ã�Ƴ��� �����������. 
	}


	private E removeAfter(Node<E> node) {
		E element = node.next.item; // node.next.item�� �������� ���̹Ƿ� ����. 
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
				if(get(i).compareTo(get(j))<0) {    //get(i)<get(j)�� �Ϲ������� �ʴ�.
				
					temp = get(i);
				    set(i, get(j));
				    set(j, temp);
			}
		}
		}
	
	}
    

	private class Node<E> { //private �ܺο����𸣰��ϵ��� 
    	E item;
    	Node<E> next;
    	
    	Node(E element, Node<E> next){
    		this.item = element;
    		this.next = next;
    	}
    }
	


	
}
