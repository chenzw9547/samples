package cn.chenzw.design_pattem.proxy.dynamic_proxy.jdk2;

import java.lang.reflect.Proxy;



import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;
import junit.framework.Assert;

public class Test {

	public static void main(String[] args) {
		testJdkProxy();
	}

	public static void testJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] { IDBQuery.class }, new JdkDbQueryHandler());
		Assert.assertEquals("hello world!", jdkProxy.request());
		Assert.assertEquals("request2", jdkProxy.request2());
	}
}
