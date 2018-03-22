package com.cw.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwei01 on 2018/3/22.
 */
public class HttpClientDemo {

    /**
     * http  get请求
     */
    public void httpGet(){
        HttpClient client= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet("www.baidu.com");
        try {
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){

                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


     /**
     * http  get请求 带参数
     */
    public void httpGetWithParam(){
        try {
            URI url = new URIBuilder("www.baidu.com").setParameter("name","chenwei").build();
            HttpClient client= HttpClients.createDefault();

            HttpGet httpGet=new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){

                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  /**
     * http  post请求
     */
    public void httpPost(){
            HttpClient client= HttpClients.createDefault();
        try {

            HttpPost httpPost=new HttpPost("www.baidu.com");
            httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
            HttpResponse response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode()==200){

                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/**
     * http  post请求 带参数
     */
    public void httpPostParam(){
            HttpClient client= HttpClients.createDefault();
        try {

            HttpPost httpPost=new HttpPost("www.baidu.com");
            httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("scope", "project"));
            parameters.add(new BasicNameValuePair("q", "java"));
            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);

            HttpResponse response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode()==200){

                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



















































}
