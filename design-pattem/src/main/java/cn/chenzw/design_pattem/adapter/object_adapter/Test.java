package cn.chenzw.design_pattem.adapter.object_adapter;

import java.lang.annotation.Target;

import junit.framework.Assert;

/**
 * 对象适配器示例
 * 
 * @author chenzw
 * @date 2017年1月15日
 */
public class Test {

	public static void main(String[] args) {
		ITarget target = new Adapter(new Adaptee());
		Assert.assertEquals("specific request", target.request());
	}
}
