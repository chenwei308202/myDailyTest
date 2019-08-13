package com.cw.utils.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * httpclient 工具类
 * Created by chenwei on 2015/3/22.
 */
public class HttpClientDemo {


     /**
     * http  get
     */
    public void httpGetWithParam(){
        try {
            //不带参数的get请求可以直接传递String类型参数。注意url的正确性，以http开头
            // String url="www.baidu.com";
            URI url = new URIBuilder("http://www.baidu.com").setParameter("name","chenwei").build();
            HttpClient client= HttpClients.createDefault();

            HttpGet httpGet=new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){

                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * http  post
     */
    public void httpPostParam(){
            HttpClient client= HttpClients.createDefault();
        try {
            //注意url的正确性，以http开头
            HttpPost httpPost=new HttpPost("http://www.baidu.com");
            //设置heder
            httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            parameters.add(new BasicNameValuePair("name", "chenwei"));
            parameters.add(new BasicNameValuePair("job", "java"));
            //将参数编码成键值对，若不传字符编码，则默认为iso_8859_1
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
            httpPost.setEntity(formEntity);

            HttpResponse response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * http  post
     */
    public void httpPostParamWithJson(){
        HttpClient client= HttpClients.createDefault();
        try {
            //注意url的正确性，以http开头
            HttpPost httpPost=new HttpPost("http://www.baidu.com");
            //设置heder
            httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("name","chen");
            jsonObject.put("job","javer");
            //将参数编码成键值对，若不传字符编码，则默认为iso_8859_1
            StringEntity stringEntity = new StringEntity (jsonObject.toString());
            stringEntity.setContentEncoding("UTF-8");
            //发送json数据需要设置contentType
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            HttpResponse response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        HttpClientDemo demo=new HttpClientDemo();
        demo.httpPostParamWithJson();
    }


















































}
