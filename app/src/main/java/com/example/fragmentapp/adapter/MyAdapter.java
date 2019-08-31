package com.example.fragmentapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fragmentapp.MainActivity;
import com.example.fragmentapp.R;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    String[] lists = {};


    public MyAdapter(Activity mainActivity, String[] lists) {
        mContext = mainActivity;
        this.lists = lists;

    }

    // override other abstract methods here


    @Override
    public int getCount() {
        return lists.length;
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
    public View getView(int position, View convertView, ViewGroup container) {
        convertView = LayoutInflater.from(mContext).
                inflate(R.layout.layout_list_view_row_items, container, false);

//            ((TextView) convertView.findViewById(android.R.id.text1))
//                    .setText(getItem(position));

        TextView singleRow = convertView.findViewById(R.id.singleRow);
        singleRow.setText(lists[position]);
        return convertView;
    }
}