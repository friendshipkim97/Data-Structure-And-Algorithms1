package week7;

public class MyCircularQueue {
	private int front, rear;
	private int qSize;
	private char qArray[];
	
	public MyCircularQueue(int size) {
		front = 0;
		rear = 0;
		qSize = size;
		qArray = new char [qSize];
	}
	
	public boolean isEmpty() {
		return (front==rear); //같으면 true를 리턴하는것이다. 
	}
	
	public boolean isFull() {
		return (front == (rear+1)%qSize);
	}
	
	public boolean enQueue(char c) {
		if (isFull()) return false;
		rear = (rear+1)%qSize;
		qArray[rear] = c; 
		return true;
	}
	
	public char deQueue() {
		if(isEmpty()) return 0; //dequeue를 해주기 때문에 이 프로그램에서는 포화상태가 일어나지않는다 만약 사이즈가 5인데 rear가 4고 front가 0이라면 포화상태가 일어난다. 따라서 test클래스에서 넣고바로 빼준다.
		front =(front+1)%qSize;
		return qArray[front];
	}
	
	public char peek() {
		if(isEmpty()) return (Character) null;
		return qArray[(front+1)%qSize]; //queue에 front에있는 원소를 반환 
	}
	
	public String toString() {
		String result = "";
		for(int i=0; i<qSize; i++)
			result += qArray[i];
		return result;
	}
}
