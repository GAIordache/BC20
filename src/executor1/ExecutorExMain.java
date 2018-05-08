package executor1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorExMain {
	static AtomicInteger execCount = new AtomicInteger(0);
	
	static Runnable generateTask() {
		return () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double rnd = Math.random();
			if(rnd < 0.15) {
				System.out.println("########################################");
				throw new RuntimeException();
			}
			int cnt = execCount.incrementAndGet();
			
			System.out.println("Thread:" + Thread.currentThread().getName() + " Valoare:" + rnd + " " + cnt);
		};
	}

	public static void main(String[] args) {
		ExecutorService execService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			execService.submit(generateTask());
		}
		System.out.println("Am trimis TOATE task-urile");
		execService.shutdown();
		System.out.println("Am chemat SHUTDOWN");

	}
	
	static ExecutorExMain __instance = null;
	static Object __lockObj = new Object();
	
	static ExecutorExMain getInstance() {
		if(__instance == null) {
			synchronized (__lockObj) {
				if(__instance == null) {
					__instance = new ExecutorExMain();
				}
			}
		}
		return __instance;
	}

}
