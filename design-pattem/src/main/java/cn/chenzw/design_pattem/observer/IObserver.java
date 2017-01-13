package cn.chenzw.design_pattem.observer;

/**
 * 观察者
 * 
 * @author chenzw
 * @date 2017年1月13日
 */
public interface IObserver {

	void update();

	void update(String msg);
}
