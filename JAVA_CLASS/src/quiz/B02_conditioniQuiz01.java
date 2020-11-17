package quiz;

public class B02_conditioniQuiz01 {
	public static void main(String[] args) {
		int a =16; 
		int b = 20;
		int c = 77;
		int d = 40;
		int e = 10;
		int hour = 13;
		int year = 800;
		int minsu_age = 18;
		int chulsoo_age = 16;
		int minsu_birth= 6;
		int chulsoo_birth = 9;
		boolean powerOn = false;
		String str ="Yes";
		
		int longest_side = 5;
		int other_side1 = 3;
		int other_side2 = 4;
		
		String arr[] = new String[11];
		
		// Q1
		String rs1 = (10< a && a < 20)?"true":"false";
		arr[0] = rs1;
			
		//Q2
		String rs2 = (b%2 == 0)?"true":"false";
		arr[1] = rs2;
		
		//Q3
		String rs3 = (c%7 == 0)?"true":"false";
		arr[2] = rs3;
		
		//Q4
		String rs4 = !(hour<0 && hour>=24) && hour >=12 ?"true":"false";
		arr[3] = rs4;

		//Q5
		String rs5 = (Math.abs(d-e) == 30)?"true":"false";
		arr[4] = rs5;
		
		//Q6
		String rs6 = (year%400==0 || (year%4==0 && year%100!=0))?"true":"false";
		arr[5] = rs6;
	
		//Q7
		String rs7 = (minsu_age-chulsoo_age ==2)?"true":"false";
		arr[6] = rs7;
		
		//Q8
		String rs8 = (chulsoo_birth -minsu_birth ==3)?"true":"false";
		arr[7] = rs8;

		//Q9
		String rs9 = (powerOn==false)?"true":"false";
		arr[8] = rs9;
		
		//Q10
		String rs10 = (str == "Yes")?"true":"false";
		arr[9] = rs10;

		//Q11
		String rs11 = (Math.pow(longest_side, 2)== Math.pow(other_side1, 2) + Math.pow(other_side2, 2))?"true":"false";
		arr[10] = rs11;
		
		int count = 1;
		for(String i : arr) {
			System.out.println("Q"+ count++ +": " +i);
		}

	}
}
