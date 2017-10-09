package com.example.gambm.gitsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private ArrayList<Login> list;

    BoxAdapter(Context context, ArrayList<Login> reposInfo) {
        list = reposInfo;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }
        Login u = getUserInfo(position);
        ((TextView) view.findViewById(R.id.tvReposname)).setText(u.getFull_name());
        ((TextView) view.findViewById(R.id.tvLogin)).setText(u.getName());
        ((TextView) view.findViewById(R.id.tvId)).setText(String.valueOf(u.getId()));
        return view;
    }

    private Login getUserInfo(int position) {
        return ((Login) getItem(position));
    }

}
