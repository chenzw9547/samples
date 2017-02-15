package cn.chenzw.design_pattem.singleton.inner;

import java.io.Serializable;

/**
 * 使用内部静态类来维护单例实例 
 * 特点: 既可以做到延迟加载,也不必使用同步关键字,是一种比较完善的实现.
 * 
 * @author chenzw
 *
 */
public class StaticSingleton implements Serializable {

	/**
	 * 私有化构造器
	 */
	private StaticSingleton() {
	}

	/**
	 * 当StaticSingleton被加载时,其内部类不会被初始化,只有真正调用getInstance()时,才会初始化实例。
	 * 
	 * @author chenzw
	 *
	 */
	private static class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * 反序列化时仍然返回唯一的那个实例.
	 * 
	 * @return
	 */
	public Object readResolve() {
		return SingletonHolder.instance;
	}
}
