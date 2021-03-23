package week9;

import java.util.Comparator;

public class Term implements Comparable<Term>{  //인터페이스 구현

	int coef;
	int exp;

	
	public Term(int c, int e) {
		coef =c; //coefficent 계수
		exp = e; //exponent 지수
	} 
	
	public String toString() {  //해주지않으면 해쉬코드값을 반환 
		if(coef==0) return "";
		else
			return coef+"X^"+exp;
	}
	
	public boolean equals(Term t) {  //해쉬코드를 비교하기 때문에 equals의 정의는 이런거야 라고 정의한것이다.
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
	
    public int compareTo(Term o) { //지수를비교하는메서드
    	if (this.exp<o.exp)
    		return -1;
    	else if (this.exp==o.exp)
    		return 0;
    	else
    		return 1;
    	
    }
    
    public int compare(Term i, Term j) { //지수를비교하는메서드
    	if (i.exp<j.exp)
    		return -1;
    	else if (i.exp==j.exp)
    		return 0;
    	else
    		return 1;
    	
    }
    
}
