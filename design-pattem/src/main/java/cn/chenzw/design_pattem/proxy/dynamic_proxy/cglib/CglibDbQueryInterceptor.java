package cn.chenzw.design_pattem.proxy.dynamic_proxy.cglib;

import java.lang.reflect.Method;

import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;
import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.impl.DBQueryImpl;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用CGLIB实现动态代理
 * 
 * @author chenzw
 *
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {

	private IDBQuery real = null;

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {

		System.out.println("调用了CGLIB动态代理方法:" + method.toGenericString());

		/**
		 * 延迟加载
		 */
		if (real == null) {
			real = new DBQueryImpl();
		}
		return method.invoke(real, args);
	}
}
