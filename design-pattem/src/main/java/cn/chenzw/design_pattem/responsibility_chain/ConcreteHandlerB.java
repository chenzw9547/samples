package cn.chenzw.design_pattem.responsibility_chain;

public class ConcreteHandlerB extends Handler {

	@Override
	public void handleRequest(double fee) {
		if (fee < 500) {
			System.out.println("ConcreteHandlerB handle request!");
		} else {
			if (getSuccessor() != null) {
				System.out.println("ConcreteHandlerB pass request!");
				getSuccessor().handleRequest(fee);
			}
		}
	}
}
