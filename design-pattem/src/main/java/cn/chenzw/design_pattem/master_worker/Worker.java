package cn.chenzw.design_pattem.master_worker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

	private ConcurrentLinkedQueue<Task> workerQueue = new ConcurrentLinkedQueue<Task>();
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue) {
		this.workerQueue = workerQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public void run() {
		while (true) {
			Task task = workerQueue.poll();
			if (task != null) {
				Object ret = handle(task);
				this.resultMap.put(String.valueOf(task.getId()), ret);
			}
		}
	}

	public Object handle(Task task) {
		return null;
	}

}
