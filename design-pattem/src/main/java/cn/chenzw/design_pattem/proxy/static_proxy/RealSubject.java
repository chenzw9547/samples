package cn.chenzw.design_pattem.proxy.static_proxy;

public class RealSubject implements ISubject {

	@Override
	public void request() {
		System.out.println("real request!");
	}

}
