package cn.chenzw.design_pattem.master_worker;

public class Test {

	public class MyWorker extends Worker {

		@Override
		public Object handle(Task task) {
			try {
				// 假设每个处理耗时0.5s
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return task.getPrice() * 10;
		}

	}

	public static void main(String[] args) {
		Master master = new Master(new Test().new MyWorker(), 5);
		for (int i = 0; i < 100; i++) {
			Task task = new Task();
			task.setId(i);
			task.setName("task_" + i);
			task.setPrice(i);
			master.sumbit(task);
		}
		master.execute();

		while (true) {
			if (master.isComplete()) {
				System.out.println("最终结果:" + master.getResult());
				break;
			}
		}

	}
}
