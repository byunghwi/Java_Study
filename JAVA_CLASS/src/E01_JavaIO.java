import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E01_JavaIO {
	public static void main(String[] args) {
		
		// # Java I/O (Input and Output)
		// - 자바는 스트림을 이용해 입출력을 다룬다.
		// - 프로그램으로 들어오는 모든 데이터들을 입력이라고 부른다.(Input)
		// - 프로그램이 연산해서 내보내는 모든 데이터들을 출력이라고 부른다. (Output)
		
		// # Stream
		// - 데이터들이 오가는 통로
		// - 입력 받을 때 사용하는 통로를 InputStream 이라고 부른다.
		// - 출력 할 때 사용하는 통로를 OutputStream 이라고 부른다.
		// 데이터가 Stream을 통해 이동할때는 데이터를 0과 1로 변환하여 전송한다.
		
		// # OutputStream 클래스의 공통 메서드
		// - write(int)
		// - write(byte[])
		// - flush() : 모아놨던 데이터를 전송한다.
		// - close : 스트림을 폐기.
		
		// # InputStream 클래스의 공통메서드
		// - int read() : 다음 한 바이트를 읽어온다. EOF(End Of File)에 도달하면 -1 반환
		// - close() : 스트림을 닫는다.
		
		// # FileOutputStream
		// - 파일로 출력하는데 특화된 OutputStream
		// - Java IO 클래스들은 대부분 필수적으로 처리해야하는 예외가 존재.
		
		try {
			FileOutputStream fout = new FileOutputStream("D:\\Java_IO\\st.txt");
				
			byte[] data = "안녕하세요".getBytes();
			fout.write(data);
			fout.close();
			
			System.out.println("쓰기 성공");
			
		} catch (FileNotFoundException e) {
			System.err.println("파일을 못찾았습니다.");
		} catch (IOException e ) {
			System.out.println("파일에 쓰다가 에러.");
		}
		
		
		
		try {
			FileInputStream fin = new FileInputStream("D:\\Java_IO\\st.txt");
			
			byte[] bytes = new byte[100];
			
			int ch = -1;
			int index = 0;
			while((ch = fin.read()) !=-1){
				bytes[index++] = (byte) ch;
			}
			System.out.println("bytes에 저장된 값들 : "+ Arrays.toString(bytes));
			System.out.println(new String(bytes));
			
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽어오는데 실패하였습니다.");
		} catch (IOException e) {
			System.err.println("IO 도중 에러 발생");
		}
		
		// # FileInputStream, FileOutputStream 은 데이터를 코드로 읽어오기 때문에 
		//	프로그래머가 원래 형태로 재조립하는 과정이 필요하다.
	}
	
}
