package com.cw.demo.sharetable.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	
	
	//实现动态 获取 数据源key值得方法
	@Override
	protected Object determineCurrentLookupKey() {
		
		return DataSourceThreadLocal.getSignal();
	}

}
