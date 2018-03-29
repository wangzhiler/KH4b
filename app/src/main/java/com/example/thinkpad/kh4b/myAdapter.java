package com.example.thinkpad.kh4b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

/**
 * Created by thinkpad on 2017/12/31.
 */

public class myAdapter extends BaseAdapter {
    private List<item> list;
    private Context context;

    public myAdapter(List<item> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(context,R.layout.listview,null);
            viewHolder=new ViewHolder();
            viewHolder.tv_title=(TextView)convertView.findViewById(R.id.tv_title);
            viewHolder.tv_date=(TextView)convertView.findViewById(R.id.tv_date);
            viewHolder.tv_FileSize=(TextView)convertView.findViewById(R.id.tv_size);
            viewHolder.checkBox=(CheckBox)convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.tv_title.setText("标题"+list.get(position).getTitle());
        viewHolder.tv_date.setText(4671+""+list.get(position).getDate());
        viewHolder.tv_FileSize.setText("2016/03/0"+list.get(position).getFile_size());
        //显示checkBox
        viewHolder.checkBox.setChecked(list.get(position).getaBoolean());

        return convertView;
    }

    class ViewHolder{
        TextView tv_title;
        TextView tv_date;
        TextView tv_FileSize;
        CheckBox checkBox;
    }
}


