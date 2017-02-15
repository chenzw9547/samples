package cn.chenzw.design_pattem.responsibility_chain;

public class ConcreteHandlerC extends Handler {

	@Override
	public void handleRequest(double fee) {
		if (fee < 1000) {
			System.out.println("ConcreteHandlerC handle request!");
		} else {
			if (getSuccessor() != null) {
				System.out.println("ConcreteHandlerC pass request!");
				getSuccessor().handleRequest(fee);
			}
		}
	}
}
