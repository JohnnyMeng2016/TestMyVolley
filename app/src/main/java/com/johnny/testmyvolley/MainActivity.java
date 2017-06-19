package com.johnny.testmyvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.johnny.myvolley.Request;
import com.johnny.myvolley.RequestQueue;
import com.johnny.myvolley.Volley;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request request = new StringRequest(Request.Method.GET, "https://www.baidu.com/", new RequestListener() {
                    @Override
                    public void onResponse(String responseContent) {
                        Toast.makeText(MainActivity.this, responseContent, Toast.LENGTH_SHORT).show();
                    }
                });
                mRequestQueue.add(request);
                System.out.println("办公室搬家");
            }
        });
        mRequestQueue = Volley.newRequestQueue();
    }
}
