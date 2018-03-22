package com.cw.demo.fenbiao.datasource;

public class HashUtils {

	
	public static int getHashCode(String id,int mod){
		if (id==null) {
			return 0;
		}
		return (id.hashCode() & 0x7fffffff) % mod;
	}
}
