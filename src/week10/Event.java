package week10;

import week7.Term;

public class Event implements Comparable<Event>{ //Comparable<Event>�� ������ �ڹٰ� ������ �޼ҵ带 ����ɷ� ���� 
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
		return (this.eventName.equals(e.eventName)); //==�ϸ� �ּҰ��� equals���ؾ� ������Ѵ�. ==�� �����̿ܿ� ���Ǿ���. 
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
