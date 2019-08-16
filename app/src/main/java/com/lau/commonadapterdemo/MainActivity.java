package com.lau.commonadapterdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lau.CommonAdapter;
import com.lau.CommonHolder;
import com.lau.LineItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new LineItemDecoration(MainActivity.this));
        final List<String> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add("这是第" + i + "条标题");
        }
        CommonAdapter<String> adapter = new CommonAdapter<String>(MainActivity.this, list, R.layout.item_test) {
            @Override
            protected void convert(Context context, CommonHolder holder, String s, int position) {
                holder.setText(R.id.title, s);
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CommonAdapter.setOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String s = list.get(position);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
