package cn.chenzw.design_pattem.proxy.dynamic_proxy.javassist;

import java.lang.reflect.Method;

import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;
import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.impl.DBQueryImpl;
import javassist.util.proxy.MethodHandler;

/**
 * 使用Javassist实现动态代理
 * 
 * @author chenzw
 *
 */
public class JavassistDynDbQueryHandler implements MethodHandler {

	private IDBQuery real = null; // 主题接口

	public Object invoke(Object self, Method thisMethod, Method proceed,
			Object[] args) throws Throwable {

		System.out
				.println("调用了javassist动态代理方法:" + thisMethod.toGenericString());

		/**
		 * 延迟加载
		 */
		if (real == null) {
			real = new DBQueryImpl();
		}

		return thisMethod.invoke(real, args);
	}

}
