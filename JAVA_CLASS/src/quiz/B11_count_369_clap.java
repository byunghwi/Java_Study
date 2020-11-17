package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11_count_369_clap {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		사용자로부터 정수 하나를 입력받고
//		해당 숫자까지 369게임이 진행된다면 박수를 총몇번 쳐야하는지 세라.
// 1 2 x 4 5 x 7 8 x 10 11 12 x 14 15 x .....		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int now = 1; 
		int user = Integer.parseInt(br.readLine());
		int count = 0;

		while(true) {
			//처음의 몫은 현재값으로 설정.
			int mok = now;
			
			//입력한 수까지 도달하면 종료
			if(now > user)
				break;	
			System.out.printf("현재 수 %d : ", now );
			//자리수 일의자리부터 체크
			if(now%10==3||now%10==6||now%10==9) {
				count++;
				System.out.printf("짝");
				//System.out.println("here1/////now --->" + now + "//// count ---->" + count + "////mok------>" + mok);
			}
			
			//일의자리 이후 자릿수 체크
			while(true) {	
				
				//몫
				mok = mok/10;

				if(mok ==0)
					break;

				if( mok%10==3 ||mok%10==6||mok%10==9) {
					count++;
					System.out.printf("짝");
				}

			}
			//현재 수 증가.
			now++;
			
			System.out.println();
		}
		System.out.println();
		System.out.println("박수친 총 횟수는 -> "+ count);
		System.exit(0);
		
		}	
	}
