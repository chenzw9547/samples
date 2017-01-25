package cn.chenzw.simple_socket.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端
 * @author chenzw
 * @date 2017年1月25日
 */
public class Client {

	public static void main(String[] args) {
		try {
			//通过名字查询RMI registry，并返回远程对象的stub
			IRemote service = (IRemote) Naming
					.lookup("rmi://127.0.0.1:1099/my_remote");
			String ret = service.sayHello();
			System.out.println(ret);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
