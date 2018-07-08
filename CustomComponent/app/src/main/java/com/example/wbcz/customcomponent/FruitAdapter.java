package com.example.wbcz.customcomponent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> list) {
        super(context, textViewResourceId, list);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            //缓存布局
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            //缓存控件
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.name = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.image.setImageResource(fruit.getImageId());
        viewHolder.name.setText(fruit.getName());
        return view;
    }

}
