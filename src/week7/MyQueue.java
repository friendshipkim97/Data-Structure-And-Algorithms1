package week7;

public class MyQueue {

	private int front, rear;
	private int qSize;
	private char qArray[];
	
	public MyQueue(int size) {
		front = -1;
		rear = -1;
		qSize = size;
		qArray = new char [qSize];
	}
	
	public boolean isEmpty() {
		return (front==rear);
	}
	
	public boolean isFull() {
		return (rear==qSize-1);
	}
	
	public boolean enQueue(char c) {
		if (isFull()) return false;
		qArray[++rear] = c; //rear�� 1�����Ȼ��·� �߰��ϴ°�
		return true;
	}
	
	public char deQueue() {
		if(isEmpty()) return 0;
		return qArray[++front];
	}
	
	public char peek() {
		if(isEmpty()) return (Character) null;
		return qArray[++front]; //queue�� front���ִ� ���Ҹ� ��ȯ 
	}
	
	public String toString() {
		String result = "";
		for(int i=0; i<qSize; i++)
			result += qArray[i];
		return result;
	}
}
