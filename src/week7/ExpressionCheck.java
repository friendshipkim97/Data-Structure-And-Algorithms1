package week7;

public class ExpressionCheck {
	
	private int maxLength; //public �� �ܺο������°��̶�� private�� ���ο������°�, �ܺο��� �������� �ʾƾ� �� ���̴�. 
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
				exp.push(ch); break; //���⼭ break�� ������ ������ �Ʒ��� �Ѿ�� ������ ���ش�.
			case ')':
				pair ='(';
				if(exp.isEmpty()) return false;
				checked = exp.pop(); //pop�� ���ÿ� �ִ� item�� ��ȯ�ϴ°� ��ȯ�ϰ� �ε������� ���̱� ������ ������
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
		String str = "-{(1+2)-(4*5)}*{6/7}-1";  	//������ ��ġ�� ���������� ��ȣ�� �ִ����� �Ǵ� ��ȣ�� ��Ī�Ǿ��־���ϹǷ� , ��ȣ�� �ְ���ϴ°�
		
		System.out.println(">>> Exp. Check : " + me.check(str));
	}

}
