package com.cw.thread.test.sych;

import java.util.List;
import java.util.Random;

public class ThreadWorkerAdd extends Thread{
	
	private List<Integer> list;
	
	
	
	public  ThreadWorkerAdd(String theadName,List<Integer> list ) {
		this.setName(theadName);
		this.list=list;
	}
	
	@Override
	public void run() {
		while (true) {
			
		
			synchronized (list) {
				
				
					while (list.size()>=50) {
						try {
							System.out.println(this.getName()+"开始等待");
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
			
					
					while (true) {
						
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Integer eleInteger=	new Random().nextInt(100);
						list.add(new Random().nextInt(100));
						System.out.println(this.getName() +"执行后 ，list 容量为"+list.size()+",  元素 element ="+eleInteger);
						if (list.size()>=50) {
							break;
						}
						
					}
						
					list.notify();
					System.out.println(this.getName() +"唤醒他们等待线程…………………………………………=");
			}
		}
	}

}
