package cn.chenzw.design_pattem.factory;

public class ConcreteFactoryA extends Factory {

	@Override
	Product create(String model) {
		if (model == "500") {
			return new ConcreteProductA();
		} else if (model == "300") {
			return new ConcreteProductB();
		}
		return null;
	}

}
