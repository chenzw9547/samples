package cn.chenzw.design_pattem.factory;

import junit.framework.Assert;

public class Test {
	public static void main(String[] args) {
		Factory factoryA = new ConcreteFactoryA();
		Product productA = factoryA.create("500");
		Assert.assertEquals(21.5, productA.getPrice());
		
		Factory factoryB = new ConcreteFactoryB();
		Product productC = factoryB.create("500");
		Assert.assertEquals(11.5, productC.getPrice());
	}

}
