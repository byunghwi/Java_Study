import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class E08_NetworkProgramming {
	// # 2대 이상의 컴퓨터가 자원을 함께 사용하는 프로그램을 만드는 것
	// - 다른 컴퓨터와 통신하기 위해 IP/프로토콜/포트번호 등의 개념을 이용한다.
	
	
	// # IP 주소
	// - 각 자리가 0-255이다.
	// - 컴퓨터를 찾아가기 위한 주소

	// # 프로토콜
	// - 프로그램 간에 의사소통을 하기위한 규칙
	// - TCP, FTP, Telnet, SMTP
	
	// # 포트번호
	// - 한 컴퓨터에서 여러가지 프로그램들 중 하나를 선택하기 위한 번호
	// - IP주소와 포트번호를 통해 프로그램을 찾아갈 수 있다.
	
	// # MAC 주소
	// - 내부망에서 해당 컴퓨터를 정확하게 찾아가기 위한 번호
	
	public static void main(String[] args) {
		try {
			//서버소켓 생성
			ServerSocket ss = new ServerSocket(3456);
			HashMap<String, Integer> connect_ct = new HashMap<String, Integer>();
			
			int count = 0;
			while(true) {
				// accept메서드를 실행하면 연결이 될 때까지 기다린다.
				// 누군가가 접속하면 접속한 사용자의 정보를 담고있는 Socket을 반환한다.
				System.out.println("[Server] 연결을 기다리는중..");
				Socket s = ss.accept();
				
				System.out.printf("[Server]메세지를 기다리는 중... (총 접속자 : %d 명)\n", count++);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				String msg = br.readLine();
				
				// Socket의 getInetAddress로 상대방의 IP주소를 알 수 있다.
				// Socket에는 IP주소 이외에도 상대와의 연결에 필요한 정보들이 들어 있다.
				System.out.printf("(%s) %s\n", s.getInetAddress(), msg);
				
				String ipaddr = s.getInetAddress().toString();
				
				if (connect_ct.containsKey(ipaddr)) {
					connect_ct.put(ipaddr, connect_ct.get(ipaddr)+1);
				}else {
					connect_ct.put(ipaddr, 0);
				}
				
				
				if (count % 10 == 0) {
					System.err.println("(축) 접속자 10명 돌파" + count);
				}
				
				if(count == 100){
					break;
				}
			}
			
			System.out.println("프로그램을 종료합니다.");
			
			for (Map.Entry<String, Integer> entry : connect_ct.entrySet()) {
				System.out.printf("'%s' 님의 도배 횟수 : %d회 \n", entry.getKey(), entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
