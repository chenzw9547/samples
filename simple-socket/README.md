
## Socket Samples / IO模型:

** 同步和异步 ** 的概念描述的是用户线程与内核的交互方式：同步是指用户线程发起IO请求后需要等待或者轮询内核IO操作完成后才能继续执行；而异步是指用户线程发起IO请求后仍继续执行，当内核IO操作完成后会通知用户线程，或者调用用户线程注册的回调函数。

** 阻塞和非阻塞 ** 的概念描述的是用户线程调用内核IO操作的方式：阻塞是指IO操作需要彻底完成后才返回到用户空间；而非阻塞是指IO操作被调用后立即返回给用户一个状态值，无需等到IO操作彻底完成。


## 1. [BIO(Blocking IO)](src/main/java/cn/chenzw/simple_socket/bio) - ** 同步阻塞 ** ：

** 特点 ** : thread per request;基于流传输;主动轮询所有客户端是否有I/O操作;

- 服务端：使用java.net.ServerSocket类
 - accept() : 阻塞直到接收到信息
 - getOutputStream() : 获取输出流
 - getInputStream() : 获取输入流
- 客户端：使用java.net.Socket类
 - getOutputStream() : 获取输出流
 - getInputStream() : 获取输入流

## 2. [NIO(Non-blocking IO,非New IO库)](src/main/java/cn/chenzw/simple_socket/nio) - ** 同步非阻塞 ** :

** 特点 ** : 事件驱动、非阻塞; 使用Buffer传输; 客户端准备就绪时通知服务端, 只使用一个线程轮询;

- 客户端: 使用SocketChannel类
 - SocketChanne.open() : 打开通道(创建一个SocketChannel对象)
 - connect() : 连接通道到服务器
 - configureBlocking() : 是否阻塞
 - write() : 往通道上写入数据
 - read() : 读取通道上的数据
- 服务端: 使用ServerSocketChannel类 和 Selector类
  - ServerSocketChannel类主要有以下方法:
    - ServerSocketChannel.open(): 创建一个ServerSocketChannel对象
    - configureBlocking() : 是否阻塞
    - bind() : 绑定监听的ip、端口
    - register() : 把Channel注册到多路复用器(Selector)上，并且监听某状态事件
    - accept() :
  - Selector类主要有以下方法:
   - Selector.open() :  创建一个Selector对象
   - select() : 阻塞直到一个或更多的信道准备好了 I/O 操作或等待超时，返回可进行 I/O 操作的信道数量
   - selectedKeys() : 获取多路复用器所有已准备就绪的Channel的key值

** NIO的3个重要组件: **
- ** Buffer（缓冲）** ：一块连续的内存块，是读写数据的中转地。实质是一个数组。
- ** Channel（通道）** ：表示缓冲的源头或目的地，是访问缓冲的接口。它是个双向通道（流是单向的，如InputStream或OutputStream），可读，可写，应用程序不能直接对Channel进行读写操作，必须通过Buffer来进行。Channel主要分为两大类：一类是网络读写的（SelectableChannel, SocketChannel和ServerSocketChannel都是SelectableChannel的子类），一类用于文件操作的（FileChannel）
- ** Selector（选择器/多路复用器）** ：客户端（SocketChannel）必须注册到Selector上（Selector会分配给每个管道一个key值），Selector轮询所有注册的通道，根据通道的状态（Connect连接状态、Accept阻塞状态、Read可读状态、Write可写状态），执行相关操作。通过SelectionKey可以取得就绪的Channel集合，从而进行后续的IO操作。

** Selector的状态 ** ：
- SelectionKey.OP_CONNECT
- SelectionKey.OP_ACCEPT
- SelectionKey.OP_READ
- SelectionKey.OP_WRITE


## 3. [AIO(Asynchronous IO)](src/main/java/cn/chenzw/simple_socket/aio) - ** 异步非阻塞 ** :

- 客户端：使用AsynchronousSocketChannel类
  - AsynchronousSocketChannel.open(): 创建一个AsynchronousSocketChannel对象
  - connect(): 连接到服务端
  - write() : 往通道上写入数据
  - read() : 读取通道上的数据
- 服务端：使用AsynchronousServerSocketChannel类
 - AsynchronousServerSocketChannel.open(): 创建一个AsynchronousServerSocketChannel对象
 - bind(): 绑定监听的ip、端口
 - accept(): 

## 2. [RMI远程方法调用](src/main/java/cn/chenzw/simple_socket/rmi)：

### 执行顺序：
- 远程服务被初始化
- 远程服务向RMI registry做注册
- 启动RMI registry
- 客户端查询RMI registry
- 客户端从RMI registry取得stub
- stub将方法的调用送到服务器上
- 客户端调用stub上的方法
