package week7;

public class queueTest {

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstu";
		
//		MyQueue q = new MyQueue(5);
//		
//		for(int i=0; i<str.length(); i++) {
//			if(q.isFull()) {
//				System.out.println(">>> Queue is Full!");
//			}
//			else {
//				q.enQueue(str.charAt(i));
//				System.out.println(q.toString());
//				System.out.println(q.deQueue());
//			}
//		}
		
		MyCircularQueue cq = new MyCircularQueue(5);
		
		for(int i=0; i<str.length(); i++) {
			if(cq.isFull()) {
				System.out.println(">>> Queue is Full!");
				break;
			}
			else {
				cq.enQueue(str.charAt(i));
				System.out.println(cq.toString());
				System.out.println(cq.deQueue());
			}
		}
	}
}
