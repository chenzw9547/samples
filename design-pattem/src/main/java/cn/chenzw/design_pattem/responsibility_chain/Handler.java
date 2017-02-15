package cn.chenzw.design_pattem.responsibility_chain;

public abstract class Handler {

	/**
	 * 持有后继的责任对象
	 */
	protected Handler successor;

	/**
	 * 示意处理请求的方法，根据具体需要来选择是否传递参数
	 */
	public abstract void handleRequest(double fee);

	/**
	 * 取值方法
	 */
	public Handler getSuccessor() {
		return successor;
	}

	/**
	 * 赋值方法，设置后继的责任对象
	 */
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
}
