package cn.chenzw.simple_socket.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程对象 -- 必须实现java.rmi.server.UniCastRemoteObject类，这样才能保证客户端访问获得远程对象时，
 * 该远程对象将会把自身的一个拷贝以Socket的形式传输给客户端，此时客户端所获得的这个拷贝称为“存根”，
 * 而服务器端本身已存在的远程对象则称之为“骨架”。其实此时的存根是客户端的一个代理，用于与服务器端的通信，
 * 而骨架也可认为是服务器端的一个代理，用于接收客户端的请求之后调用远程方法来响应客户端的请求。
 * 
 * @author chenzw
 * @date 2017年1月25日
 */
public class RemoteImpl extends UnicastRemoteObject implements IRemote {

	private static final long serialVersionUID = 1L;

	// 必须声明一个抛出RemoteException异常的无参构造函数
	protected RemoteImpl() throws RemoteException {
		super();
	}

	// 此处可以省略抛出RemoteException
	public String sayHello() {
		return "hello world!";
	}

	public static void main(String[] args) {
		try {
			IRemote service = new RemoteImpl();
			// 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上侦听到来的请求
			LocateRegistry.createRegistry(1099);
			// 向RMI registry注册服务，RMI系统会把此stub加到registry中
			Naming.rebind("my_remote", service); //客户端通过此名称查询registry
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
