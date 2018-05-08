package countdownlatch1;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public static void main(String[] pArgs) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			Runnable r = () -> {
				System.out.println("Thread :" + Thread.currentThread().getName() + " started");
				try {
					Thread.sleep((long) (Math.random() * 3000) + 1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cdl.countDown();
				///
				/// PROCESSING
				System.out.println("Thread :" + Thread.currentThread().getName() + " acu continuam trebile");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread :" + Thread.currentThread().getName() + " acu am terminat trebile");

			};
			new Thread(r).start();
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " waiting for start");
		cdl.await();
		System.out.println("Thread " + Thread.currentThread().getName() + " STARTED");

	}
}
