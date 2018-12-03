package com.example.waterfall;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         init();
    }

    private void init() {
        final  WeekFlowLayout fl_search = findViewById(R.id.fl_search);
        WeekFlowLayout fl_hot = findViewById(R.id.fl_hot);

        TitleBarView title = findViewById(R.id.title);
        title.setButtonClickListener(new TitleBarView.OnBuutonClickListener() {
            @Override
            public void onBuutonClick(String str) {
                UUID uuid = UUID.randomUUID();
                TextView tv = new TextView(MainActivity.this);
                tv.setTag(uuid);
                tv.setTextColor(Color.RED);
                tv.setText(str);
                tv.setBackgroundResource(R.drawable.edit_bg);
                fl_search.addView(tv);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String uuid =String.valueOf(v.getTag());

                    }
                });
            }
        });
        for(int i = 0;i<20;i++){
            TextView tv = new TextView(MainActivity.this);
            tv.setText("数据"+i);
            tv.setTextColor(Color.RED);
            tv.setBackgroundResource(R.drawable.edit_bg);
            fl_hot.addView(tv);
        }
    }
}
