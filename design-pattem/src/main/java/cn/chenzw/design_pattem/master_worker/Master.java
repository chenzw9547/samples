package cn.chenzw.design_pattem.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	// 任务队列
	private ConcurrentLinkedQueue<Task> workerQueue = new ConcurrentLinkedQueue<Task>();

	private HashMap<String, Thread> workers = new HashMap<String, Thread>();

	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	Master(Worker worker, int workCount) {
		worker.setWorkerQueue(this.workerQueue);
		worker.setResultMap(this.resultMap);

		for (int i = 0; i < workCount; i++) {
			workers.put("worker" + i, new Thread(worker));
		}
	}

	public void sumbit(Task task) {
		workerQueue.add(task);
	}

	public void execute() {
		for (Map.Entry<String, Thread> me : workers.entrySet()) {
			me.getValue().start();
		}
	}

	public boolean isComplete() {
		for (Map.Entry<String, Thread> me : workers.entrySet()) {
			if (me.getValue().getState() == Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}

	// 返回结果
	public Object getResult() {
		double ret = 0d;
		for (Map.Entry<String, Object> me : resultMap.entrySet()) {
			ret += (double) me.getValue();
		}
		return ret;
	}

}
