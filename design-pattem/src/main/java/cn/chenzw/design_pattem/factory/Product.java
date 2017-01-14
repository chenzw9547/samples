package cn.chenzw.design_pattem.factory;

public abstract class Product {

	// 产品名称
	String name;
	// 产品价格
	double price;
	// 产品型号
	String model;

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getModel() {
		return model;
	}

}
