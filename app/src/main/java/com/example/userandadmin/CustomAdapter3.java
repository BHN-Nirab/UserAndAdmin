package com.example.userandadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter3 extends BaseAdapter {

    Context context;
    ArrayList<String> list;
    LayoutInflater inflater;

    public CustomAdapter3(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = new ArrayList<>();
        this.list.addAll(list);
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.comment_demo, parent, false);
        }

        TextView comment = convertView.findViewById(R.id.commentTextView);
        TextView id = convertView.findViewById(R.id.employeeIDTextView);

        comment.setText("This is comment");
        id.setText(EmployeeDashboard.employeeId);

        return convertView;
    }
}
