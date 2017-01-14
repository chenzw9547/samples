package cn.chenzw.design_pattem.absract_factory;

public class Test {

	public static void main(String[] args) {
		Factory factoryA = new ConcreteFactoryA();
		ProductA productA = factoryA.createProductA();
		ProductB productB = factoryA.createProductB();
		
		System.out.println(productA.getName());
		System.out.println(productB.getName());
		
		Factory factoryB = new ConcreteFactoryB();
		ProductA productA2 = factoryB.createProductA();
		ProductB productB2 = factoryB.createProductB();
		
		System.out.println(productA2.getName());
		System.out.println(productB2.getName());
		
		
	}
}
