package com.bwie.chenshaoshuai;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final  FlowLayoutText flow_one = findViewById(R.id.flow_one);
        FlowLayoutText flow_two = findViewById(R.id.flow_two);

        final UserDao dao = new UserDao(this);
        final TitleChildView title_child = findViewById(R.id.title_child);
        title_child.setButtonListener(new TitleChildView.OnButtonListener() {
            private String uuid1;
            @Override
            public void OnButtonClick(final String str) {
                UUID uuid = UUID.randomUUID();
                TextView textView = new TextView(MainActivity.this);
                textView.setTag(uuid);
                textView.setText(str);
                uuid1 = String.valueOf(textView.getTag());
                dao.add(uuid1,str);
                textView.setBackgroundResource(R.drawable.edit_bg);
                flow_one.addView(textView);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
     String[] arr = new String[]{"考拉三周年人气热销榜","电动牙刷","尤妮佳","豆豆鞋","沐浴露","日东红茶"};
     for(int i = 0; i<arr.length;i++){
          TextView textView = new TextView(MainActivity.this);
          textView.setText(arr[i]);
         textView.setBackgroundResource(R.drawable.edit_bg);
         flow_two.addView(textView);
     }
        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delAll();
               flow_one.removeAllViews();
            }
        });
    }
}
