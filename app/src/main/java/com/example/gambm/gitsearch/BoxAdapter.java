package com.example.gambm.gitsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BoxAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private List<ReposInfo> list;
    private Context ctx;

    BoxAdapter(Context context, List<ReposInfo> reposInfo) {
        ctx = context;
        list = reposInfo;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ReposInfo u = getUserInfo(position);
        ((TextView) view.findViewById(R.id.tvReposname)).setText(u.getLogin());
        return view;
    }

    private ReposInfo getUserInfo(int position) {
        return ((ReposInfo) getItem(position));
    }

}
