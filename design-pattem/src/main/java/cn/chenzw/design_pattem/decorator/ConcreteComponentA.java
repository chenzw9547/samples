package cn.chenzw.design_pattem.decorator;
/**
 * 具体被装饰者A,主要实现核心的业务逻辑A
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteComponentA implements IComponent {

	public void methodA() {
		System.out.println("ConcreteComponentA执行方法A!");
	}

	public void methodB() {
		System.out.println("ConcreteComponentA执行方法B!");

	}

}
