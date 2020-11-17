import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E02_BufferedIO {
	// # Buffered I/O
	
	// # 버퍼를 이용해야하는 이유
	// - 버퍼없이 읽기/쓰기를 하게되면 입출력이 너무 자주 일어나게됨.
	// - 버퍼란? -> 데이터를 입/출력하기 전에 임시로 저장해두는 배열.
	
	
	// ex> Java Programming을 쓰는 경우
	// - 기본 OutputStream으로 한 글자 씩 쓰면 16번의 출력이 발생.
	// - 배열에 저장해놓고 한번에 쓰면 1번의 출력만으로 출력이 끝남.
	
	// - BufferedOutputStream은 생성자에 OutputStream을 요구.
	// - OutputStream은 출력할 장소를 선택하는 용도로 사용.
	// - BufferedOutputStream은 성능 업그레이드의 용도로 사용.
	public static void main(String[] args) {
		StringBuilder text = new StringBuilder();
		
		for (int i = 0; i < 100000; i++) {
			text.append(i + " 안녕하세요\n");
		}
		
		try {
			FileOutputStream fout = new FileOutputStream("D:\\Java_IO\\bufferedout.txt");
			
			// # 버퍼의 크기가 1024인 경우
			// - 데이터를 OutputStream에 쓸 때 1024바이트의 데이터가 다 모이면 출력한다.
			// - 혹은 프로그래머가 flush(); 메서드를 호출할 때 출력한다. 
			// - 혹은 close가 발생하면 여태 모인 데이터를 출력한다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 1024);
			
			byte[] data = new String(text).getBytes();
			// bout.write(data);
			
			for (byte b : data) {
				bout.write(b);				
			}
			
			bout.close();
			fout.close();
			
			System.out.println("파일 출력 끝");
		} catch (FileNotFoundException e) {
			System.err.println("파일 못 찾음");
		} catch (IOException e) {
			System.err.println("쓰기/닫기 중 에러 발생");
		}
		
		
		// java.io.BufferedInputStream 
		// - InputStream을 생성자로 요구한다.

		try {
			FileInputStream fin = new FileInputStream("D:\\Java_IO\\bufferedout.txt");
			BufferedInputStream bin = new BufferedInputStream(fin,1024);
			
			byte[] data = new byte[1024];
			
			// # read()의 기본 오버로딩
			// - 한 바이트를 int 값으로 읽어온다.
			
			// # read(byte[]) 오버로딩
			// - 전달한 byte[]의 크기만큼의 byte 채워준다.
			// - 전달한 배열에 몇 byte를 채웠는지를 반환.(len)
			
			// # read(byte[], off , len)
			// - 전달한 byte 배열 중에서 off부터 len까지에만 데이터를 채워준다.
			// - 전달한 배열에 몇 byte를 채웠는지 반환한다.
			int len;
			int count =0;
			while ((len = bin.read(data)) != -1) {
				System.out.println(new String(data, 0 , len));
				System.out.println(count++ + "번째 읽기");
			}
			
			
			bin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
