package com.johnny.testmyvolley;

import com.johnny.myvolley.Request;

/**
 * 项目名称：TestMyVolley
 * 类描述：
 * 创建人：孟忠明
 * 创建时间：2017/5/26
 */
public class StringRequest extends Request {
    private RequestListener mListener;

    public StringRequest(int mMethod, String mUrl) {
        super(mMethod, mUrl);
    }

    public StringRequest(int mMethod, String mUrl, RequestListener requestListener) {
        super(mMethod, mUrl);
        this.mListener = requestListener;
    }

    @Override
    protected void deliveryResopnse(String response) {
        mListener.onResponse(response);
    }
}
