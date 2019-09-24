package ltd.pitupi.sample.tests;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {
	
	public static void main(String[] args) {
		//Future
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Double> future = executor.submit(new Callable<Double>() {
			@Override
	        public Double call() {
	        	 System.out.println("not main");
	             int sum = 0;
	             for(int i=0;i<100;i++)
	                 sum += i;
	             return (double) sum;
	        }});
		executor.shutdown();
		System.out.println("main");
	    try {
	    	while(!future.isDone()){
	    		System.out.println("------");
	    	}
	        Double result = future.get(1, TimeUnit.SECONDS);
	        System.out.println(result);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
