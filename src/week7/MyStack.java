package week7;

public class MyStack {

	int stackSize;
	int top;
	char stackArray[];
	
	public MyStack(int size) {
		top = -1;
		stackSize = size;
		stackArray = new char[stackSize];
	}
	
	public boolean isEmpty() {
		if(top<0) return true;
		else
		return false;
	}
	
    public boolean isFull() {
    	if(top==stackSize-1) return true;
		else
		return false;
	}
    
    public boolean push(char c) {
    	if(isFull()) return false;
    	stackArray[++top]=c; //top�� ���� ������Ű�� �ִ°� 
    	return true;
    }
    
    public char pop() {
    	if(isEmpty()) return (Character) null;
    	return stackArray[top--]; //���� ���̱����� �ְ� ���°�
    }
    
    public char peek() {
    	if(isEmpty()) return (Character) null;
    	return stackArray[top--]; //���� ���̱����� �ְ� ���°�

    }
    
    
	
}
