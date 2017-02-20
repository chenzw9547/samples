package cn.chenzw.simple_socket.aio;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerCompletionHandler implements
		CompletionHandler<AsynchronousSocketChannel, AioServer> {

	/**
	 * 
	 * @param asc 客户端连接通道
	 */
	@Override
	public void completed(AsynchronousSocketChannel asc, AioServer attachment) {
		//监听新的请求，递归调用。
		attachment.assc.accept(attachment, this);

		// tcp各项参数
		try {
			asc.setOption(StandardSocketOptions.TCP_NODELAY, true);
			asc.setOption(StandardSocketOptions.SO_SNDBUF, 1024);
			asc.setOption(StandardSocketOptions.SO_RCVBUF, 1024);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (asc.isOpen()) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			asc.read(byteBuffer, byteBuffer,
					new CompletionHandler<Integer, ByteBuffer>() {

						/**
						 * 读取完成时触发
						 * 
						 * @param resultSize
						 *            读取到的字节数
						 * @param attachment
						 */
						@Override
						public void completed(Integer resultSize,
								ByteBuffer attachment) {
							
							//if(resultSize < 0){}
							
							attachment.flip();

							byte[] bytes = new byte[attachment.remaining()];
							attachment.get(bytes);
							System.out.println("Server Receive:"
									+ new String(bytes));
						}

						@Override
						public void failed(Throwable exc, ByteBuffer attachment) {
							exc.printStackTrace();
						}

					});
		}

	}

	@Override
	public void failed(Throwable exc, AioServer attachment) {
		exc.printStackTrace();
	}

}
