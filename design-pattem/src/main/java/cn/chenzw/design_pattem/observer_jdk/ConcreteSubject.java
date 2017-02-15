package cn.chenzw.design_pattem.observer_jdk;

import java.util.Observable;
/**
 * 具体主题A，使用JDK自带的Observable对象
 * @author chenzw
 * @date 2017年1月13日
 */
public class ConcreteSubject extends Observable {

	public void change(String msg) {
		// 注意,必须先设置setChange(),再调用通知
		setChanged();
		notifyObservers(msg); 
	}

}
