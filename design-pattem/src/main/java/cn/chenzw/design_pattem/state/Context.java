package cn.chenzw.design_pattem.state;

/**
 * 上下文环境类 它定义了客户程序需要的接口并维护一个具体状态角色的实例，将与状态相关的操作委托给当前的Concrete State对象来处理。
 * 
 * @author chenzw
 * @date 2017年1月16日
 */
public class Context {

	private State state;

	Context(State state) {
		this.state = state;
	}

	public void setState(State state) {
		this.state = state;
	}

	// 客户程序需要的接口
	public String switchState() {
		return this.state.next(this);
	}

	// 客户程序需要的接口
	public String dosth() {
		return this.state.request(this);
	}

}
