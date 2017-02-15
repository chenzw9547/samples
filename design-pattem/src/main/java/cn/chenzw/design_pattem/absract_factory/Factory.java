package cn.chenzw.design_pattem.absract_factory;

/**
 * 抽象工厂类
 * ProductA和ProductB搭配使用
 * @author chenzw
 * @date 2017年1月14日
 */
public abstract class Factory {

	abstract ProductA createProductA();
	
	abstract ProductB createProductB();
	
}
