package cn.chenzw.design_pattem.state;

import junit.framework.Assert;

public class Test {

	public static void main(String[] args) {
		Context context = new Context(new ConcreteStateA());
		Assert.assertEquals("This is A!", context.switchState());
		Assert.assertEquals("This is B!", context.switchState());
		Assert.assertEquals("This is C!", context.switchState());
	}

}