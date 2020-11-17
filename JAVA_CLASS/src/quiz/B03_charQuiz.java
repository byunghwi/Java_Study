package quiz;

public class B03_charQuiz {
	public static void main(String[] args) {
		char a = 'q';
		char b = '	';
		char c = '9';
		char d = 'b';
		char e = 'd';
		char f = 'a';
		
		
		boolean arr[] = new boolean[6];
		
		//Q1 -  q�� Q�쇰��
		boolean rs1 = (a ==113 || a == 81)?true:false;
		arr[0] = rs1;
		
		//Q2 - 怨듬갚�대�� ��
		boolean rs2 = (b != 0 || b != 9)?true:false;
		arr[1] = rs2;
		
		//Q3 - '0' ~ '9' �쇰�� 
		boolean rs3 = (c >= 48 && c <= 57)?true:false;
		arr[2] = rs3;
		
		//Q4 - ��臾몄��
		boolean rs4 = ( (d >= 97 && d <=122) || (d >= 65 && d <=90) )?true:false;
		arr[3] = rs4;

		//Q5 - ��湲�
		boolean rs5 = (e >= '\uAC00' && e <= '\uD7A3')?true:false;
		arr[4] = rs5;
		
		//Q6 - �쇰낯��
		boolean rs6 = (f >= '\u3040' && f <= '\u309F' )?true:false;
		arr[5] = rs6;
	
		int count = 1;
		for(boolean result : arr) {
			
			System.out.println("Q"+ (count++) + " : " +result);
		}
	}
}
