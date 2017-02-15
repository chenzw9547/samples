package cn.chenzw.design_pattem.proxy.static_proxy;

public class Proxy implements ISubject {

	RealSubject realSubject = new RealSubject();

	@Override
	public void request() {
		// 添加前后业务
		System.out.println("request before");
		realSubject.request();
		System.out.println("request after;");
	}

}
