package com.example.thinkpad.kh4b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button selectall;
    private Button deselectall;
    private Button cancel;
    private ListView listView;
    private List<item> list;
    private TextView selected_text;
    private int num = 0;
    private BaseAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectall = (Button) findViewById(R.id.bt_selectall);
        deselectall = (Button) findViewById(R.id.bt_deselectall);
        cancel = (Button) findViewById(R.id.bt_cancel);
        listView = (ListView) findViewById(R.id.my_demo_listview);
        selected_text = (TextView) findViewById(R.id.selected_text);

        list = new ArrayList<item>();
        //给每一个条目赋值
        for (int i = 1; i <= 60; i++) {
            list.add(new item(i + "", i % 9 + "", i + "", false));
        }

        //绑定适配器
        adapter = new myAdapter(list, MainActivity.this);
        listView.setAdapter(adapter);

        //全选Button
        selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 0;
                for (int i = 0; i < list.size(); i++) {
                    //将所有的boolean改为true
                    list.get(i).setaBoolean(true);
                    //如果被选中
                    if (list.get(i).getaBoolean()) {
                        num++;
                    }
                }
                //刷新
                adapter.notifyDataSetChanged();
                //显示
                selected_text.setText("一共选了" + num + "项");
            }
        });

        //反选Button
        deselectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getaBoolean()) {
                        list.get(i).setaBoolean(false);
                    } else {
                        list.get(i).setaBoolean(true);
                    }
                    adapter.notifyDataSetChanged();
                    if (list.get(i).getaBoolean()) {
                        num++;
                    }
                }
                selected_text.setText("一共选了" + num + "项");
            }
        });

        //取消全部
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = 0;
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setaBoolean(false);
                    adapter.notifyDataSetChanged();
                    if (list.get(i).getaBoolean()) {
                        num++;
                    }
                }
                selected_text.setText("一共选了" + num + "项");
            }
        });

        //listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //取得ViewHolder对象
                myAdapter.ViewHolder viewHolder = (myAdapter.ViewHolder) view.getTag();
                //改变CheckBox的状态
                viewHolder.checkBox.toggle();
                //将CheckBox的选中状态记录
                list.get(i).setaBoolean(viewHolder.checkBox.isChecked());
                //调整选定条目
                if (viewHolder.checkBox.isChecked()) {
                    num++;
                } else {
                    num--;
                }
                selected_text.setText("一共选了" + num + "项");
            }
        });

    }
}



