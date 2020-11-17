package quiz;

import java.util.Arrays;

public class TranspositionCipher {

	public static void main(String[] args) {
		// # 전치 암호
		// - 메세지를 key값 만큼의 길이로 나눈 뒤 다른 방향으로 읽어서 암호화 하는 방식
		
		// ex>
		
		//Plain : Common sense is not so common.
		//Key : 8
		
		// 0 1 2 3 4 5 6 7
		// ---------------
		// C o m m o n   s
		// e n s e   i s   
		// n o t   s o   c
		// o m m o n .
		
		// crypto : Cenoonommstmme oo snnio. s s c
		
		TranspositionCipher tc = new TranspositionCipher(8);
		TranspositionCipher tc2 = new TranspositionCipher(7);
		System.out.println("암호화한 결과는 > " + tc.encryTrans("Common sense is not so common."));
		System.out.println("암호화한 결과는 > " + tc2.encryTrans("안녕하세요 반갑습니다 제 이름은 김민수입니다."));
	}
	
	int key;
	
	
	public TranspositionCipher(int key) {
		super();
		this.key = key;
	}
	
	public char[] cutPlainText(String input) {
		 char cutText[] = input.toCharArray();
		return cutText;
				
	} 

	public String encryTrans (String plain_text) {
		
		char[] plainNew = cutPlainText(plain_text);

		int line = key;
		int row = (int) (Math.floor(plain_text.length() / key)) +1;
		int count = 0;
		
		char [][] plainArr = new char[row][line];
		
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < line; j++) {
					
				if(count < plainNew.length) {
					plainArr[i][j] = plainNew[count];
					count++;
				}else {
					plainArr[i][j] = '\u0000';
					count++;
				}	
			}
		}
		return printEncrypt(plainArr, row, line);
	}

	
	public String printEncrypt(char[][] input, int row, int line) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < line; i++) {
			for (int j = 0; j < row; j++) {
				sb.append(input[j][i]);
			}
		}
		return sb.toString();
	}
}

