package com.johnny.myvolley;

/**
 * 项目名称：MyVolley
 * 类描述：核心类
 * 创建人：孟忠明
 * 创建时间：2017/5/22
 */
public class Volley {

    /**
     * 创建请求队列
     */
    public static RequestQueue newRequestQueue() {
        Network network = new Network();
        RequestQueue requestQueue = new RequestQueue(network);
        requestQueue.start();
        return requestQueue;
    }

}
