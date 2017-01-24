package cn.chenzw.simple_socket.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void connectionAndReceive() {
		try {
			// 1.建立对服务器的Socket连接，使用5000端口
			Socket chatSocket = new Socket("127.0.0.1", 5000);
			// 2.建立连接到Socket上低层输入串流的InputStreamReader
			InputStreamReader isr = new InputStreamReader(
					chatSocket.getInputStream());
			// 3.建立BufferedReader来读取
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.connectionAndReceive();
	}
}
