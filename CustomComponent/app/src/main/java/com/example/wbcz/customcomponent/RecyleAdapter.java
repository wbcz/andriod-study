package com.example.wbcz.customcomponent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.ViewHolder> {

    public List<Fruit> mfruitList;

    public RecyleAdapter(List<Fruit> fruitList) {
        mfruitList = fruitList;
    }

    @NonNull
    @Override
    public RecyleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.fruit_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyleAdapter.ViewHolder viewHolder, int i) {
        Fruit fruit = mfruitList.get(i);
        viewHolder.image.setImageResource(fruit.getImageId());
        viewHolder.name.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mfruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.fruit_image);
            name = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
}
