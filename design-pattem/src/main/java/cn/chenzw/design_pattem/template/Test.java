package cn.chenzw.design_pattem.template;

public class Test {

	public static void main(String[] args) {
		AbstractTemplate template = new ConcreteTemplate();
		template.templateMethod();
	}
}
