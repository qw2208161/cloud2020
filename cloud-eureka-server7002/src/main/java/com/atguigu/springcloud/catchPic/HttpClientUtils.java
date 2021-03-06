package com.atguigu.springcloud.catchPic;

/**
 * @author zhqin.zhou
 * @date 2021/9/6 15:27
 * @description HttpClientUtils
 */
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author code4crafter@gmail.com
 * Date: 17/3/27
 */
public abstract class HttpClientUtils {

    public static Map<String, List<String>> convertHeaders(Header[] headers) {
        Map<String, List<String>> results = new HashMap<String, List<String>>();
        for (Header header : headers) {
            List<String> list = results.get(header.getName());
            if (list == null) {
                list = new ArrayList<String>();
                results.put(header.getName(), list);
            }
            list.add(header.getValue());
        }
        return results;
    }

    /**
     * http???get??????
     * @param url
     */
    public static String get(String url) throws GeneralSecurityException {
        return get(url, "UTF-8");
    }

    public static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * http???get??????
     * @param url
     */
    public static String get(String url, String charset) throws GeneralSecurityException {
        HttpGet httpGet = new HttpGet(url);
        return executeRequest(httpGet, charset);
    }

    /**
     * http???get????????????????????????????????????
     * @param url
     */
    public static String ajaxGet(String url) throws GeneralSecurityException {
        return ajaxGet(url, "UTF-8");
    }

    /**
     * http???get????????????????????????????????????
     *
     * @param url
     */
    public static String ajaxGet(String url, String charset) throws GeneralSecurityException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
        return executeRequest(httpGet, charset);
    }

    /**
     * @param url
     * @return
     */
    public static String ajaxGet(CloseableHttpClient httpclient, String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
        return executeRequest(httpclient, httpGet, "UTF-8");
    }

    /**
     * http???post???????????????map????????????
     */
    public static String post(String url, Map<String, String> dataMap) throws GeneralSecurityException {
        return post(url, dataMap, "UTF-8");
    }

    /**
     * http???post???????????????map????????????
     */
    public static String post(String url, Map<String, String> dataMap, String charset) throws GeneralSecurityException {
        HttpPost httpPost = new HttpPost(url);
        try {
            if (dataMap != null) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, charset);
                formEntity.setContentEncoding(charset);
                httpPost.setEntity(formEntity);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return executeRequest(httpPost, charset);
    }

    /**
     * http???post?????????????????????????????????????????????map????????????
     */
    public static String ajaxPost(String url, Map<String, String> dataMap) throws GeneralSecurityException {
        return ajaxPost(url, dataMap, "UTF-8");
    }

    /**
     * http???post?????????????????????????????????????????????map????????????
     */
    public static String ajaxPost(String url, Map<String, String> dataMap, String charset) throws GeneralSecurityException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("X-Requested-With", "XMLHttpRequest");
        try {
            if (dataMap != null) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, charset);
                formEntity.setContentEncoding(charset);
                httpPost.setEntity(formEntity);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return executeRequest(httpPost, charset);
    }

    /**
     * http???post?????????????????????????????????????????????json????????????
     */
    public static String ajaxPostJson(String url, String jsonString) throws GeneralSecurityException {
        return ajaxPostJson(url, jsonString, "UTF-8");
    }

    /**
     * http???post?????????????????????????????????????????????json????????????
     */
    public static String ajaxPostJson(String url, String jsonString, String charset) throws GeneralSecurityException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("X-Requested-With", "XMLHttpRequest");

        StringEntity stringEntity = new StringEntity(jsonString, charset);// ????????????????????????
        stringEntity.setContentEncoding(charset);
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        return executeRequest(httpPost, charset);
    }

    /**
     * ????????????http???????????????HttpGet???HttpPost??????
     */
    public static String executeRequest(HttpUriRequest httpRequest) throws GeneralSecurityException {
        return executeRequest(httpRequest, "UTF-8");
    }

    /**
     * ????????????http???????????????HttpGet???HttpPost??????
     */
    public static String executeRequest(HttpUriRequest httpRequest, String charset) throws GeneralSecurityException {
        CloseableHttpClient httpclient;
        if ("https".equals(httpRequest.getURI().getScheme())) {
            httpclient = createSSLInsecureClient();
        } else {
            httpclient = HttpClients.createDefault();
        }
        String result = "";
        try {
            try {
                CloseableHttpResponse response = httpclient.execute(httpRequest);
                HttpEntity entity = null;
                try {
                    entity = response.getEntity();
                    result = EntityUtils.toString(entity, charset);
                } finally {
                    EntityUtils.consume(entity);
                    response.close();
                }
            } finally {
                httpclient.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String executeRequest(CloseableHttpClient httpclient, HttpUriRequest httpRequest, String charset) {
        String result = "";
        try {
            try {
                CloseableHttpResponse response = httpclient.execute(httpRequest);
                HttpEntity entity = null;
                try {
                    entity = response.getEntity();
                    result = EntityUtils.toString(entity, charset);
                } finally {
                    EntityUtils.consume(entity);
                    response.close();
                }
            } finally {
                httpclient.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * ?????? SSL??????
     */
    /*public static CloseableHttpClient createSSLInsecureClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //????????????
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();

            *//*SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });*//*
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (GeneralSecurityException ex) {
            throw new RuntimeException(ex);
        }
    }*/

    public static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
        try {
            javax.net.ssl.SSLContext sslContext = new org.apache.http.ssl.SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (GeneralSecurityException e) {
            throw e;
        }
    }
}