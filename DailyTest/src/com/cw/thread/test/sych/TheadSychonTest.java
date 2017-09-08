package com.cw.thread.test.sych;

import java.util.ArrayList;
import java.util.List;


/**
 * 线程同步demo
 * @author chenwei
 *
 */
public class TheadSychonTest {

	
	public static void main(String[] args) {
		List<Integer> num=new ArrayList<Integer>() ;
		
		ThreadWorkerAdd add=new ThreadWorkerAdd("加线程", num);
		add.start();
		ThreadWorkerMus mus=new ThreadWorkerMus("减线程", num);
		mus.start();
		
	}
}
