package cn.chenzw.design_pattem.observer;

public interface ISubject {

	/**
	 * 添加观察者
	 * 
	 * @param observer
	 */
	void attach(IObserver observer);

	/**
	 * 删除观察者
	 * 
	 * @param observer
	 */
	void detach(IObserver observer);

	/**
	 * 通知所有观察者
	 */
	void notifyObservers();

	/**
	 * 通知所有观察者 -- 带参数
	 * 
	 * @param msg
	 */
	void notifyObservers(String msg);
}
