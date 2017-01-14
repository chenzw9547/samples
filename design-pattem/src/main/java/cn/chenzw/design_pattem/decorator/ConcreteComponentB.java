package cn.chenzw.design_pattem.decorator;
/**
 * 具体被装饰者B,主要实现核心的业务逻辑B
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteComponentB implements IComponent {

	public void methodA() {
		System.out.println("ConcreteComponentB执行方法A!");
	}

	public void methodB() {
		System.out.println("ConcreteComponentB执行方法B!");
	}

}
