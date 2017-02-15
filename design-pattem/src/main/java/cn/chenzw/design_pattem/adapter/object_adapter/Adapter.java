package cn.chenzw.design_pattem.adapter.object_adapter;

/**
 * 对象适配器
 * @author chenzw
 * @date 2017年1月15日
 */
public class Adapter implements ITarget {

	private Adaptee adaptee;

	Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public String request() {
		return this.adaptee.specificRequest();
	}

}
