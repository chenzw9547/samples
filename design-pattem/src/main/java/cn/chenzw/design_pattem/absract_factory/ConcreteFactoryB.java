package cn.chenzw.design_pattem.absract_factory;

/**
 * 具体工厂类B
 * ConcreteProductA2与ConcreteProductB2产品是搭配使用
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteFactoryB extends Factory {

	@Override
	ProductA createProductA() {
		return new ConcreteProductA2();
	}

	@Override
	ProductB createProductB() {
		return new ConcreteProductB2();
	}

}
