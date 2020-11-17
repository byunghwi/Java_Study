package quiz;

import java.util.ArrayList;

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
		
		int eng, kor, math, total;
		double avg;
		
		int totalClass = 0;
		for (int i = 0; i < 30; i++) {

			eng = (int)(Math.random()*101);
			kor = (int)(Math.random()*101);
			math = (int)(Math.random()*101);
			total = eng + kor + math;
			avg = total/3;
			
			group.add(new Student("테스트학생"+String.format("%04d", i), eng, kor, math, avg, total));
			
			totalClass += total;
		}
		
//		for(Student st : group) {
//			System.out.printf( "%s\t영어: %d\t국어: %d\t수학: %d\t평균: %.2f\t총 점: %d\n", st.name, st.eng, st.kor, st.math, st.avg, st.total);
//		}
		
		System.out.println(group);
		System.out.printf("\n\t현재 반의 총 점과 평균은  > %d / %.2f" , totalClass, (double)(totalClass/group.size()));
	}
	
}

class Student{
	String name;
	int kor, eng, math, total;
	double avg;
	
	public Student(String name, int kor, int eng, int math, double avg, int total) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.avg = avg;
		this.total = total;
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", avg=" + avg + "]\n";
	}
	
	
}