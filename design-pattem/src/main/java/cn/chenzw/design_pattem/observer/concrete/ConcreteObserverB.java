package cn.chenzw.design_pattem.observer.concrete;

import cn.chenzw.design_pattem.observer.IObserver;

/**
 * 具体观察者B
 * @author chenzw
 * @date 2017年1月13日
 */
public class ConcreteObserverB implements IObserver {

	public void update() {
		System.out.println("update ConcreteObserverB!");
	}

	public void update(String msg) {
		System.out.println("update ConcreteObserverB:" + msg);
	}

}
