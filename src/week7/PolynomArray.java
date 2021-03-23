package week7;

public class PolynomArray {
   
	Term [] myP;
	int arraySize = 20;
    int nOfTerms;
    String polyName;
    
    public PolynomArray(String name) {
    	myP = new Term[arraySize];
    	nOfTerms=0;  //���� ����
    	polyName=name;
    }
    
    public void addTerm(int c, int e) { //�������������ϴ�������Ȯ��
    	Term t = new Term(c,e); //t��� ��ü���� 
    	int index = findDegree(t);
    	if(index<0)   //�������׸��߰�
    		myP[nOfTerms++]=t;
    	else {  //�ִٸ� ������� ���ؼ� 0�̸� �ִ��׸������ش�.
    		myP[index] = myP[index].add(t);
    		if (myP[index]==null)
    			deleteIndex(index);
    		//else  //�׷��� ������ ���� �ִ� ����� �����ش�.
    			//myP[index].coef += t.coef;
    	}
    }
    
    private void deleteIndex(int index) {
    	for(int i=index; i<nOfTerms-1; i++)
			myP[i]=myP[i+1];
	nOfTerms--;
		
	}

	private int findDegree(Term t) {
		int index = -1;
		for(int i=0; i<nOfTerms; i++) {
			if(myP[i].equals(t)) index=i;
		}
		return index;
	}

	public void deleteTerm(Term t) {  //term����������, �迭�� ���⼭ �ٷ�⶧���� �ű������� 
    	int index =findDegree(t);
    	if(index>=0)	
			deleteIndex(index);

    }
    
    public int calculate(int x) {
    	int result = 0;
    	for(int i=0; i<nOfTerms; i++)
    		result = (result + myP[i].value(x));
    	
    	return result;
    }
    
    public void printPoly() {
    	
    	System.out.print("---Function "+ polyName + " = ("+nOfTerms+") ");
    	String temp ="";
    	for(int i=0; i<nOfTerms; i++) {
    		System.out.print(temp+ myP[i].toString()); //�ڹ��� ������ ����Ŭ���� objectŬ���� 
    		temp = " + "; //ó������ ���ϱ⸦ ����� �ι�°�����ʹ� ���ϱ⸦ ��´�.
    		
    	}
    }

	public void deleteTerm(int e) {
		Term t = new Term(1,e);
		deleteTerm(t);
		
	}
}
