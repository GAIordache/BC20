package semaphore1;

import java.util.concurrent.Semaphore;

public class SemaphoreExMain {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(2);
		for (int i = 0; i < 20; i++) {
			Runnable r = () -> {
				System.out.println("Waiting for permit:" + Thread.currentThread().getName());
				try {
					s.acquire();
					try {
						System.out.println("Got permit:" + Thread.currentThread().getName());
						Thread.sleep(1000);
					} finally {
						s.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
			new Thread(r).start();
		}
	}

}
