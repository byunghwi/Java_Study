package quiz;

import java.util.Random;
import java.util.Scanner;

public class B13_31game {
	public static void main(String[] args) {
//		# 31게임을 만들어보세요
//		1. 컴퓨터와 사람이 번갈아가면서 숫자를 선택한다. (1,2,3 중에 선택) 누구 차례인지도 랜덤
//		2. 컴퓨터는 랜덤으로 숫자를 선택한다.
//		3. 마지막에 31을 부르는 쪽이 패배한다.
		
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		// true는 유저, false는 컴퓨터
		boolean now_turn = rd.nextBoolean();
			
		// 0은 사람 , 1은 컴퓨터 , 2는 현재 합
		int game[] = new int[3];
		int user_num = 0; //사람
		int com_num = 1;  //컴퓨터
		int total = 2;	  //현재 총합
		
		int com;
		int user;

		while(game[total]<=31) {

			if(now_turn) {
				
				System.out.print("번호를 입력하세요 > ");
				user = sc.nextInt();
				//현재 유저의 선택값
				game[user_num] = user;
				
				//현재 숫자 위치
				game[total] += game[user_num];
				
				System.out.printf("\t현재 숫자 > %d\n\n", game[total]);
				
			}else {	
				//컴퓨터 랜덤 숫자 선택
				com = rd.nextInt(3)+1;
				game[com_num] = com;
				game[total] += game[com_num];

				System.out.printf("컴퓨터 > %d\n", game[com_num]);
				System.out.printf("\t현재 숫자 > %d\n\n", game[total]);		
			}
			
			//만약 마지막 수가 30이면 무조건 1을 택해야하고 패배
			String looser ="";
			
			if(game[total] >=30) {
				if(game[total] ==30)
					looser = (now_turn == true)?"컴퓨터":"유저";
				else
					looser = (now_turn == true)?"유저":"컴퓨터";
				
				
				System.out.println( looser+ "가 패배하였습니다.");
				break;
					
			}
			
			//차례바꿔주기.
			now_turn = !now_turn;
		}	
	}
}
