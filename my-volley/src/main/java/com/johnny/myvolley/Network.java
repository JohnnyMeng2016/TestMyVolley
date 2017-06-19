package com.johnny.myvolley;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 项目名称：MyVolley
 * 类描述：请求处理类
 * 创建人：孟忠明
 * 创建时间：2017/5/23
 */
public class Network {

    /**
     * 执行网络请求
     */
    public Response performNetwork(Request request) {
        try {
            URL url = new URL(request.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            switch (request.getMethod()) {
                case Request.Method.GET:
                    conn.setRequestMethod("GET");
                    break;
                case Request.Method.POST:
                    conn.setRequestMethod("POST");
                    break;
            }
            int response_code = conn.getResponseCode();
            String response_content = null;
            if (response_code == 200) {
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                is.close();
                byte[] data = outStream.toByteArray();
                response_content = new String(data, "UTF-8");
            }
            Response response = new Response();
            response.setResultCode(response_code);
            response.setResultContent(response_content);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
