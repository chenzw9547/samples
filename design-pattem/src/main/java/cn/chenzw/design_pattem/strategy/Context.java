package cn.chenzw.design_pattem.strategy;

public class Context {
	// 持有一个具体策略的对象
	private IStrategy strategy;

	/**
	 * 构造函数，传入一个具体策略对象
	 * 
	 * @param strategy
	 *            具体策略对象
	 */
	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 策略方法
	 */
	public void contextInterface() {
		strategy.strategyInterface();
	}

}
