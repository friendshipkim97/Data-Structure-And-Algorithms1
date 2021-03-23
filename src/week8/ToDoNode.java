package week8;
public class ToDoNode {
	String work;
	ToDoNode next;
	
	public ToDoNode(String s) {
		work=s;
		next=null;
	}

	public static void main(String[] args) {
		ToDoNode toDoList = new ToDoNode("homework");
		toDoList.next = new ToDoNode("traing");
		toDoList.next.next = new ToDoNode("cleaning");
		toDoList.next.next.next = new ToDoNode("service");
		
		System.out.println(">>> To-Do List");
		ToDoNode position = toDoList;
		
		while(position!=null) {
			System.out.println(position.work);
			position=position.next;
		}
		
		ToDoNode newWork = new ToDoNode("date"); //현재이렇게 객체를 생성하는건 work에는 "date" next에는 null값이들어있다. newWork에는 그 주소 값이 저장 
		newWork.next = toDoList; //toDoList의정보를넣는것 
		toDoList = newWork;
	
		
		System.out.println(">>> New To-Do List");
		position = toDoList;
		
		while(position!=null) {
			System.out.println(position.work);
			position=position.next;  //그 다음걸로 넘어가는과정 
		}
	}
}
