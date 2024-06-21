package com.example.food_recipe_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SlidAdapter extends RecyclerView.Adapter<SlidAdapter.ViewHolder>{
    private Context context;
    private List<Slidingmodel> slidingmodelList;

    public SlidAdapter(Context context, List<Slidingmodel> slidingmodelList) {
        this.context = context;
        this.slidingmodelList = slidingmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new SlidAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sling,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(slidingmodelList.get(position).getName());
        holder.recipe.setText(String.valueOf(slidingmodelList.get(position).getRecipename()));
    }

    @Override
    public int getItemCount() {
        return slidingmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,recipe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           name =itemView.findViewById(R.id.slidname);
           recipe=itemView.findViewById(R.id.slidorder);

        }
    }
}
