package cn.chenzw.design_pattem.proxy.dynamic_proxy.javassist;

import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.IDBQuery;
import cn.chenzw.design_pattem.proxy.dynamic_proxy.service.impl.DBQueryImpl;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import junit.framework.Assert;

public class Test {
	
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NotFoundException, CannotCompileException {
		testJavassistFactoryProxy();
		testJavassistProxy();
	}

	public static void testJavassistFactoryProxy()
			throws InstantiationException, IllegalAccessException {
		/**
		 * 使用代理工厂创建
		 */
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setInterfaces(new Class[] { IDBQuery.class });
		Class proxyClass = proxyFactory.createClass();
		IDBQuery javassisProxy = (IDBQuery) proxyClass.newInstance();

		// 设置Handler处理器
		((ProxyObject) javassisProxy)
				.setHandler(new JavassistDynDbQueryHandler());

		Assert.assertEquals("hello world!", javassisProxy.request());
		Assert.assertEquals("request2", javassisProxy.request2());

	}

	public static void testJavassistProxy() throws NotFoundException,
			CannotCompileException, InstantiationException,
			IllegalAccessException {

		ClassPool mPool = new ClassPool(true);

		// 定义类名
		CtClass mCtc = mPool.makeClass(IDBQuery.class.getName()
				+ "Javaassists-BytecodeProxy");

		// 需要实现的接口
		mCtc.addInterface(mPool.get(IDBQuery.class.getName()));

		// 添加构造器
		mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));

		// 添加类的字段信息,使用动态Java代码
		mCtc.addField(CtField.make("public " + IDBQuery.class.getName()
				+ " real;", mCtc));

		String dbqueryname = DBQueryImpl.class.getName();

		// 添加方法, 这里使用动态Java代码指定内部逻辑
		mCtc.addMethod(CtNewMethod.make(
				"public String request(){ if(real == null) real = new "
						+ dbqueryname + "(); return real.request();}", mCtc));

		// 基于以上信息,生成动态类
		Class pc = mCtc.toClass();

		// 生成动态类的实例
		IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();

		Assert.assertEquals("hello world!", bytecodeProxy.request());
		Assert.assertEquals("request2", bytecodeProxy.request2());

	}
}
