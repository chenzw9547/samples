package cn.chenzw.simple_socket.normal;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void run() {
		PrintWriter pw = null;
		try {
			// 1.对特定端口创建出ServerSocket
			ServerSocket serverSocket = new ServerSocket(5000);
			// 2. 阻塞直到客户端连接
			Socket socket = serverSocket.accept();
			// 3. 发送数据
			pw = new PrintWriter(socket.getOutputStream());
			pw.println("Hello!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}
}
