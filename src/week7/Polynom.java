package week7;

import java.util.ArrayList;

public class Polynom {
	ArrayList<Term> myP; //ArrayList 자바가 기본적으로 제공해주는클래스, 항의숫자는 자동으로 세주는메소드를 이용한다. 
    String polyName;
    
    public Polynom(String name) {
    	myP = new ArrayList<Term>();
    	polyName=name;
    }
    
    public void addTerm(int c, int e) { //지수항이존재하는지여부확인
    	Term t = new Term(c,e); //t라는 객체생성 
    	int index = findDegree(t);
    	if(index<0)   //없으면항목추가
    		myP.add(t); //하나가 들어가는것 
    	else {  //있다면 계수값을 더해서 0이면 있던항목을없앤다.
    		myP.set(index, myP.get(index).add(t)); //하나의 항이되는것이다. 
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
			if(t.equals(s)) index = myP.indexOf(s); //indexOf메소드는 이미 자바에서 정해놓은메소드, 따라서 오브젝트타입으로 받기 때문에 해쉬코드를 비교한다. 제대로넣기위해선 Term타입으로 넣고 비교해야함
		return index; //없으면 -1반환 자바에서 -1이라고 정해놓은 것 , indexOf가 오브젝트로값을 받기 때문에 해쉬코드를 비교, 새로운값을 찾아주지 못하는것이다.
	}

	public void deleteTerm(Term t) {  //term을직접받음, 배열을 여기서 다루기때문에 옮기지않음 
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
    		System.out.print(temp+ t.toString()); //자바의 모든것의 상위클래스 object클래스 
    		temp = " + "; //처음에는 더하기를 안찍고 두번째에부터는 더하기를 찍는다.
    		
    	}
    }

	public void deleteTerm(int e) {
		Term t = new Term(1,e);
		deleteTerm(t);
		
	}
}