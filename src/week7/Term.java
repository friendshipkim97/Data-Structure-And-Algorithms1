package week7;

public class Term {

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
	
	public boolean equals(Term t) {
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
}
