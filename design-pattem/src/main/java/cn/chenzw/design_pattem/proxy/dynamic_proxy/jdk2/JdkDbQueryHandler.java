package cn.chenzw.design_pattem.proxy.dynamic_proxy.jdk2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;
import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.impl.DBQueryImpl;

/**
 * 使用JDK自带的动态代理生成代理对象
 * 
 * @author chenzw
 *
 */
public class JdkDbQueryHandler implements InvocationHandler {

	private IDBQuery real = null; // 主题接口

	private Object target;

	public JdkDbQueryHandler() {
	}

	/**
	 * 重载构造器,可以传入动态对象
	 * 
	 * @param target
	 */
	public JdkDbQueryHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("调用了JDK动态代理方法:" + method.toGenericString());

		/**
		 * 延迟加载
		 */
		if (real == null) {
			real = new DBQueryImpl();
		}

		return method.invoke(real, args);
	}
}
