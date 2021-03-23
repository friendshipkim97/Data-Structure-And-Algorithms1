package week10;

import java.util.NoSuchElementException;

public class MyLinkedList<E extends Comparable<E>>{ //Ȯ��� �κб��� �Ķ���ͷ� �޴� �� 

	int size = 0; //�̷��Ծ��� week10������ public�̳� �ٸ�����. ���� ��Ű�����̹Ƿ� public�̶�� ��������� �ٸ� ��Ű�����������ִ�. 

	Node<E> first; //�Ŀ�����Ʈ������ head�̴�.
	Node<E> last;
	
	public MyLinkedList() {
		
	}
	
	public E removeFirst() {
		Node<E> f = first;
		if(f==null)
			throw new NoSuchElementException();
		else {
		    first = f.next; //����� ���� 
		    size--;
		    if(first==null) { //��尡 ���� �ϳ����ε� ������ �� 
		    	last=null;
		    }
		    else { //��尡 ���� �ΰ� �̻��̿��� �� 
		    	first.prev=null;
		    }
		    	
		    return f.item;
		}
	}

    public E removeLast() { //double linkedlist�� �������� ������Ⱑ ������������ 
    	
    	Node<E> l = last;
    	if(l==null) //�ƹ��͵����� linkedlist��� ���̴�. 
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
    
    public boolean remove(E e) { //���� ���� ���� �ִ� ���� ã�Ƽ� ���� 
    	
    	Node<E> f = first;
    	
    	while(f!=null) { //���������� �ƴ� ������ �ݺ�
    		if(e.equals(f.item)) {
    			if(f.prev==null) {//ù��°
    				removeFirst();
    			return true;
    		}
    			else if(f.next==null) { //������
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
    	Node<E> newNode = new Node<>(null, e, first); //������ ó����  prev�� null�̹Ƿ� 
    	first=newNode;
    	size++;
    	if(newNode.next==null) { //��尡 �ƹ��͵� �����µ� �߰��Ѱ��̶��
    		last=newNode;
    	}
    	else {
    		newNode.next.prev = newNode;
    	}
    	
    }
    
    public void addLast(E e) { //addfirst�� ���� �ݴ� 
    	Node<E> newNode = new Node<>(last, e, null); //������ ó����  prev�� null�̹Ƿ� 
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
    	
    	return (indexOf(e) >= 0); //���� 0�̻��ϰ�� true�� ��ȯ �ƴϸ� false�� ��ȯ 
    }
    
    public int indexOf(E e) {
		int index=0;
		for(Node<E> x = first; x!=null; x=x.next) {
			if(e.equals(x.item)) {
				System.out.println(index);
				return index;
			}
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
    //LinkedList
//    public void add(int index, E element) { // �����������ֽ��ڵ� 
//    	checkPositionIndex(index);
//    	if(index==1)
//    		addFirst(element);
//    	else
//    		addAfter(element, node(index-1)); //�� ��忡����־�� ���⼭�� node�� �̹������ϴ°�, �տ��� checkpositionindex���̹�üũ��
//    }
//    
    public void add(int index, E element) { // �̷��� �ؾ� ����ε����� ���� ���԰����Ѱ;ƴ���?
    	checkPositionIndex(index);
    	if(index==0)
    		addFirst(element);
    	else
    		addAfter(element, node(index-1)); //�� ��忡����־�� ���⼭�� node�� �̹������ϴ°�, �տ��� checkpositionindex���̹�üũ��
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
		else if(index==size-1)//�� �������� 
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
    	Node<E> prev;
    	
    	Node(Node<E> prev, E element, Node<E> next){
    		
    		this.item = element;
    		this.next = next;
    		this.prev = prev;
    	}
    }
	


	
}
