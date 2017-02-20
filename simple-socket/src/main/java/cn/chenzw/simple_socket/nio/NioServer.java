package cn.chenzw.simple_socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Logger;

public class NioServer implements Runnable {
	
	private static final Logger logger = Logger.getLogger(NioServer.class.getName());
	
	// 多路复用器（管理所有的通道）
	private Selector selector;

	/**
	 * 初始化配置
	 * 
	 * @param port
	 *            服务端绑定的端口
	 */
	public NioServer(int port) {
		try {
			logger.info("初始化配置...");
			
			// 1. 打开多路复用器
			this.selector = Selector.open();
			// 2. 打开服务器通道
			ServerSocketChannel ssc = ServerSocketChannel.open();
			// 3. 设置服务器通道为非阻塞模式
			ssc.configureBlocking(false);
			// 4. 绑定地址
			ssc.bind(new InetSocketAddress(port));
			// 5. 把服务通道注册到多路复用器上，并且监听阻塞事件
			ssc.register(this.selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 每次接收到新的连接都会调用此方法进行注册
	 * @param key
	 */
	public void accept(SelectionKey key) {
		logger.info(key + " accept...");
		
		// 1. 获取到的是ServerSocketChannel，因为这是我们注册的唯一一种支持accept操作的信道
		ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
		try {
			// 2. 执行阻塞方法
			SocketChannel sc = ssc.accept();
			// 3. 设置阻塞模式
			sc.configureBlocking(false);
			// 4. 注册到多路复用器上，并设置为可读可写标识
			sc.register(this.selector, SelectionKey.OP_READ
					| SelectionKey.OP_WRITE);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void read(SelectionKey key) {
		logger.info(key + " read...");
		
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer readBuf = ByteBuffer.allocate(1024);
		try {
			int count = sc.read(readBuf);
			// 没有数据,需要关闭信道。
			if (count == -1) {
				key.channel().close();
				key.cancel();
				return;
			}
			// 有数据,读取前先进行复位方法
			readBuf.flip();
			// 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
			byte[] bytes = new byte[readBuf.remaining()];
			// 接收缓冲区数据
			readBuf.get(bytes);
			String msg = new String(bytes).trim();
			System.out.println("Server:" + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(SelectionKey key) {
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				// 1. 多路复用器开始监听，阻塞直到一个或更多的信道准备好了 I/O 操作或等待超时，返回可进行 I/O 操作的信道数量
				this.selector.select();
				// 2.获取多路复用器所有已准备就绪的Channel的key值
				Iterator<SelectionKey> keys = this.selector.selectedKeys()
						.iterator();
				while (keys.hasNext()) {
					// 3. 获取一个Channel key，并移除
					SelectionKey key = keys.next();
					keys.remove();

					if (key.isValid()) {
						// 4. 获取我们刚注册的ServerSocketChannel
						if (key.isAcceptable()) {
							this.accept(key);
						}

						// 5. 客户端数据读取
						if (key.isReadable()) {
							this.read(key);
						}
						/*
						 * if (key.isWritable()) { this.write(key); }
						 */
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new NioServer(8746)).start();
	}

}
