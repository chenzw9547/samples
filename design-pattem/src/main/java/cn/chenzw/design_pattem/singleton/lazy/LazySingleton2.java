package cn.chenzw.design_pattem.singleton.lazy;

/**
 * 懒汉式 --使用双重检查锁
 * 缺点: 方法上的同步导致处理耗时远远大于饿汉式
 * @author chenzw
 */
public class LazySingleton2 {

	/**
	 * 私有化构造器
	 */
	private LazySingleton2() {
	}
	
	//注意使用volatile关键字保持变量同步
	private volatile static LazySingleton2 lazySingleton = null;

	/**
	 * 多线程环境下,该方法必须是同步的,否则可能导致创建多个实例. 
	 * 使用双重检查锁,只在第一次初始化时进行锁定
	 * 
	 * @return
	 */
	public static LazySingleton2 getInstance() {
		if (lazySingleton == null) {
			synchronized (LazySingleton2.class) {
				if (lazySingleton == null) {
					lazySingleton = new LazySingleton2();
				}
			}
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
