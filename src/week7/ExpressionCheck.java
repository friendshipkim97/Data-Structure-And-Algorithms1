package week7;

public class ExpressionCheck {
	
	private int maxLength; //public 은 외부에서쓰는것이라면 private은 내부에서쓰는것, 외부에서 보여지지 않아야 할 것이다. 
	private MyStack exp;
	public ExpressionCheck(int size) {
		maxLength=size;
		exp = new MyStack(maxLength);
	}
	
	public boolean check(String str) {
		char pair, checked;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			switch(ch) {
			case '(':
			case '{':
			case '[':
				exp.push(ch); break; //여기서 break를 해주지 않으면 아래로 넘어가기 때문에 해준다.
			case ')':
				pair ='(';
				if(exp.isEmpty()) return false;
				checked = exp.pop(); //pop은 스택에 있는 item을 반환하는것 반환하고 인덱스값을 줄이기 때문에 없어짐
				if(pair!=checked) return false;
				break;
			case '}':
				pair ='{';
				if(exp.isEmpty()) return false;
				checked = exp.pop();
				if(pair!=checked) return false;
				break;
			case ']':
				pair ='[';
				if(exp.isEmpty()) return false;
				checked = exp.pop();
				if(pair!=checked) return false;
				break;
			}
		}
			return exp.isEmpty();	
	}
	
	public static void main(String[] args) {
		ExpressionCheck me = new ExpressionCheck(20);
		String str = "-{(1+2)-(4*5)}*{6/7}-1";  	//적절한 위치에 같은종류의 괄호가 있는지를 판단 괄호가 대칭되어있어야하므로 , 괄호만 넣고비교하는것
		
		System.out.println(">>> Exp. Check : " + me.check(str));
	}

}
