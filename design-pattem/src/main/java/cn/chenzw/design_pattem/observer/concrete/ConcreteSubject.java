package cn.chenzw.design_pattem.observer.concrete;

import java.util.concurrent.CopyOnWriteArrayList;

import cn.chenzw.design_pattem.observer.IObserver;
import cn.chenzw.design_pattem.observer.ISubject;

public class ConcreteSubject implements ISubject {

	private CopyOnWriteArrayList<IObserver> observers = new CopyOnWriteArrayList<IObserver>();

	public void attach(IObserver observer) {
		this.observers.add(observer);
	}

	public void detach(IObserver observer) {
		this.observers.remove(observer);

	}

	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}

	public void notifyObservers(String msg) {
		for (IObserver observer : observers) {
			observer.update(msg);
		}
	}

}
