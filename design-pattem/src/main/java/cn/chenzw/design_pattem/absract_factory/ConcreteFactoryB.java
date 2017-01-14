package cn.chenzw.design_pattem.absract_factory;

/**
 * 具体工厂类B
 * ConcreteProductA2与ConcreteProductB2是同一产品族
 * 如汽车Factory, ProductA为车标,ProductB为轮胎
 * FactoryB为宝马汽车工厂,ConcreteProductA2为宝马车标,ConcreteProductB2为宝马轮胎
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
