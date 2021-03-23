
package week6;
import java.util.Arrays;

public class SortAnalysis {

	public static void main(String[] args) {
		int dataSize =  1000;
		SortBase me = new SortBase(dataSize);
        int[] original = me.createData();
        me.sort();
        me.showInfo();
        
//        for(int a : original) System.out.print(a+ "   ");
//        Arrays.sort(original); //인스턴스를 생성하고 쓰지 않는이유는 arrays클래스의 메소드는 클래스메소드이므로 객체를 생성하지 않고 바로 사용이 가능하다.
//        System.out.println();
//        for(int a : original) System.out.print(a+"   ");
//        System.out.println();
//        System.out.println(Arrays.binarySearch(original, 123));
//        
        int [] myData = new int[dataSize];
        //myData = original; //이렇게해버리면 포인터를 저장하는것이기때문에 myData의 내용이 바뀌면 original의 내용도바뀐다.
        copyData(myData, original);
        MySelection s = new MySelection(myData);//parrent 의 인스턴스 s
        s.sort();
        s.showInfo();
        
        copyData(myData, original);
        MyBubble b = new MyBubble(myData);
        b.sort();
        b.showInfo();
        
        copyData(myData, original);
        MyQuick q = new MyQuick(myData);
        q.sort();
        q.showInfo();
        
        copyData(myData, original);
        MyMerge m = new MyMerge(myData);
        m.sort(myData, 0, dataSize-1);
        m.showInfo();
        
        me = m;
        ((MyMerge) me).arrayLength();
        
        //s=me; //기본형을 s(기본형+알파)에넣는것은 불가능하다.
        //me=s; //s(기본형+알파)를 기본형에 넣는것은가능하다. 하지만 s안에있는 메서드를 me.selectionsort식으로 부르는것은 불가능하다 me자체에속해있는 메서드를 호출할수있다. 
        //따라서 캐스팅을하거나 me클래스안에 메서드를만들어야한다. 
        
	}

	private static void copyData(int[] myData, int[] original) {
		for(int i=0; i<original.length; i++)
			myData[i] = original[i];
		
	}

}
