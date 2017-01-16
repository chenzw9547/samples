package cn.chenzw.design_pattem.template;

public class ConcreteTemplate extends AbstractTemplate {

	@Override
	protected void operation1() {
		System.out.println("operation1!");
	}

	@Override
	protected void operation2() {
		System.out.println("operation2!");
	}

	@Override
	protected void operation3() {
		System.out.println("operation3!");
	}

	@Override
	protected boolean isExists() {
		return true;
	}

}
