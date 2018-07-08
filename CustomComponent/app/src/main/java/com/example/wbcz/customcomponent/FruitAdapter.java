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
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView image = (ImageView) view.findViewById(R.id.fruit_image);
        TextView name = (TextView) view.findViewById(R.id.fruit_name);
        image.setImageResource(fruit.getImageId());
        name.setText(fruit.getName());
        return view;
    }

}
