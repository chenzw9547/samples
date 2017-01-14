package cn.chenzw.design_pattem.absract_factory;

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
