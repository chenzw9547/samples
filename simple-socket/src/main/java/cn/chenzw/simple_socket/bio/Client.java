package cn.chenzw.simple_socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Client {

	public void connectionAndReceive() {
		PrintWriter pw = null;
		BufferedReader br = null;
		Socket chatSocket = null;
		try {
			// 建立对服务器的Socket连接，使用8765端口
			chatSocket = new Socket("127.0.0.1", 8765);

			// 发送数据
			pw = new PrintWriter(chatSocket.getOutputStream(), true);
			pw.println("你好！"); //

			// 接收数据
			br = new BufferedReader(new InputStreamReader(
					chatSocket.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println("客户端收到:" + line);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (chatSocket != null) {
				try {
					chatSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Client client = new Client();
		client.connectionAndReceive();
	}
}
