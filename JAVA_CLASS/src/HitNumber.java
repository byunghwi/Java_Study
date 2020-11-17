import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HitNumber {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("컴퓨터가 숫자를 생성합니다.\n");
		
		int comNum = (int)(Math.random()*1000+1);
		int userNum = 0;
		int count = 0;
		
		while(true) {	
			System.out.print("사용자 > ");
			
			//숫자 이외의 값이 들어왔을 경우
			try {
				 userNum = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.err.println("올바른 숫자를 입력해주세요.");
				continue;
			}
			
			count++;
			
			if(comNum == userNum) {
				System.out.println("정답!");
				break;
			}else if(comNum > userNum) {
				System.out.println("UP!");
			}else if(comNum < userNum) {
				System.out.println("DOWN!");
			}
		}
		System.out.println("컴퓨터가 선택한 숫자는 > " + comNum);
		System.out.println("정답 시도 횟수 > " + count);
	}
}
