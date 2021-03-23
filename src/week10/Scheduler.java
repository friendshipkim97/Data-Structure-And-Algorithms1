package week10;

public class Scheduler {
	MyLinkedList<Event> myEventList; //ArrayList �ڹٰ� �⺻������ �������ִ�Ŭ����, ���Ǽ��ڴ� �ڵ����� ���ִ¸޼ҵ带 �̿��Ѵ�. 
	String EventName;

	public Scheduler(String name) {

		myEventList = new MyLinkedList<Event>();
		EventName=name;
	}

	public void addEvent(String event, int pri) { //�������������ϴ�������Ȯ��
		Event e = new Event(event, pri); //t��� ��ü���� 
		//int index = findDegree(e);
		int index = findIndex(e);
		if(index<0)
			myEventList.add(e);
		else { //���� �����Ѵٸ� �켱���� �ʱ�ȭ, �Ȱ��� �̺�Ʈ�̸��̶�� �ֱٿ� ���°����� �ٲ��. 
			myEventList.set(index, e);
		}
		myEventList.sort(); //pri��sort�ϱ� 

	}
	
	public int findIndex(Event e) {
		int index=-1;
		for(int i=0; i<myEventList.size(); i++) {
			
			if(e.equals(myEventList.get(i))) { //EventŬ������ equals�޼ҵ带 �θ��°��̴�. 
				index = i ;
				break;
			}
		}
		return index;
	}

	public void deleteEvent(String event) {  //term����������, �迭�� ���⼭ �ٷ�⶧���� �ű������� 
		Event e = new Event(event, 1); //pri�� �ƹ� ���ڳ� ����־ �ӽ������� ����� 
		int index = findIndex(e);
		//int index = findDegree(e);

		if(index>=0)	
			deleteIndex(index);

	}

	private int findDegree(Event e) {

		int index=-1;

		for(int i=0; i<myEventList.size(); i++) //��ȣ�� �ٿ���� �޼ҵ带�θ��� �׳ɾ��� �������θ� 
		{

			if(e.equals(myEventList.get(i))) {

				index = myEventList.indexOf(myEventList.get(i)); //indexOf�޼ҵ�� �̹� �ڹٿ��� ���س����޼ҵ�, ���� ������ƮŸ������ �ޱ� ������ �ؽ��ڵ带 ���Ѵ�. ����γֱ����ؼ� TermŸ������ �ְ� ���ؾ���

			}
		}
		return index; //������ -1��ȯ �ڹٿ��� -1�̶�� ���س��� �� , indexOf�� ������Ʈ�ΰ��� �ޱ� ������ �ؽ��ڵ带 ��, ���ο�� ã������ ���ϴ°��̴�.

	}

	private void deleteIndex(int index) {

		myEventList.remove(index);

	}



	public void printEvent() {
		System.out.println("������ ���:");

		for(int i=0; i<myEventList.size(); i++) {

			System.out.print("�켱���� " + myEventList.get(i).pri+"����: ");
			System.out.println(myEventList.get(i).toString()); //�ڹ��� ������ ����Ŭ���� objectŬ���� 


		}
	}

	public void numberOfEvent() {
		System.out.println("������ ����: " +myEventList.size() + "��");// TODO Auto-generated method stub

	}


}