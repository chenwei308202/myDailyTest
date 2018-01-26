/*
 * 文 件 名:  ClientManager.java
 * 修 改 人:  chenchong@rong360.com
 * 修改时间:  2016年2月25日
 * 修改内容:  <修改内容>
 */
package com.rong360.crawler.client;

import com.rong360.crawler.client.impl.DefaultRongClient;

/**
 *
 * @author  chenchong@rong360.com
 * @date  [2016年3月29日]
 */
public class ClientManager {

	public static RongClient createClient() {
		/** 测试环境时，请在hosts文件中添加：  59.151.86.29 openapi.rong360.com **/
		/**联调时，请机构修改为测试环境地址**/
		String url = "https://openapi.rong360.com/gateway";
		
//		String url = "https://openapi-test.rong360.com/gateway";
		

		/** 融360开放平台分配的商户id 值与biz_data中merchant_id一样(注意修改CrawlerRequest中的merchantId的值) */
		/**请机构替换**/
		String appId = "3300121";
		/** 暂时只支持json返回格式 */
		String format = "json";
//
		/** 配置创建的RSA私钥   java的必须是pkcs8格式*/
		/**请机构替换**/
//		String privateKey =
//				"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANPKNNkvHFg9RWDg\n"
//						+ "lkZy96XiRiP2dZIRSDJRL2gMi4iFVhlwdvltKus3E4R3vhNNwQJpcuiJP0KYSaHy\n"
//						+ "d8C2RNcp/dr7XZrCP3MmhbC8FpSAPpDbWzDh34LYxn8Gwkk+GXq3csJ5+VszyNQy\n"
//						+ "LkjQ/V+5A6CBMjjMlOk0NU6wazO5AgMBAAECgYAqN7yhLorv7AbQcPSDxpcnMhvZ\n"
//						+ "P1/gZiGGJjjU/Oszo6CuIYUV43USvj/dwCDbqDw5RtvpDrLVi5Xh+nt0puDBxm/5\n"
//						+ "BcaEhZ/wZO0BsUO3td7irrabxvdOZXXhePf0CNHy7WYe9gQOOdVkJRsn18SYjgFJ\n"
//						+ "5J5DGETF9wtqrI9CgQJBAPGS8kwEQwN1BG6eAofetEr3mlr0+NfnmoKDtKTjWB0n\n"
//						+ "CB/lQQ2AnV0+db3+i3rVjViiTcXoqw1Ovk597N8V4G0CQQDgb++gdxVaDyKXWTTm\n"
//						+ "g0LwpBJL2258CLu4yIiQFs9AfyaSrCV6NT+upqBnWGbmm4Jf363aozrYrEHeAfgo\n"
//						+ "TQj9AkBC8ValjBTJ83Zr9Ot8nVFW6PBkPjhrFCoz+q1nd/yl73gH5q61QCvbeACG\n"
//						+ "yu/59Q27PxbQPh6QjH6eH7UxSM2tAkBAnlna1I50OIlYFBoUCFTcnhCagJol4gnS\n"
//						+ "YQJYogiX5EQB1MiRkAU+zsC+IIi3+qwl2Gvg2EBYI/hu6Bg/2jYtAkEA6YApkkdB\n"
//						+ "sZmeRprs9ZQAZShMBj06EuK6mFdoJpIatZOxPxw/R12MT4IbdD232ajpxOAViFVI\n"
//						+"GhocDo0Q3YRDYg==";
		
		
		String privateKey =
		"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMzZod8mjD+jT2QU7Mvceb8XYFitMPviHrNJjWU00XB7SpsskGo4PuPI+Ij7g/0tQvwKG8v9uAXWn6/Sg7Nv5BRB0hycmXVH4AoBVzBRUC/HCtynnfnblGWL0L7Y1951F0g0Mhp6n6nm8QNkvO2DTqoWSnuNnk8UNueS+BxH7ZEbAgMBAAECgYEAuOIPO4Th/amaRLyx/0hMxVAGz+H4HM23YZ8Xs2kZQgi0jBqLeKKs+A7xaUh/lqgcFbfV4KVsSjCrzRcVcISi9psSJyP+E6d2prZnTTNrjDz+1I3Xha5Ehy0ZQRZEBuJsXpsasnhJaryF5yo88hFr/ne/qVUEJdc14o8Y5c6lflkCQQD1q0hs+D1AJxPLO4eiK4j2LzuhBxHmHBmEVyJCCytVfxycibc7Tps0c5m8hnz1gN7J8UGICVtDcf4fDjxI61ilAkEA1XbrJmsxfPa8PKJ6v1Xjl6QJgITgov96O5dyzuCwuUYY5/n5K9CeNh2/LcWE+fYvGrAachsOyDSFOmeeSiNWvwJANNy0au5Hj8RY2ARpPRYNFJw5Qn8Y9ODbBMUTFA7/Nhhx+aUQjmxtrS2qyQxPWyxtxBprtW/9+VdQDTKs+ivaGQJBALJJhXNsGkRGC8gU6LJ/+PwBTNJjqP9ao+u7vW8eaVwFOO4fcUZwEoQeaju/eiYPwR3oMd5VzQ3YF+JFAwbm5x8CQDZpdGsc+8H+s9l+O5fmbGv8wdKFHVillQx0X+xFaLySlt5FXe2SD83r4iCOrc885wY608FkNPI/0CI23XchApA=";
		

		return new DefaultRongClient(url, appId, privateKey, format, "utf-8");
	}

}