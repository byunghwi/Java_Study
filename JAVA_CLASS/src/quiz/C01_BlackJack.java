package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C01_BlackJack {
	public static void main(String[] args) {
	//		# 블랙잭을 만들어 보라.
	//		* 게임순서
	//		1. 딜러(컴픁터)와 플레이어가 카드를 2장씩 받는다.
	//			이때 딜러의 카드는 한 장 가려놓는다.
	//		2. 사용자는 카드를 보고 더 뽑을지 멈출지를 결정한다
	//		3. 사용자가 멈추면 딜러가 가려져 있던 카드를 뒤집은 뒤 규칙에 따라 카드를 뽑느다.
	//			(카드의 합이 16이하일 때 무조건 뽑고, 17 이상이면 무조건 멈춘다.)
	//		4. 딜러보다 합이 높거나 정확하게 21이라면 승리 (베팅 금액만큼 플레이어의 돈이 오른다.)
	//		   딜러보다 합이 낮거나 21이 넘으면 패배 (플레이어의 돈이 떨어진다.)
	//		   딜러와 카드합이 같다면 무승부
	//		※ J, Q, K는 10에 해당한다 
	//		※ 각 카드는 문양별로 한장씩 존재한다
	//		※ A는 1 또는 11로 계산한다.
	//		King, Queen, Jack은 각각 10으로 계산합니다.
	// 		카드 덱 ->  스페이드 2345678910JQKA  S 13장
	//		 			  하트 	2345678910JQKA H
	//		 			  클로버 2345678910JQKA  C
	//		 			  다이어 2345678910JQKA  D
		
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		// 0은 유저 뽑은 횟수, 1은 딜러 뽑은 횟수
		int pickCount = 0;
		
		//유저 숫자 저장
		int arrUser[] = new int[10];
		
		//딜러 숫자 저장
		int arrCom[] = new int[2];
		
		//유저인지 딜러인지 체크
		boolean userCheck = true;
		
		//추가 게임 여부
		String check ="";
		
		int now_money = 10000;
		int bet_money = 0;
		
//
//		System.out.println("현재금액 : " + now_money);
//		while(true) {
//			System.out.print("베팅할 금액을 입력하세요 : ");
//			bet_money = sc1.nextInt();
//			
//			if(bet_money >= now_money) {
//				System.out.println("현재 가진 금액보다 많은 돈을 베팅할 수 없습니다.");
//			}else
//				now_money -= bet_money;
//				break;
//		}
//		
//		System.out.println("============게임을 시작합니다.============");


		//최초 딜러 숫자뽑기


		//카드 뽑은 횟수
		int countU =0;
		int countD =0;
		while(true) {
			if(countU == 0) {
				arrUser[countU] = pickNum(userCheck, pickCount++);
				arrUser[++countU] = pickNum(userCheck, pickCount++);
				
				arrCom[countD] = pickNum(!userCheck, pickCount++);
				arrCom[++countD] = pickNum(!userCheck, pickCount++);
				
			}else {
				System.out.print("카드를 더 뽑으시겠습니까 (Y,N) > ");
				check = sc2.nextLine();
				if(check.equals("Y")) 
					arrUser[++countU] = pickNum(userCheck, pickCount++);				
				else {
					
					System.out.println();
					System.out.println();
					System.out.println("딜러의 숫자 > " + arrCom[0] + ", " + arrCom[1] );
					
					//결과도출
					//resultGame(arrUser, arrCom, now_money, bet_money);
					break;
				}
			}
		}
	}

	
	
	//카드 덱 섞기.
	public static int[] mixNum() {
		Random rd = new Random();
		int deckAll[] = new int[52];
		
		//0~52까지 각 인덱스에 저장
		for (int i = 0; i < deckAll.length; i++) {
			deckAll[i] = i+1;
		}
		
		for (int i = 0; i < 200; i++) {
			int n = rd.nextInt(52);// 0~51 인덱스
			int n2 = rd.nextInt(52);
			int temp = deckAll[n];
			deckAll[n] = deckAll[n2];
			deckAll[n2] = temp;
		}

		return deckAll;
	}
	
	//카드 뽑기
	public static int pickNum(boolean checkUser, int count) {
		// 1~13 ♡   14~26 ◇   27~39 ♠   40~52 ♣
		int num = mixNum()[count];
		return num;
	}
	
	//결과 확인
	public static void resultGame(String[] user, String[]com, int now_money, int bet_money) {
		
		//유저의 합
		int sumUser = 0;
		int sumCom = 0;
		int countA =0;
				
		System.out.println("==============게임 종료==============\n");
		
		int userInt[] = new int[user.length];
		int comInt[] = new int[2];

		for (int i = 0; i < user.length; i++) {
			if(user[i] ==null)
				break;

			switch (user[i]) {
			case "J":
			case "Q":
			case "K":
				userInt[i] = 10;
				sumUser+=userInt[i];
				break;
			case "A":
				userInt[i] = 11;
				countA+=1;
				sumUser+=userInt[i];			
				break;
			default:
				userInt[i] = Integer.parseInt(user[i]);
				sumUser+=userInt[i];
				break;
			}

		}
		
		//A가 몇번 나왔는지 체크 후 계산
		while(sumUser > 21 && countA > 0)  {
			sumUser-=10;
			countA-=1;	
		}
		
		//딜러
		for (int i = 0; i < com.length; i++) {

			switch (com[i]) {
			case "J":
			case "Q":
			case "K":
				comInt[i] = 10;
				sumCom+=comInt[i];
				break;
			case "A":
				if(sumCom<=10)
					comInt[i] = 11;
				else
					comInt[i] = 1;
				
				sumCom+=comInt[i];
				
				break;
			default:
				comInt[i] = Integer.parseInt(com[i]);
				sumCom+=comInt[i];
				break;
			}
		}
		
		
		
		System.out.println("딜러의 합 > "+ sumCom);
		

			
		if(sumUser>=21) {
			if(sumUser ==21) {
				System.out.println("블랙잭입니다. 유저 승리! > "+sumUser);
				System.out.println("현재금액 > "+ ( now_money + bet_money*2.5 ));
			}else {
				System.out.println("21초과입니다. 유저 패배 > "+sumUser);
				System.out.println("현재금액 > "+ ( now_money ));
			}

		}
		else if(sumUser==sumCom)
			System.out.println("동점입니다. 무승부! > "+sumUser+bet_money);
		else if(sumUser>sumCom) {
			System.out.println("유저승리입니다! > "+sumUser);
			System.out.println("현재금액 > "+ ( now_money+bet_money*2));
		}	
		else {
			System.out.println("유저패배입니다! > "+sumUser);
			System.out.println("현재금액 > "+ ( now_money-bet_money ));
		}			
	}
}
