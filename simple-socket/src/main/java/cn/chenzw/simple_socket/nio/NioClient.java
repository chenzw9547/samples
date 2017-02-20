package cn.chenzw.simple_socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

	public static void main(String[] args) throws InterruptedException {
		SocketChannel sc = null;
		try {
			// 1. 打开通道
			sc = SocketChannel.open();

			// 2. 连接通道
			sc.connect(new InetSocketAddress("127.0.0.1", 8746));
			sc.configureBlocking(false);
			
			ByteBuffer byteBuf = ByteBuffer.allocate(1024);
			//while(true){
				byteBuf.clear();
				byteBuf.put("hello!".getBytes());
				
				// 缓冲区必须复位
				byteBuf.flip();
				sc.write(byteBuf);
				
				//Thread.sleep(5000);
			//}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
