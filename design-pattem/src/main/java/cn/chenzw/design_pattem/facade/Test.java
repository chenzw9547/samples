package cn.chenzw.design_pattem.facade;

/**
 * 外观模式测试
 * 
 * @author chenzw
 * @date 2017年1月15日
 */
public class Test {

	public static void main(String[] args) {
		XFacade x = new XFacade(new A(), new B());
		x.go();
	}
}
