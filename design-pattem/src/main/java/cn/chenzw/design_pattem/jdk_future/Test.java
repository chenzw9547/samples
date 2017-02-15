package cn.chenzw.design_pattem.jdk_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 本示例使用jdk自带的Future模式实现 <br>
 * Future接口提供的线程控制功能有(可以取消Future任务及设定Future任务的超时时间): <br>
 * boolean cancle(boolean mayInterruptIfRunning); //取消任务 <br>
 * boolean isCancle(); //是否已经取消 <br>
 * boolean isDone(); //是否已完成 <br>
 * V get(); //取得返回对象 <br>
 * V get(long timeout, TimeUnit unit); //取得返回对象，可以设置超时时间 <br>
 * 
 * @author chenzw
 * @date 2017年2月11日
 */
public class Test {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		FutureTask<String> ft = new FutureTask<String>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(ft);
		System.out.println("请求完毕!");

		// 这里可以执行额外的数据操作
		Thread.sleep(2000);

		// 阻塞直到call()方法执行完成
		System.out.println("获取到的数据:" + ft.get());

		executor.shutdown();
	}
}
