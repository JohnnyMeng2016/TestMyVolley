package com.johnny.myvolley;

import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * 项目名称：TestMyVolley
 * 类描述：响应处理类，派发给主线程。
 * 创建人：孟忠明
 * 创建时间：2017/5/25
 */
public class ResponseDelivery {
    private Executor deliveryPoster;

    public ResponseDelivery(final Handler handler) {
        deliveryPoster = new Executor() {
            @Override
            public void execute(@NonNull Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void deliveryResponse(Request request, Response response) {
        deliveryPoster.execute(new ResponseDeliveryRunnable(request, response));
    }

    class ResponseDeliveryRunnable implements Runnable {
        private Request mRequest;
        private Response mResponse;

        public ResponseDeliveryRunnable(Request request, Response response) {
            this.mRequest = request;
            this.mResponse = response;
        }

        @Override
        public void run() {
            mRequest.deliveryResopnse(mResponse.getResultContent());
        }
    }

}
