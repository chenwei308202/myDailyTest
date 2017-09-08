package com.cw.batch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 跑批任务
 * @author Magi
 *
 */


public class CommonService {

	
	public static void main(String[] args) {
		
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		while (true) {
			
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		
		}
	}
}
