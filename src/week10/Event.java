package week10;

import week7.Term;

public class Event implements Comparable<Event>{ //Comparable<Event>가 없으면 자바가 임의의 메소드를 만들걸로 생각 
	String eventName;
	int pri;

	public Event(String eventName, int p) {
		this.eventName=eventName;
		this.pri=p;
	}
	
	public String toString() {  
		return eventName;
	}

	public boolean equals(Event e) {
		return (this.eventName.equals(e.eventName)); //==하면 주소값비교 equals로해야 내용비교한다. ==은 숫자이외에 거의없다. 
	}
	

	 public int compareTo(Event e) { 
	    	if (this.pri>e.pri)
	    		return -1;
	    	else if (this.pri==e.pri)
	    		return 1;
	    	else
	    		return 0;
	    	
	    }
//	 public int compareTo(Event e) { 
//	    	if (this.pri<e.pri)
//	    		return -1;
//	    	else if (this.pri>e.pri)
//	    		return 1;
//	    	else
//	    		return 0;
//	    	
//	    }
}
