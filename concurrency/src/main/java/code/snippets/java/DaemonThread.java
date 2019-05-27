package code.snippets.java;

/**
 * Created by ilumer
 * Date : 2019-05-21
 * Time : 19:28
 */
public class DaemonThread {

	public static void main(String[] args) {
		//守护线程
		Thread daemonThread = new WorkerThread("daemon");
		daemonThread.setDaemon(true);
		//普通的子线程
		Thread commonThread = new WorkerThread("common");
		daemonThread.start();
		commonThread.start();
		try {
			//主线程等待
			Thread.sleep(50000);
		} catch (InterruptedException e) {

		}
		//等待好主线程退出
		System.out.println("wait exit");
	}

	static class WorkerThread extends Thread {
		private String identify;

		public WorkerThread(String identify) {
			this.identify = identify;
		}

		public void run() {
			int count = 0;
			while (true) {
				System.out.println("Hello from " + identify + " thread" + count++);
				try {
					sleep(5000);
				} catch (InterruptedException e) {

				}
			}
		}
	}
}
