package com.example.webview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageActivity extends BaseAdapter {
    Context context;

    int[] image;
    String[] browserName;


    LayoutInflater inflater;

    public HomePageActivity(Context context, String[] browserName, int[] image) {
        this.context = context;
        this.image = image;
        this.browserName = browserName;

    }

    @Override
    public int getCount() {
        return browserName.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home_page, null);
        }
        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.item_name);

        imageView.setImageResource(image[position]);
        textView.setText(browserName[position]);
        return convertView;
    }
}
