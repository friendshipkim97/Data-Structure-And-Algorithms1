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
		return (front==rear); //������ true�� �����ϴ°��̴�. 
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
		if(isEmpty()) return 0; //dequeue�� ���ֱ� ������ �� ���α׷������� ��ȭ���°� �Ͼ���ʴ´� ���� ����� 5�ε� rear�� 4�� front�� 0�̶�� ��ȭ���°� �Ͼ��. ���� testŬ�������� �ְ�ٷ� ���ش�.
		front =(front+1)%qSize;
		return qArray[front];
	}
	
	public char peek() {
		if(isEmpty()) return (Character) null;
		return qArray[(front+1)%qSize]; //queue�� front���ִ� ���Ҹ� ��ȯ 
	}
	
	public String toString() {
		String result = "";
		for(int i=0; i<qSize; i++)
			result += qArray[i];
		return result;
	}
}
