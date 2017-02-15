package cn.chenzw.design_pattem.proxy.static_proxy;

public class Test {
	public static void main(String[] args) {
		ISubject subject = new Proxy();
		subject.request();
	}
}
