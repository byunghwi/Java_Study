import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class E05_StreamToObject {
	
	//Serializeable 인터페이스
	// - 해당 객체를 직렬화 가능한 객체로 만든다
	// - 직렬화란? 데이터를 이진법으로 변환하는 것.
	static class Apple implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		int size;
		String color;
		String local;
		
		public Apple(int size, String color, String local){
			this.size = size;
			this.color = color;
			this.local = local;
		}
		
		@Override
		public String toString() {
			
			return size + "/" + color+ "/" + local;
		}
	}
	
	// # ObjectOutputStream / ObjectInputStream 을 통해 
	// 객체도 Stream으로 지나다닐 수 있다.
	
	public static void main(String[] args) {
		//AutoClose 가 구현된 클래스들은 try-with-resources를 이용할 수 있다.
		try (
				FileOutputStream fout = new FileOutputStream("D:\\Java_IO\\objectout.txt");
				BufferedOutputStream bout =  new BufferedOutputStream(fout);
				ObjectOutputStream oout = new ObjectOutputStream(bout);
		){
			oout.writeObject(new Apple(10,"주황색","대구"));
			oout.writeObject(new Apple(20,"빨강색","제주"));
			oout.writeObject(new Apple(30,"파랑색","고성"));
			
			System.out.println("객체 쓰기 완료.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try (
				FileInputStream fin = new FileInputStream("D:\\Java_IO\\objectout.txt");
				BufferedInputStream bin = new BufferedInputStream(fin);
				ObjectInputStream oin = new ObjectInputStream(bin);
		){
			//ObjectInputStream의 readObject는 Object 타입으로 받아오기 때문에 사용하기 위해서는 다운캐스팅이 필요하다.
			System.out.println("파일에서 읽어온 객체");
			System.out.println(oin.readObject());
			System.out.println(oin.readObject());
			System.out.println(oin.readObject());

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
