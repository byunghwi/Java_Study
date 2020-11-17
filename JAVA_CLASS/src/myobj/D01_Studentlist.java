package myobj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class D01_Studentlist {

	//학생클래스를 요소로 갖는 ArrayList를 생성하고, 학생을 30명 추가해보세요.
	
	// 1. 30명의 점수가 자동으로 설정되도록 만들어 보세요.
	// 2. 모든 학생의 총 점수와 평균 점수를 구해보세요.
	// 3. 반 평균을 구하라.
	
	//	이름 생성 규칙
	// 	테스트학생0000
	// 	테스트학생0001
	public static void main(String[] args) {
		ArrayList<Student> group = new ArrayList<Student>();
		
		int totalClass = 0;
		for (int i = 0; i < 30; i++) {
			group.add(new Student());
			totalClass = group.get(i).getClassTotal();
		}
		
		
		//정렬 한번에 하기.
		Collections.sort(group, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
//				Comparable s1 = (Comparable) o1.eng;
//				Comparable s2 = (Comparable) o2.eng;
//				return s1.compareTo(s2) * -1;
				
				if(o1.eng > o2.eng)
					return -1;
				else if(o1.eng < o2.eng)
					return 1;
				else
					return 0;

			}
		});
		System.out.println(group);
		System.out.printf("\n\t현재 반의 총 점과 평균은  > %d / %.2f" , totalClass  , (double)(totalClass/group.size()));
		
	}	
}

class Student{
	public String name;
	public int kor, eng, math, total;
	public double avg;
	public static int studentCount = 0;
	public static int totalClass = 0;
	

	public Student() {
		super();
			eng = (int)(Math.random()*101);
			kor = (int)(Math.random()*101);
			math = (int)(Math.random()*101);
			total = eng + kor + math;
			avg = total/3;
			name = "테스트학생"+String.format("%04d", studentCount++);
	}
	
	public int getClassTotal() {
		totalClass += total;
		return totalClass;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", avg=" + avg + "]\n";
	}

}