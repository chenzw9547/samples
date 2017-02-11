package cn.chenzw.simple_thread.synchronizeds;

public class StaticSynchronized {

	public synchronized void printA(String name) {
		try {
			System.out.println(name + ":access A!");
			Thread.sleep(1000);
			System.out.println(name + ":out A!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void printB(String name) {
		try {
			System.out.println(name + ":access B!");
			Thread.sleep(1000);
			System.out.println(name + ":out B!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void staticPrintA(String name) {
		try {
			System.out.println(name + ":access A!");
			Thread.sleep(1000);
			System.out.println(name + ":out A!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void staticPrintB(String name) {
		try {
			System.out.println(name + ":access B!");
			Thread.sleep(1000);
			System.out.println(name + ":out B!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试同一个实例是否能同时访问不同的同步方法<br>
	 * 结果: a1和a2不能同时访问同一实例对象的synchronized方法
	 */
	public static void testSameInstance() {
		final StaticSynchronized ss1 = new StaticSynchronized();
		// final StaticSynchronized ss2 = new StaticSynchronized();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// 调用的是printA方法
				ss1.printA("a1");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// 调用的是printB方法，与printA方法一样，是一个同步方法
				ss1.printB("a2");
			}
		});

		t1.start();
		t2.start();

		// 输出结果:
		// a1:access A!
		// a1:out A!
		// a2:access B!
		// a2:out B!
	}

	/**
	 * 测试不同实例对象是否能同时访问同一同步方法<br>
	 * 结果: 每个实例对象都各自持有一把锁，两者互不关联，所以可以同时访问到
	 */
	public static void testDiffInstance() {
		final StaticSynchronized ss1 = new StaticSynchronized();
		final StaticSynchronized ss2 = new StaticSynchronized();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// 调用的是printA方法
				ss1.printA("b1");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// 调用的也是printA方法，但不是同一个对象
				ss2.printA("b2");
			}
		});

		t1.start();
		t2.start();

		// 输出结果:
		// b1:access A!
		// b2:access A!
		// b1:out A!
		// b2:out A!
	}

	/**
	 * 测试不同实例对象是否能同时访问静态的同步方法 结论: 静态同步方法是在类上加锁，会导致此类的所有实例对象的静态同步方法不能同时被访问到
	 */
	public static void testStaticSync() {
		final StaticSynchronized ss1 = new StaticSynchronized();
		final StaticSynchronized ss2 = new StaticSynchronized();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// 调用的是staticPrintA静态方法
				ss1.staticPrintA("c1");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// 调用的是staticPrintB静态方法，
				ss2.staticPrintB("c2");
			}
		});

		t1.start();
		t2.start();

		// 输出:
		// c1:access A!
		// c1:out A!
		// c2:access B!
		// c2:out B!
	}

	/**
	 * 测试同一实例对象是否能同时访问到静态同步方法和普通同步方法
	 * 结果: 两者互不相关
	 */
	public static void testStaticAndNormalSync() {
		final StaticSynchronized ss1 = new StaticSynchronized();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// 调用的是staticPrintA静态方法
				ss1.staticPrintA("e1");

			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// 调用的是printA同步方法
				ss1.printA("e1");
			}
		});

		t1.start();
		t2.start();

		// 输出:
		// e1:access A!
		// e1:access A!
		// e1:out A!
		// e1:out A!

	}

	public static void main(String[] args) {
		// testSameInstance();
		// testDiffInstance();
		// testStaticSync();
		testStaticAndNormalSync();
	}
}
