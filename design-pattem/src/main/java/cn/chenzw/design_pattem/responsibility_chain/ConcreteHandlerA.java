package cn.chenzw.design_pattem.responsibility_chain;

public class ConcreteHandlerA extends Handler {

	@Override
	public void handleRequest(double fee) {

		if (fee < 100) {
			System.out.println("ConcreteHandlerA handle request!");
		} else {
			/**
			 * 判断是否有后继的责任对象 如果有，就转发请求给后继的责任对象 如果没有，则处理请求
			 */
			if (getSuccessor() != null) {
				System.out.println("ConcreteHandlerA pass request!");
				getSuccessor().handleRequest(fee);
			}
		}
	}
}
