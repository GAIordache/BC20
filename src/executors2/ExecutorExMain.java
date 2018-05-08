package executors2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExMain {
	static Callable<String> createFirstTask() {
		return () -> {
			Thread.sleep(1000);
			return "Rezultat 1";
		};
	}
	
	static Callable<String> createSecondTask() {
		return () -> {
			Thread.sleep(4000);
			return "Rezultat 2";
		};
	}
	
	static Callable<String> createThirdTask() {
		return () -> {
			Thread.sleep(6000);
			return "Rezultat 3";
		};
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService execService = Executors.newFixedThreadPool(3);
		Future<String> future1 = execService.submit(createFirstTask());
		Future<String> future2 = execService.submit(createSecondTask());
		Future<String> future3 = execService.submit(createThirdTask());
		while(true) {
			System.out.println("Bla bla");
			if(future1.isDone() && future2.isDone() && future3.isDone()) {
				break;
			}
		}
		System.out.println("Rezultat task 1:" + future1.get());
		System.out.println("Rezultat task 2:" + future2.get());
		System.out.println("Rezultat task 3:" + future3.get());
		execService.shutdown();
	}

}
