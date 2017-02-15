package cn.chenzw.design_pattem.responsibility_chain;

public class Test {

	public static void main(String[] args) {
		Handler h1 = new ConcreteHandlerA();
		Handler h2 = new ConcreteHandlerB();
		Handler h3 = new ConcreteHandlerC();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		System.out.println("----50----");
		h1.handleRequest(50);
		System.out.println("----400----");
		h1.handleRequest(400);
		System.out.println("----1500----");
		h1.handleRequest(1500);
	}
}
