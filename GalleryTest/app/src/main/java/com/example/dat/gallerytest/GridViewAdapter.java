package com.example.dat.gallerytest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAT on 5/13/2015.
 */
public class GridViewAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<ImageItem> data = new ArrayList();

    public GridViewAdapter(Context context, int resource, ArrayList data) {
        super(context, resource, data);
        this.resource = resource;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) row.findViewById(R.id.imageView);
            holder.imageTitle = (TextView) row.findViewById(R.id.text);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        ImageItem item = data.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.image.setImageResource(item.getImageID());
        return row;
    }

    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }
}
