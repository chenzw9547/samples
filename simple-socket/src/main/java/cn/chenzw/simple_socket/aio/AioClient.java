package cn.chenzw.simple_socket.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class AioClient implements Runnable{

	private AsynchronousSocketChannel asc;

	AioClient() throws IOException {
		this.asc = AsynchronousSocketChannel.open();
	}
	
	public void connect(){
		asc.connect(new InetSocketAddress("127.0.0.1", 8765));
	}
	
	public void write(String msg){
		try {
			asc.write(ByteBuffer.wrap(msg.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.connect();
		
		try {
			// 确保连接完成
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.write("hello! my code is :" + this.hashCode());
	}

	public static void main(String[] args) throws IOException {
		new Thread(new AioClient()).start();
		new Thread(new AioClient()).start();
	}
}
