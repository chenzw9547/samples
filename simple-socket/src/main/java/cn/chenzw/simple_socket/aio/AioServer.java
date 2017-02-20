package cn.chenzw.simple_socket.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AioServer {

	// 线程池
	private ExecutorService executor;

	// 线程组
	private AsynchronousChannelGroup threadGroup;

	// 服务器通道
	public AsynchronousServerSocketChannel assc;

	AioServer(int port) throws InterruptedException {
		executor = Executors.newCachedThreadPool();
		try {
			threadGroup = AsynchronousChannelGroup.withCachedThreadPool(
					executor, 1);
			// 创建服务器通道
			assc = AsynchronousServerSocketChannel.open(threadGroup);

			assc.bind(new InetSocketAddress(port));

			assc.accept(this, new ServerCompletionHandler());

			// 一直阻塞不让服务器停止
			Thread.sleep(Integer.MAX_VALUE);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AioServer server = new AioServer(8765);
	}

}
