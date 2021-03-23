
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
//        Arrays.sort(original); //�ν��Ͻ��� �����ϰ� ���� �ʴ������� arraysŬ������ �޼ҵ�� Ŭ�����޼ҵ��̹Ƿ� ��ü�� �������� �ʰ� �ٷ� ����� �����ϴ�.
//        System.out.println();
//        for(int a : original) System.out.print(a+"   ");
//        System.out.println();
//        System.out.println(Arrays.binarySearch(original, 123));
//        
        int [] myData = new int[dataSize];
        //myData = original; //�̷����ع����� �����͸� �����ϴ°��̱⶧���� myData�� ������ �ٲ�� original�� ���뵵�ٲ��.
        copyData(myData, original);
        MySelection s = new MySelection(myData);//parrent �� �ν��Ͻ� s
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
        
        //s=me; //�⺻���� s(�⺻��+����)���ִ°��� �Ұ����ϴ�.
        //me=s; //s(�⺻��+����)�� �⺻���� �ִ°��������ϴ�. ������ s�ȿ��ִ� �޼��带 me.selectionsort������ �θ��°��� �Ұ����ϴ� me��ü�������ִ� �޼��带 ȣ���Ҽ��ִ�. 
        //���� ĳ�������ϰų� meŬ�����ȿ� �޼��带�������Ѵ�. 
        
	}

	private static void copyData(int[] myData, int[] original) {
		for(int i=0; i<original.length; i++)
			myData[i] = original[i];
		
	}

}
