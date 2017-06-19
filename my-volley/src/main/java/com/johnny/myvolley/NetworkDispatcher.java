package com.johnny.myvolley;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.BlockingQueue;

/**
 * 项目名称：MyVolley
 * 类描述：HTTP请求执行者
 * 创建人：孟忠明
 * 创建时间：2017/5/23
 */
public class NetworkDispatcher extends Thread {

    private BlockingQueue<Request> mQueue;
    private Network mNetwork;
    private ResponseDelivery mDelivery;
    private boolean isQuit;

    public NetworkDispatcher(BlockingQueue<Request> mQueue, Network mNetwork) {
        this.mQueue = mQueue;
        this.mNetwork = mNetwork;
        mDelivery = new ResponseDelivery(new Handler(Looper.getMainLooper()));
    }

    @Override
    public void run() {
        while (!isQuit) {
            Request request;
            try {
                request = mQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                continue;
            }
            Response response = mNetwork.performNetwork(request);
            mDelivery.deliveryResponse(request, response);
        }
    }

    public void setQuit(boolean quit) {
        this.isQuit = quit;
    }
}
