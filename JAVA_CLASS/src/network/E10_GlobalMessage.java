package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class E10_GlobalMessage {
	public static void main(String[] args) {
		ArrayList<Socket> clients = new ArrayList<>();
		//Socket을 Key값으로 이용해 OutputStream을 관리한다.
		//개인 메세지를 보낼 때 : key로 Socket을 전달
		//전체 메세지를 보낼 때 : 저장된 모든 outs에 메세지 전달
		HashMap<Socket, PrintWriter> send_map = new HashMap<Socket, PrintWriter>();
		
		try {
			ServerSocket serversocket = new ServerSocket(3455);
			
			int count = 0;
			while(true) {
				//접속에 성공한 클라이언트들을 List에 저장하여 관리한다.
				System.out.println("연결을 기다리는 중..");
				Socket user = serversocket.accept();
				
				clients.add(user);
				PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(user.getOutputStream())));
				send_map.put(user, pw);
				
				for(PrintWriter out  : send_map.values()) {
						pw.printf("<%s>님이 채팅방에 접속하셨습니다.\n", user.getInetAddress());
						pw.flush();
				}
				
				if(count++ == 30) {
					break;
				}

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
