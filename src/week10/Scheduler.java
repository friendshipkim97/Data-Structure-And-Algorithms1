package week10;

public class Scheduler {
	MyLinkedList<Event> myEventList; //ArrayList 자바가 기본적으로 제공해주는클래스, 항의숫자는 자동으로 세주는메소드를 이용한다. 
	String EventName;

	public Scheduler(String name) {

		myEventList = new MyLinkedList<Event>();
		EventName=name;
	}

	public void addEvent(String event, int pri) { //지수항이존재하는지여부확인
		Event e = new Event(event, pri); //t라는 객체생성 
		//int index = findDegree(e);
		int index = findIndex(e);
		if(index<0)
			myEventList.add(e);
		else { //만약 존재한다면 우선순위 초기화, 똑같은 이벤트이름이라면 최근에 들어온것으로 바뀐다. 
			myEventList.set(index, e);
		}
		myEventList.sort(); //pri로sort하기 

	}
	
	public int findIndex(Event e) {
		int index=-1;
		for(int i=0; i<myEventList.size(); i++) {
			
			if(e.equals(myEventList.get(i))) { //Event클래스의 equals메소드를 부르는것이다. 
				index = i ;
				break;
			}
		}
		return index;
	}

	public void deleteEvent(String event) {  //term을직접받음, 배열을 여기서 다루기때문에 옮기지않음 
		Event e = new Event(event, 1); //pri는 아무 숫자나 집어넣어서 임시적으로 만든것 
		int index = findIndex(e);
		//int index = findDegree(e);

		if(index>=0)	
			deleteIndex(index);

	}

	private int findDegree(Event e) {

		int index=-1;

		for(int i=0; i<myEventList.size(); i++) //괄호를 붙여줘야 메소드를부른다 그냥쓰면 변수를부름 
		{

			if(e.equals(myEventList.get(i))) {

				index = myEventList.indexOf(myEventList.get(i)); //indexOf메소드는 이미 자바에서 정해놓은메소드, 따라서 오브젝트타입으로 받기 때문에 해쉬코드를 비교한다. 제대로넣기위해선 Term타입으로 넣고 비교해야함

			}
		}
		return index; //없으면 -1반환 자바에서 -1이라고 정해놓은 것 , indexOf가 오브젝트로값을 받기 때문에 해쉬코드를 비교, 새로운값을 찾아주지 못하는것이다.

	}

	private void deleteIndex(int index) {

		myEventList.remove(index);

	}



	public void printEvent() {
		System.out.println("스케줄 목록:");

		for(int i=0; i<myEventList.size(); i++) {

			System.out.print("우선순위 " + myEventList.get(i).pri+"순위: ");
			System.out.println(myEventList.get(i).toString()); //자바의 모든것의 상위클래스 object클래스 


		}
	}

	public void numberOfEvent() {
		System.out.println("스케줄 개수: " +myEventList.size() + "개");// TODO Auto-generated method stub

	}


}