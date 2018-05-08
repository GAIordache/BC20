package lock2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExMain {
	static ReadWriteLock lock = new ReentrantReadWriteLock();
	
	static String buffer = "Nimic";

	public static void main(String[] args) {
		Thread writerThread = new Thread(() -> {
			lock.writeLock().lock();
			try {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				buffer = "Ceva:" + System.currentTimeMillis();
			} finally {
				lock.writeLock().unlock();
			}
		});
		writerThread.start();
		Thread readerThread1 = new Thread(() -> {
			lock.readLock().lock();
			try {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				System.out.println(buffer + " thread:" + Thread.currentThread().getName());
			} finally {
				lock.readLock().unlock();
			}
		});
		readerThread1.start();
		Thread readerThread2 = new Thread(() -> {
			lock.readLock().lock();
			try {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				}
				System.out.println(buffer + " thread:" + Thread.currentThread().getName());
			} finally {
				lock.readLock().unlock();
			}
		});
		readerThread2.start();
	}

}
