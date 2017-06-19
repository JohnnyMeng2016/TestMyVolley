package com.johnny.myvolley;

import android.support.annotation.NonNull;

/**
 * 项目名称：MyVolley
 * 类描述：请求类
 * 创建人：孟忠明
 * 创建时间：2017/5/23
 */
public abstract class Request implements Comparable<Request> {


    @Override
    public int compareTo(@NonNull Request request) {
        return 0;
    }

    public interface Method {
        int GET = 0;
        int POST = 1;
        int PUT = 2;
        int DELETE = 3;
        int HEAD = 4;
        int OPTIONS = 5;
        int TRACE = 6;
        int PATCH = 7;
    }

    private final int mMethod;
    private final String mUrl;

    public Request(int mMethod, String mUrl) {
        this.mMethod = mMethod;
        this.mUrl = mUrl;
    }

    public int getMethod() {
        return mMethod;
    }

    public String getUrl() {
        return mUrl;
    }

    protected abstract void deliveryResopnse(String response);
}
