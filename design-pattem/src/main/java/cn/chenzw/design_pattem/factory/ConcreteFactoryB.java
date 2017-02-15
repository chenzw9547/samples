package cn.chenzw.design_pattem.factory;

public class ConcreteFactoryB extends Factory {

	@Override
	Product create(String model) {
		if (model == "500") {
			return new ConcreteProductC();
		}
		return null;
	}

}
