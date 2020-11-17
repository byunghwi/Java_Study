//package quiz;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class E03_JoinMember2 {
//	 // 1. 사용자가 자신의 여러가지 개인정보를 입력하면 
//		// 	그 정보를 사용자의 이름으로 된 파일에 저장해보세요.
//		// # java_io/member/ 디렉토리에 저장할 것.
//		
//		// 2. 사용자의 이름을 전달받으면 
//		//	(1) 가입된 회원이라면 파일에서 정보를 읽어 출력 
//		// 	(2) 아직 가입되지 않은 회원이라면 가입되지 않았다고 출력하는 메서드를 작성.
//		//
//		// 3. 저장된 사용자의 정보를 수정할 수 있는 메서드를 구현해보세요.
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
//		System.out.print("이름 > ");
//		String name = br.readLine();
//			
//		if(checkNotMember(name)) {
//			System.out.print("나이 > ");
//			int age = Integer.parseInt(br.readLine());
//			
//			
//			System.out.print("혈액형 > ");
//			String blood = br.readLine();
//			
//			System.out.print("전화번호 > ");
//			String tel = br.readLine();
//		
//			
//			addMember(new Member(name, age, blood, tel));	
//			System.out.println("가입이 완료되었습니다.");
//		}
//		
//		editMember(name);
//		
//	}
//	
//	static class Member{
//		String name;
//		int age;
//		String blood;
//		String tel;
//		
//		public Member(String name, int age, String blood, String tel) {
//			super();
//			this.name = name;
//			this.age = age;
//			this.blood = blood;
//			this.tel = tel;
//		}
//		
//		@Override
//		public String toString() {	
//			return this.name+ "/" + this.age + "/" + this.blood + "/" + this.tel;
//		}
//		
//		public void update(Member before) {
//			
//		}
//	}
//	
//	public static void addMember(Member member) throws IOException {
//		String dir = "D:\\Java_IO\\member\\";
//		String fileName = "member_"+member.name+".txt";
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(dir + fileName)));
//		
//		pw.write(member.toString());
//		pw.close();
//	}
//	
//	public static boolean checkNotMember(String name) throws IOException {
//		String dir = "D:\\Java_IO\\member\\";
//		String fileName = "member_"+name+".txt";
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader(dir + fileName));
//			System.out.println(br.readLine());
//			return false;
//		} catch (FileNotFoundException e) {
//			System.err.println("등록된 회원이 없습니다. 가입을 진행합니다.");	
//			return true;
//		}finally {
//			if(br != null)
//				br.close();
//		}
//	}
//	
//	public static Member editMember(String name) {
//		String dir = "D:\\Java_IO\\member\\";
//		String fileName = "member_"+name+".txt";
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader(dir + fileName));
//			String[] info = br.readLine().split("/");
//			
//			Member before = new Member(info[0], Integer.parseInt(info[1]), info[2], info[3]);
//			
//			Member after = before.update(before);
//		} catch (FileNotFoundException e) {
//
//		}finally {
//			if(br != null)
//				br.close();
//		}
//		
//		return null;
//	}
//	
//}
