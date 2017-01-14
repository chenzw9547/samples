package cn.chenzw.design_pattem.absract_factory;

/**
 * 具体工厂类A
 * ConcreteProductA1与ConcreteProductB1是同一产品族
 * 如汽车Factory, ProductA为车标,ProductB为轮胎
 * FactoryA为奔驰汽车工厂,ConcreteProductA1为奔驰车标,ConcreteProductB1为奔驰轮胎
 * @author chenzw
 * @author chenzw
 * @date 2017年1月14日
 */
public class ConcreteFactoryA extends Factory {

	@Override
	ProductA createProductA() {
		return new ConcreteProductA1();
	}

	@Override
	ProductB createProductB() {
		return new ConcreteProductB1();
	}

}
