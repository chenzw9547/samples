package cn.chenzw.simple_socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;

public class Server {

	private ExecutorService excutor = new ThreadPoolExecutor(10, 100, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));

	public void run() {
		ServerSocket serverSocket = null;
		try {
			// 1.对特定端口创建出ServerSocket
			serverSocket = new ServerSocket(8765);
			while (true) {
				// 2. 阻塞直到接收到客户端连接，返回此连接的socket
				Socket socket = serverSocket.accept();

				// 使用线程进行数据接收和发送
				excutor.submit(new ServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			excutor.shutdown();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}
}
