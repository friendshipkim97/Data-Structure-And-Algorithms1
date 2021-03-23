package week7;

public class PolynomArray {
   
	Term [] myP;
	int arraySize = 20;
    int nOfTerms;
    String polyName;
    
    public PolynomArray(String name) {
    	myP = new Term[arraySize];
    	nOfTerms=0;  //항의 개수
    	polyName=name;
    }
    
    public void addTerm(int c, int e) { //지수항이존재하는지여부확인
    	Term t = new Term(c,e); //t라는 객체생성 
    	int index = findDegree(t);
    	if(index<0)   //없으면항목추가
    		myP[nOfTerms++]=t;
    	else {  //있다면 계수값을 더해서 0이면 있던항목을없앤다.
    		myP[index] = myP[index].add(t);
    		if (myP[index]==null)
    			deleteIndex(index);
    		//else  //그렇지 않으면 원래 있던 계수에 더해준다.
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

	public void deleteTerm(Term t) {  //term을직접받음, 배열을 여기서 다루기때문에 옮기지않음 
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
    		System.out.print(temp+ myP[i].toString()); //자바의 모든것의 상위클래스 object클래스 
    		temp = " + "; //처음에는 더하기를 안찍고 두번째에부터는 더하기를 찍는다.
    		
    	}
    }

	public void deleteTerm(int e) {
		Term t = new Term(1,e);
		deleteTerm(t);
		
	}
}
