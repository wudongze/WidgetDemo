package com.example.wudz.widgetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyTextLayout myTextLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextLayout = (MyTextLayout) findViewById(R.id.my_text);
        myTextLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了控件",Toast.LENGTH_SHORT).show();
                myTextLayout.setLeftText("商品价格2");
                myTextLayout.setRightText("40元");
                myTextLayout.isShowLine(true);
            }
        });
    }
}
