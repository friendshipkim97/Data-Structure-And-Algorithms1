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
    	stackArray[++top]=c; //top을 먼저 증가시키고 넣는것 
    	return true;
    }
    
    public char pop() {
    	if(isEmpty()) return (Character) null;
    	return stackArray[top--]; //값을 줄이기전에 넣고 빼는것
    }
    
    public char peek() {
    	if(isEmpty()) return (Character) null;
    	return stackArray[top--]; //값을 줄이기전에 넣고 빼는것

    }
    
    
	
}
