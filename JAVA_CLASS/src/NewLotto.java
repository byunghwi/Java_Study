import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class NewLotto {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
	
		for (int  i= 0;  set.size() < 6; i++) {
			int num = (int)(Math.random()*45+1);
			set.add(num);
		}
		
		Iterator<Integer> it = set.iterator();
		
		System.out.print("로또번호 > ");
		
		int numArr[] = new int[6];

		for (int j = 0; it.hasNext(); j++) {
			numArr[j] = (int) it.next();
		}

		
		System.out.println(Arrays.toString(numArr));
	}
}

