package lock1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExMain {
	static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new Thread(() -> {
			lock.lock();

			try {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				System.out.println("Primul thread");
			} finally {
				lock.unlock();
			}

		}).start();
		new Thread(() -> {
			if (lock.tryLock()) {

				try {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
					}
					System.out.println("Al doilea thread");
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println("Asta e, nu am lock");
			}
		}).start();
	}

}
