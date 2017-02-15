package cn.chenzw.design_pattem.decorator;
/**
 * 装饰者抽象类
 * 使用abstract是避免该类被实例化
 * @author chenzw
 * @date 2017年1月14日
 */
public abstract class Decorator implements IComponent {

	private IComponent component;

	Decorator(IComponent component) {
		this.component = component;
	}

	public void methodA() {
		this.component.methodA();
	}

	public void methodB() {
		this.component.methodB();
	}

}
