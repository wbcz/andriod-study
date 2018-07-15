package com.example.wbcz.customcomponent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.ViewHolder> {

    public List<Fruit> mfruitList;

    /**
     * 适配器
     * @param fruitList
     */
    public RecyleAdapter(List<Fruit> fruitList) {
        mfruitList = fruitList;
    }

//    @NonNull
//    @Override
//    public RecyleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext())
//            .inflate(R.layout.fruit_item, viewGroup, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }

    /**
     * 绑定数据
     * @param viewHolder
     * @param i
     */
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

    /**
     * 内部类
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public View fruitView;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            image = (ImageView) view.findViewById(R.id.fruit_image);
            name = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    /**
     * 实例化ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(view.getContext(), "you click" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(view.getContext(), "you click" + fruit.getImageId(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }
}
