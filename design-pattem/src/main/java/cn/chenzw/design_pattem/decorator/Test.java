package cn.chenzw.design_pattem.decorator;

public class Test {

	public static void main(String[] args) {
		IComponent componentA = new ConcreteComponentA();
		Decorator decoratorY = new ConcreteDecoratorY(componentA);
		Decorator decoratorZ = new ConcreteDecoratorZ(decoratorY);

		decoratorY.methodA();
		System.out.println("-----------------");
		decoratorZ.methodB();

	}
}
