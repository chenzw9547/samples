package cn.chenzw.simple_socket.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口
 * @author chenzw
 * @date 2017年1月25日
 */
// 1.继承java.rmi.Remote接口，Remote接口用于标识其方法可以从非本地虚拟机上调用的接口。
public interface IRemote extends Remote {

	// 2.提供远程调用的方法都必须抛出RemoteException异常，并且其参数及返回值都必须是primitive主类型或Serializable。
	public String sayHello() throws RemoteException;

}
