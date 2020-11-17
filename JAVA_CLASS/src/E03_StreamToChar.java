import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class E03_StreamToChar {
	// # Reader/Writer 가 붙은 클래스들은
	// Stream으로 읽은 데이터를 문자로 변환하는 클래스들
	
	// # 프로그래머가 데이터를 문자로 편하게 다루고 싶을 때
	// InputStream/OutputStream을 Reader/Writer 클래스로 한 번 더 감싸서 사용한다.
	
	public static void main(String[] args) {
		// # abstract class Reader
		// - Reader를 상속받아 구현한 클래스들
		// - BufferedReader, InputStreamReader, FileReader...
		// - Stream으로 얻은 데이터를 문자로 재구성하여 프로그래머에게 제공한다.
		// - 코드 데이터를 문자로 재구성할 시 사요하라 charset을 알맞게 설정하지 않으면 글자가 깨짐.
		try {
			//FileReader fr = new FileReader("D:\\Java_IO\\bufferedout.txt", Charset.forName("UTF-8"));
			
			
			//FileReader를 BufferedReader로 업그레이드
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Java_IO\\bufferedout.txt")));

			
			// Reader 클래스의 read는 다음 byte 가 아니라, 다음 char를 읽는다.
			int ch;
			while((ch = br.read()) !=  -1) {
				System.out.print((char)ch);
			}
			
			//fr.close();
//			fin.close();
//			ir.close();
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// # abstract class Writer
		// - 파일에 문자를 저장할 때 charset을 지정할 수 있다.
		// - 프로그래머가 좀 더 편리하게 outputStream을 이용할 수 있다.
		
		try {
			// Print : 프로그래머에게 편리한 print메서드 들을 이용할 수 있다.
			// Buffered : 성능향상
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Java_IO\\bufferedout.txt")) , 4096)) ;
			
			for (int i = 0; i < 100; i++) {
				pw.write("가나다라마바사아자차카타파하\n");
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못찾았습니다.");
		} catch (IOException e) {
			System.err.println("입출력오류");
		}
	}
}
