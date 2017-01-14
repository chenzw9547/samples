package cn.chenzw.design_pattem.decorator;

/**
 * 具体装饰者X
 * 用于对被装饰者进行X方案的装饰
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteDecoratorX extends Decorator {

	ConcreteDecoratorX(IComponent component) {
		super(component);
	}

	@Override
	public void methodA() {
		System.out.println("X执行方法A start!");
		super.methodA();
		System.out.println("X执行方法A end!");
	}

	@Override
	public void methodB() {
		System.out.println("X执行方法B start!");
		super.methodB();
		System.out.println("X执行方法B end!");
	}

}
