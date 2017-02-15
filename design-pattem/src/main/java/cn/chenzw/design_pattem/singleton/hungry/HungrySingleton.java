package cn.chenzw.design_pattem.singleton.hungry;

/**
 * 饿汉式
 * 缺点: JVM加载单例类时,单例对象就会被创建了
 * @author chenzw
 *
 */
public class HungrySingleton {
	
	/**
	 * 私有化构造器
	 */
	private HungrySingleton(){}

	private static HungrySingleton hungrySingleton = new HungrySingleton();
	
	public static HungrySingleton getInstance(){
		return hungrySingleton;
	}
	
	/**
	 * 反序列化时仍然返回唯一的那个实例.
	 * @return
	 */
	public Object readResolve(){
		return hungrySingleton;
	}
	
}
