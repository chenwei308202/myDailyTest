/*
 * 文 件 名:  DefaultRongClient.java
 * 修 改 人:  chenchong@rong360.com
 * 修改时间:  2016年2月25日
 * 修改内容:  <修改内容>
 */
package com.rong360.crawler.client.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rong360.crawler.client.RongClient;
import com.rong360.crawler.utils.Base64Utils;
import com.rong360.crawler.utils.CommonUtil;
import com.rong360.crawler.utils.HttpTools;
import com.rong360.crawler.utils.RSAUtils;

/**
 * 
 * @author  chenchong@rong360.com
 * @date  [2016年3月29日]
 */
public class DefaultRongClient implements RongClient {
    private String serverUrl;
    private String appId;
    private String version = "1.0";
    private String privateKey;
    private String format = "json";
    private String signType = "RSA";
    private String publicKey;
    private String charset;
    private int connectTimeout = 3000;
    private int readTimeout    = 15000;
    
    public DefaultRongClient(String serverUrl, String appId, String privateKey, String format,
        String charset) {
        this.serverUrl = serverUrl;
        this.appId = appId;
        this.privateKey = privateKey;
        this.publicKey = null;
        this.format = format;
        this.charset = charset;
    }
    
    /**
     * 重载方法
     * @throws Exception 
     */
    @Override
    public String execute(Map<String,String> params) throws Exception {
        if(params==null){
            params = new HashMap<String,String>();
        }
        params.put("app_id", this.appId);
        params.put("version", this.version);
        params.put("sign_type", this.signType);
        params.put("format", this.format);
        params.put("timestamp", String.valueOf(new Date().getTime()/1000));
        //sign处理 RSA加密
        String paramsStr = CommonUtil.getSortParams(params);
        //System.out.println("待签名数据："+paramsStr);
        byte[] bytes = RSAUtils.generateSHA1withRSASigature(paramsStr, this.privateKey);
        String sign = Base64Utils.encode(bytes);
        System.out.println("签名后数据："+sign);
        params.put("sign", sign);
        String result = HttpTools.post(this.serverUrl, params, this.connectTimeout, this.readTimeout);
        return result;
    }
    
}
