package cn.chenzw.design_pattem.simple_factory;

import junit.framework.Assert;


public class Test {

	public static void main(String[] args) {
		Product product1 = Factory.getProduct(1);
		Assert.assertEquals(21.5, product1.getPrice());

		Product product2 = Factory.getProduct(2);
		Assert.assertEquals(56.4, product2.getPrice());
	}
}
