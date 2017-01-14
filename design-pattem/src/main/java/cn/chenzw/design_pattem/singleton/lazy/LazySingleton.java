package cn.chenzw.design_pattem.singleton.lazy;

/**
 * 懒汉式 
 * 缺点: 方法上的同步导致处理耗时远远大于饿汉式
 * 
 * @author chenzw
 */
public class LazySingleton {

	/**
	 * 私有化构造器
	 */
	private LazySingleton() {
	}

	private static LazySingleton lazySingleton = null;

	/**
	 * 多线程环境下,该方法必须是同步的,否则可能导致创建多个实例.
	 * 
	 * @return
	 */
	public static synchronized LazySingleton getInstance() {
		if (lazySingleton != null) {
			return new LazySingleton();
		}
		return lazySingleton;
	}

	/**
	 * 反序列化时仍然返回唯一的那个实例.
	 * 
	 * @return
	 */
	public Object readResolve() {
		return lazySingleton;
	}
}
