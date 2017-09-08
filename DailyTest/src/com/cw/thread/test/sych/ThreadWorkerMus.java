package com.cw.thread.test.sych;

import java.util.List;
import java.util.Random;

public class ThreadWorkerMus extends Thread{
	
	private List<Integer> list;
	
	
	
	public  ThreadWorkerMus(String theadName,List<Integer> list ) {
		this.setName(theadName);
		this.list=list;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
		
			synchronized (list) {
				
				
					while (list.size()<=0) {
						try {
							System.out.println(this.getName()+"开始等待");
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				
					}
					
					while (true) {
						list.remove(list.size()-1);
						
						System.out.println(this.getName() +"执行后 ，list 容量为"+list.size());
						if (list.size()<=0) {
							break;
						}
					}
					list.notify();
					System.out.println(this.getName() +"唤醒他们等待线程…………………………………………=");
			}
			
		}
	}
}
