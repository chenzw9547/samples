package cn.chenzw.design_pattem.strategy;

import cn.chenzw.design_pattem.strategy.concrete.ConcreteStrategyA;
import cn.chenzw.design_pattem.strategy.concrete.ConcreteStrategyC;
/**
 * 策略模式
 * @author chenzw
 * @date 2017年1月13日
 */
public class Test {
	public static void main(String[] args) {
		//IStrategy stragegy = new ConcreteStrategyA();
		//IStrategy stragegy = new ConcreteStrategyB();
		IStrategy stragegy = new ConcreteStrategyC();
		Context context = new Context(stragegy);
		context.contextInterface();
	}
}
