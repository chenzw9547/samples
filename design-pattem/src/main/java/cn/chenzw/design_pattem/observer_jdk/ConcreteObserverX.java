package cn.chenzw.design_pattem.observer_jdk;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserverX implements Observer {

	public void update(Observable o, Object arg) {
		System.out.println("update ConcreteObserverX:[" + o + "]" + arg);
	}

}
