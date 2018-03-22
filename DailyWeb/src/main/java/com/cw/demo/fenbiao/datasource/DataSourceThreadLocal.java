package com.cw.demo.fenbiao.datasource;

public class DataSourceThreadLocal {

	
	public static ThreadLocal<String> datasourceSigal=new ThreadLocal<String>();
	
	private static final String prefix="dataSource";
	
	public static void setSignal(int value){
		datasourceSigal.set(prefix+(value%2));
	}
	
	public static String getSignal(){
		return datasourceSigal.get();
	}
}
