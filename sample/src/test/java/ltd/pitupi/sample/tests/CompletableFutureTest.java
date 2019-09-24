package ltd.pitupi.sample.tests;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {
	
	public static void main(String[] args) {
	    //CompletableFuture
	    // 创建CompletableFuture对象，他会包含计算结果
	    String str = "my favorite product";
        CompletableFuture<Double> futurePrice = new CompletableFuture<Double>();
        // 在另一个线程中异步执行
        new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				double price = new Random().nextDouble() * str.charAt(0) + str.charAt(1);
				// 需长时间计算的任务结果并得出结果时，设置Future的返回值
				futurePrice.complete(price);
			}
        }).start();
        try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        try {
            double price = futurePrice.get();
            System.out.println("price is :" + price);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
	}
}
