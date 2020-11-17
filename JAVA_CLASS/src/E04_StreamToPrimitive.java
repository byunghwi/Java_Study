import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E04_StreamToPrimitive {
	// # Stream의 데이터를 기본형으로 변환하기
	// - DataInputStream/DataOutputStream 을 사용한다.
	// - 기본타입을 이용해 입/출력을 편하게 구현할 수 있다.
	
	public static void main(String[] args) {
		try {
			DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new  FileOutputStream("D:\\Java_IO\\dataout.txt"), 2048));
			
			// 데이터를 int 혹은 byte[]로 변환할 필요가 없다.
			dout.writeInt(123);
			dout.writeBoolean(true);
			dout.writeFloat(123.123f);
			dout.writeDouble(432.4321);
			dout.writeLong(12345L);
			dout.writeUTF("한글입니다.");
			
			dout.close();
			System.out.println("파일 출력 완료.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\Java_IO\\dataout.txt")));
			
			//썼던 순서대로 꺼내야만 올바르게 출력된다.
			int data1  = din.readInt();
			boolean data2 = din.readBoolean();
			float data3 = din.readFloat();
			double data4 = din.readDouble();
			long data5 = din.readLong();
			String data6 = din.readUTF();
			
			System.out.println("data1 : " + data1);
			System.out.println("data2 : " + data2);
			System.out.println("data3 : " + data3);
			System.out.println("data4 : " + data4);
			System.out.println("data5 : " + data5);
			System.out.println("data6 : " + data6);
			
			din.close();
			
			System.out.println("읽기완료.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
