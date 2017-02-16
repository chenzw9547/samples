
## Socket Samples:
## 1. [普通的socket](src/main/java/cn/chenzw/simple_socket/normal)：


- 服务端：使用java.net.ServerSocket类
 - accept() : 阻塞直到接收到信息
- 客户端：使用java.net.Socket类
 - getOutputStream() : 获取输出流
 - getInputStream() : 获取输入流

## 2. [RMI远程方法调用](src/main/java/cn/chenzw/simple_socket/rmi)：

### 执行顺序：
- 远程服务被初始化
- 远程服务向RMI registry做注册
- 启动RMI registry
- 客户端查询RMI registry
- 客户端从RMI registry取得stub
- stub将方法的调用送到服务器上
- 客户端调用stub上的方法
