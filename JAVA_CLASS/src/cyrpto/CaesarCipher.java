package cyrpto;

public class CaesarCipher {
	public static void main(String[] args) {
		
		CaesarCipher cc = new CaesarCipher(1000);
		StringBuilder encrypResult = cc.encryption("hello, world!");
		StringBuilder decrypResult = cc.decryption(encrypResult);
		System.out.println("암호화 > " + encrypResult);
		System.out.println("복호화 > " + decrypResult);

		
	}
	
	int key;
	//총 57인덱스
	String encryp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuvwxyz";
	
	//마지막 인덱스값
	int lastIndex = encryp.indexOf("z");
	
	StringBuilder resultEncryp = new StringBuilder();
	StringBuilder resultDecryp = new StringBuilder();

	public CaesarCipher(int key) {
		super();
		this.key = key % encryp.length();
	}
	
	//매개변수로 받은 평문을 암호문을 완성해서 리턴하는 함수
	public StringBuilder encryption(String plain_text) {

		for (int i = 0; i < plain_text.length(); i++) {
			
			//키만큼 우측으로 이동할때 회전을 해야하는 경우.
			if(lastIndex - encryp.indexOf(plain_text.charAt(i)) < this.key) {
				int findCharIdx = this.key - ((lastIndex - (encryp.indexOf(plain_text.charAt(i))))+1);
				resultEncryp.append(encryp.charAt(findCharIdx));
			}else
				resultEncryp.append(encryp.charAt(encryp.indexOf(plain_text.charAt(i))+this.key));
		}
		return resultEncryp;
	}
	
	//매개변수로 받은 암호문을 복호화하여 리턴하는 함수를 구현.
	public StringBuilder decryption(StringBuilder encrypResult) {
		
		for (int i = 0; i < encrypResult.length(); i++) {
			
			//키만큼 좌측으로 이동할때 회전을 해야하는 경우
			if (encryp.indexOf(encrypResult.charAt(i))-this.key < 0) {
				resultDecryp.append(encryp.charAt((lastIndex - Math.abs((encryp.indexOf(encrypResult.charAt(i))-this.key)+1))));
			} else {
				resultDecryp.append(encryp.charAt(encryp.indexOf(encrypResult.charAt(i))-this.key));	
			}
			
		}
		return resultDecryp;
	} 
}
