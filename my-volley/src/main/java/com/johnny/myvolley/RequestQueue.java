package com.johnny.myvolley;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 项目名称：MyVolley
 * 类描述：请求队列处理类（最核心的类）
 * 创建人：孟忠明
 * 创建时间：2017/5/23
 */
public class RequestQueue {

    private final int DISPATCHER_POOL_SIZE = 4;

    private BlockingQueue<Request> mQueue;
    private Network mNetwork;
    private NetworkDispatcher[] mDispatchers;

    public RequestQueue(Network network) {
        mNetwork = network;
        mQueue = new PriorityBlockingQueue<>();
        mDispatchers = new NetworkDispatcher[DISPATCHER_POOL_SIZE];
    }

    public void start() {
        for (int i = 0; i < mDispatchers.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(mQueue, mNetwork);
            mDispatchers[i] = networkDispatcher;
            mDispatchers[i].start();
        }
    }

    public void add(Request request) {
        mQueue.add(request);
    }
}
