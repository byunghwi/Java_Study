package cyrpto;

public class CaesarHacker {
	
	public static void main(String[] args) {
		// 암호문과 charset과 알고리즘이 시저암호 방식임을 알고있다고 가정한 상태로
		// 암호문을 이용하여 평문을 추출해보세요
		String rs = new CaesarHacker(1000).decryption("vszzCniKCFzrj");
		System.out.println(rs);
		
	}
	
	public CaesarHacker(int key) {
		super();
		this.key = key % encryp.length;
	}

	int key;
	//총 57인덱스
	char[] encryp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuvwxyz".toCharArray();
	StringBuilder resultDecryp = new StringBuilder();
	
	public int findIdx(char input) {
		for (int i = 0; i < encryp.length; i++) {
			if(encryp[i] == input)
				return i;
		}	
		return -1;
	}
	
	//매개변수로 받은 암호문을 복호화하여 리턴하는 함수를 구현.
	public String decryption(String encrypResult) {

		for (int i = 0; i < encrypResult.length(); i++) {
			int index = findIdx(encrypResult.charAt(i));
			//키만큼 좌측으로 이동할때 회전을 해야하는 경우
			if (index-this.key < 0) {
				resultDecryp.append(encryp[encryp.length+(index-this.key)]);
			} else
				resultDecryp.append(encryp[index-this.key]);	
		}
		return resultDecryp.toString();
	} 
}
