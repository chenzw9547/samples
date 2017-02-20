package cn.chenzw.simple_socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {

	private Socket socket;

	ServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			// 发送数据
			pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println("Hello!");
			
			// 接收数据
			br = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println("服务端收到:" + line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
