package com.example.food_recipe_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.List;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.ViewHolder>{
    private Context context;
    private List<Product_Model> product_modelList;

    public Product_Adapter(Context context, List<Product_Model> product_modelList) {
        this.context = context;
        this.product_modelList = product_modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(product_modelList.get(position).getUri()).into(holder.imageView);
        holder.name.setText(product_modelList.get(position).getName());
        holder.rate.setText(String.valueOf(product_modelList.get(position).getRate()));
       //holder.rate.setText(product_modelList.get(position).getRate());
        holder.des.setText(product_modelList.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details_Activity.class);
                intent.putExtra("detail",product_modelList.get(position));
                intent.putExtra("type",product_modelList.get(position).getType());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return product_modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,rate,des;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.p_image);
            name=itemView.findViewById(R.id.pname);
            rate=itemView.findViewById(R.id.prate);
            des=itemView.findViewById(R.id.pdes);
        }
    }
}
