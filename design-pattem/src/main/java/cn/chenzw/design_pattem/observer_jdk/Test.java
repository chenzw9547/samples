package cn.chenzw.design_pattem.observer_jdk;

/**
 * JDK自带的观察者模式实现
 * Subject主题继承于java.util.Observable类
 * Observer观察者实现了java.util.Observer接口
 * @author chenzw
 * @date 2017年1月13日
 */
public class Test {

	public static void main(String[] args) {
		ConcreteSubject subjectA = new ConcreteSubject();
		subjectA.addObserver(new ConcreteObserverX());
		subjectA.addObserver(new ConcreteObserverY());
		subjectA.addObserver(new ConcreteObserverZ());

		subjectA.change("紧急通知!");
	}
}
