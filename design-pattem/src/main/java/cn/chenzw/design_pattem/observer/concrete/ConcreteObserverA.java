package cn.chenzw.design_pattem.observer.concrete;

import cn.chenzw.design_pattem.observer.IObserver;
/**
 * 具体观察者A
 * @author chenzw
 * @date 2017年1月13日
 */
public class ConcreteObserverA implements IObserver {

	public void update() {
		System.out.println("update ConcreteObserverA!");
	}

	public void update(String msg) {
		System.out.println("update ConcreteObserverA:" + msg);	
	}

}
