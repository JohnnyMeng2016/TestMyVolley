package com.johnny.myvolley;

/**
 * 项目名称：MyVolley
 * 类描述: 网络响应
 * 创建人：孟忠明
 * 创建时间：2017/5/23
 */
public class Response {

    private int resultCode;
    private String resultContent;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }
}
