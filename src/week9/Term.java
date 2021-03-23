package week9;

import java.util.Comparator;

public class Term implements Comparable<Term>{  //�������̽� ����

	int coef;
	int exp;

	
	public Term(int c, int e) {
		coef =c; //coefficent ���
		exp = e; //exponent ����
	} 
	
	public String toString() {  //������������ �ؽ��ڵ尪�� ��ȯ 
		if(coef==0) return "";
		else
			return coef+"X^"+exp;
	}
	
	public boolean equals(Term t) {  //�ؽ��ڵ带 ���ϱ� ������ equals�� ���Ǵ� �̷��ž� ��� �����Ѱ��̴�.
		return (this.exp==t.exp);
	}

	public Term add(Term t) {
		this.coef += t.coef;
		if(coef==0) return null;
		else 
		    return this;
	}
	
	public int value(int x) {
		return (int) (coef*Math.pow(x, this.exp));
	}
	
    public int compareTo(Term o) { //���������ϴ¸޼���
    	if (this.exp<o.exp)
    		return -1;
    	else if (this.exp==o.exp)
    		return 0;
    	else
    		return 1;
    	
    }
    
    public int compare(Term i, Term j) { //���������ϴ¸޼���
    	if (i.exp<j.exp)
    		return -1;
    	else if (i.exp==j.exp)
    		return 0;
    	else
    		return 1;
    	
    }
    
}
