package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class E03_JoinMember {
	 // 1. 사용자가 자신의 여러가지 개인정보를 입력하면 
	// 	그 정보를 사용자의 이름으로 된 파일에 저장해보세요.
	// # java_io/member/ 디렉토리에 저장할 것.
	
	// 2. 사용자의 이름을 전달받으면 
	//	(1) 가입된 회원이라면 파일에서 정보를 읽어 출력 
	// 	(2) 아직 가입되지 않은 회원이라면 가입되지 않았다고 출력하는 메서드를 작성.
	//
	// 3. 저장된 사용자의 정보를 수정할 수 있는 메서드를 구현해보세요.
	static Scanner sc5 = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
	
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Java_IO\\member\\members.txt"))));
		for (int i = 0; i < 3; i++) {
			
			System.out.print("이름을 입력하세요 > ");
			String name = sc.next();
			
			System.out.print("생년월일을 입력하세요 > ");
			String birth = sc2.next();
			
			System.out.print("주소를 입력하세요 > ");
			String zip = sc.next();
			
			pw.print(name + "/" + birth + "/" + zip + "\n");			
			System.out.println("회원정보가 저장되었습니다.");
		
		}
		pw.close();
		
		System.out.print("찾으려는 회원의 이름을 입력하세요 > ");
		String findName = sc.next();
		findMember(findName);
		
		System.out.print("수정할 회원의 이름을 입력하세요 > ");
		String editName = sc3.next();
		editMember(editName);
	}
	
	public static void findMember(String name) {
		boolean chk = false;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Java_IO\\member\\members.txt")));
			
			String sline = null;
			while((sline = br.readLine()) != null) {
				
				String info[] = sline.trim().split("/");
				String memName = info[0];
				
				if(name.equals(memName)) {
					System.out.println("찾으신 회원의 정보 : " + sline);
					chk = true;
					break;
				}
					
			}
			
			if(chk == false) {
				System.err.println("미등록된 회원입니다.");
			}
			System.out.println();
			br.close();

		} catch (FileNotFoundException e) {
			System.err.println("파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("입출력 오류입니다.");
			e.printStackTrace();
		}
	}
	
	public static void editMember(String name) throws IOException {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Java_IO\\member\\members.txt")));
		PrintWriter pw2 = new PrintWriter( new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Java_IO\\member\\members.txt"))));
		String sline = null;
		String origin = null;
		while((sline = br2.readLine()) != null) {
			System.out.println("hererereeeereers");
			String info[] = sline.trim().split("/");
			String memName = info[0];
			if(name.equals(memName)) {
				System.out.print("수정할 정보를 입력하세요 >");
				String editInfo = sc5.next();
				sline = sline.replaceAll(sline, editInfo);
			}
			System.out.println("herere2");
			origin = sline;
			pw2.write(origin);
		}

		
		br2.close();
		pw2.close();
	}
}
