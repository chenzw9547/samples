package cn.chenzw.design_pattem.simple_factory;

public class Factory {

	public static Product getProduct(Integer id) {
		switch (id) {
		case 1:
			return new ConcreteProductA();
		case 2:
			return new ConcreteProductB();
		}
		return null;
	}
}
