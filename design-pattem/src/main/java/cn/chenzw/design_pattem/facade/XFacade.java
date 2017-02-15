package cn.chenzw.design_pattem.facade;

public class XFacade {

	private IA a;
	private IB b;

	XFacade(IA a, IB b) {
		this.a = a;
		this.b = b;
	}

	public void go() {
		this.a.run();
		this.b.work();
	}
}
