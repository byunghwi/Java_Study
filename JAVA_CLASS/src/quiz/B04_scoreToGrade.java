package quiz;

import java.util.Scanner;

public class B04_scoreToGrade {
	public static void main(String[] args) {
		// 90이상 A ,  80이상 B , 70이상 C, 60이상 D, 그 외 F
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		char grade;
		
		if(score >=0 && score <= 100) {
			
			if(score >= 90) {
				grade = 'A';
			}else if(score >= 80) {
				grade = 'B';
			}else if(score >= 70) {
				grade = 'C';
			}else if(score >= 60) {
				grade = 'D';
			}else {
				grade = 'F';
			}
			
		}else {
			System.out.println("0~100사이의 점수만 입력 가능합니다.");
			return;
		}
		
		System.out.println("등급은 : " + grade + " 입니다.");
	}
}
