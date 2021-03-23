package week7;

import java.util.ArrayList;

public class Polynom {
	ArrayList<Term> myP; //ArrayList �ڹٰ� �⺻������ �������ִ�Ŭ����, ���Ǽ��ڴ� �ڵ����� ���ִ¸޼ҵ带 �̿��Ѵ�. 
    String polyName;
    
    public Polynom(String name) {
    	myP = new ArrayList<Term>();
    	polyName=name;
    }
    
    public void addTerm(int c, int e) { //�������������ϴ�������Ȯ��
    	Term t = new Term(c,e); //t��� ��ü���� 
    	int index = findDegree(t);
    	if(index<0)   //�������׸��߰�
    		myP.add(t); //�ϳ��� ���°� 
    	else {  //�ִٸ� ������� ���ؼ� 0�̸� �ִ��׸������ش�.
    		myP.set(index, myP.get(index).add(t)); //�ϳ��� ���̵Ǵ°��̴�. 
    		if (myP.get(index)==null)
    			deleteIndex(index);		
    	}
    }
    
    private void deleteIndex(int index) {
    	myP.remove(index);
		
	}

	private int findDegree(Term t) {
		
//		return myP.indexOf(t);

		int index=-1;
		for(Term s : myP) 
			if(t.equals(s)) index = myP.indexOf(s); //indexOf�޼ҵ�� �̹� �ڹٿ��� ���س����޼ҵ�, ���� ������ƮŸ������ �ޱ� ������ �ؽ��ڵ带 ���Ѵ�. ����γֱ����ؼ� TermŸ������ �ְ� ���ؾ���
		return index; //������ -1��ȯ �ڹٿ��� -1�̶�� ���س��� �� , indexOf�� ������Ʈ�ΰ��� �ޱ� ������ �ؽ��ڵ带 ��, ���ο�� ã������ ���ϴ°��̴�.
	}

	public void deleteTerm(Term t) {  //term����������, �迭�� ���⼭ �ٷ�⶧���� �ű������� 
    	int index =findDegree(t);
    	if(index>=0)	
			deleteIndex(index);

    }
    
    public int calculate(int x) {
    	int result = 0;
    	for(Term t : myP)
    		result = result + t.value(x);
    	
    	return result;
    }
    
    public void printPoly() {
    	
    	System.out.print("---Function "+ polyName + " = ("+myP.size()+") ");
    	String temp ="";
    	for(Term t : myP) {
    		System.out.print(temp+ t.toString()); //�ڹ��� ������ ����Ŭ���� objectŬ���� 
    		temp = " + "; //ó������ ���ϱ⸦ ����� �ι�°�����ʹ� ���ϱ⸦ ��´�.
    		
    	}
    }

	public void deleteTerm(int e) {
		Term t = new Term(1,e);
		deleteTerm(t);
		
	}
}