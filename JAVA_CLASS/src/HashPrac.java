import java.util.HashSet;
import java.util.Iterator;

public class HashPrac {
	public static void main(String[] args) {
		
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		
		Iterator it = setA.iterator();
		
		
		setA.add("a");
		setA.add("b");
		setA.add("c");
		setA.add("d");
		setA.add("e");
		
		setB.add("b");
		setB.add("c");
		setB.add("e");
		setB.add("f");
		setB.add("g");
		int a = setA.hashCode();
		int b = setB.hashCode();
		
		
		it = setB.iterator();
		
		System.out.println(setA);
		System.out.println(a);
		System.out.println(b);
	}
}
