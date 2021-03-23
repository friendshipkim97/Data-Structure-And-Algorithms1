package week9;


public class Polynom {
	week9.MyLinkedList<Term> myP; //ArrayList �ڹٰ� �⺻������ �������ִ�Ŭ����, ���Ǽ��ڴ� �ڵ����� ���ִ¸޼ҵ带 �̿��Ѵ�. 
    String polyName;
    
    public Polynom(String name) {
    	myP = new week9.MyLinkedList<Term>();
    	polyName=name;
    }
    
    public void addTerm(int c, int e) { //�������������ϴ�������Ȯ��
    	Term t = new Term(c,e); //t��� ��ü���� 
    	int index = findDegree(t);
    	if(index<0) {  //�������׸��߰�
    		myP.add(t); //�ϳ��� ���°� 
    	}
    	else {  //�ִٸ� ������� ���ؼ� 0�̸� �ִ��׸������ش�.
    		myP.set(index, myP.get(index).add(t)); //�ϳ��� ���̵Ǵ°��̴�. 
    		if (myP.get(index)==null)
    			deleteIndex(index);		
    	}
    	myP.sort();
    	//myP.comparatorSort();
    }
    
    private void deleteIndex(int index) {
    	myP.remove(index);
		
	}

	private int findDegree(Term t) {
		
//		return myP.indexOf(t);

		int index=-1;
		for(int i=0; i<myP.size(); i++) 
			if(t.equals(myP.get(i))) index = myP.indexOf(myP.get(i)); //indexOf�޼ҵ�� �̹� �ڹٿ��� ���س����޼ҵ�, ���� ������ƮŸ������ �ޱ� ������ �ؽ��ڵ带 ���Ѵ�. ����γֱ����ؼ� TermŸ������ �ְ� ���ؾ���
		return index; //������ -1��ȯ �ڹٿ��� -1�̶�� ���س��� �� , indexOf�� ������Ʈ�ΰ��� �ޱ� ������ �ؽ��ڵ带 ��, ���ο�� ã������ ���ϴ°��̴�.
	}

	public void deleteTerm(Term t) {  //term����������, �迭�� ���⼭ �ٷ�⶧���� �ű������� 
    	int index =findDegree(t);
    	if(index>=0)	
			deleteIndex(index);

    }
    
    public int calculate(int x) {
    	int result = 0;
    	for(int i=0; i<myP.size(); i++) 
    		result = result + myP.get(i).value(x);
    	
    	return result;
    }
    
    public void printPoly() {
    	
    	System.out.print("---Function "+ polyName + " = ("+myP.size()+") ");
    	String temp ="";
    	for(int i=0; i<myP.size(); i++) {
    		
    		System.out.print(temp+ myP.get(i).toString()); //�ڹ��� ������ ����Ŭ���� objectŬ���� 
    		temp = " + "; //ó������ ���ϱ⸦ ����� �ι�°�����ʹ� ���ϱ⸦ ��´�.
    		
    	}
    }

	public void deleteTerm(int e) {
		Term t = new Term(1,e);
		deleteTerm(t);
		
	}
}