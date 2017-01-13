package cn.chenzw.design_pattem.observer;

import cn.chenzw.design_pattem.observer.concrete.ConcreteObserverA;
import cn.chenzw.design_pattem.observer.concrete.ConcreteObserverB;
import cn.chenzw.design_pattem.observer.concrete.ConcreteObserverC;
import cn.chenzw.design_pattem.observer.concrete.ConcreteSubject;

public class Test {

	public static void main(String[] args) {
		ISubject subjectA = new ConcreteSubject();
		
		subjectA.attach(new ConcreteObserverA());
		subjectA.attach(new ConcreteObserverB());
		subjectA.attach(new ConcreteObserverC());
		
		subjectA.notifyObservers();
		subjectA.notifyObservers("紧急通知!");
	}
}
