package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B12_BlackJack {
	public static void main(String[] args) {
		
		Random rd = new Random();

		//다음과 같은 문자열이 있을 때, 문자열을 랜덤 순서로 섞은 후 출력해보세요
		String deck = "123456789ABCD" 
						+"123456789ABCD"
						+"123456789ABCD"
						+"123456789ABCD";
		
		String mix_arr[] = new String[56];
		

		String num1 = "";
		// 1부터 14까지 14개의 숫자를 랜덤픽하여 각 배열 요소에 저장

			for(int i=0; i<56; i++) {
				
				 num1 = Integer.toString((rd.nextInt(13)+1));
				 
				switch (num1) {
				case "10":	
					mix_arr[i] = num1.replace(num1, "A");
					//System.out.println("here1");
					break;
				case "11":
					mix_arr[i] = num1.replace(num1, "B");
					//System.out.println("here2");
					break;
				case "12":
					mix_arr[i] = num1.replace(num1, "C");
					//System.out.println("here3");
					break;
				case "13":
					mix_arr[i] = num1.replace(num1, "D");
					//System.out.println("here4");
					break;
				default:
					mix_arr[i] = num1;
					break;
				}
			}	
			
			System.out.println("결과 >>>>");
			System.out.println(Arrays.toString(mix_arr));
//			for(int j=0; j<arr.length; j++) {
//				System.out.print(arr[j]+ " ");
//
//			}	
		}	

		
		
		
//		# 블랙잭을 만들어 보라.
//		* 게임순서
//		1. 딜러(컴픁터)가 카드를 뽑는다. 
//			(컴퓨터는 뽑은 카드의 합이 16이하일 때 무조건 뽑고, 17 이상이면 무조건 멈춘다.)
//		2. 사용자는 카드를 더 뽑을지 멈출지 결정한다.
//		3. 사용자가 멈추면 승패를 출력해준다.
//		4. 사용자가 카드를 더 뽑았을 때 
//			컴퓨터보다 합이 높거나 정확하게 21이라면 승리
//			컴퓨터보다 합이 낮거나, 21이 넘으면 패배
//		
//		※ 처음에는 카드를 2장 뽑는다.
//		※ J, Q, K는 10에 해당한다 
//		※ 각 카드는 문양별로 한장씩 존재한다
//		※ A는 1 또는 11로 계산한다.
//		King, Queen, Jack은 각각 10으로 계산합니다.
	}

