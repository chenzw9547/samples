package cn.chenzw.design_pattem.proxy.dynamic_proxy.cglib;

import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;
import junit.framework.Assert;
import net.sf.cglib.proxy.Enhancer;

public class Test {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		// 指定切入器,定义代理类逻辑
		enhancer.setCallback(new CglibDbQueryInterceptor());
		// 指定实现的接口
		enhancer.setInterfaces(new Class[] { IDBQuery.class });
		// 生成代理类的实例
		IDBQuery cglibProxy = (IDBQuery) enhancer.create();

		Assert.assertEquals("hello world!", cglibProxy.request());
		Assert.assertEquals("request2", cglibProxy.request2());
	}
}
