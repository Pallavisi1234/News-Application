package com.example.mynewsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryModel> categoryModels;
    private Context context;
    private CategoryClickinterface categoryClickinterface;

    public CategoryAdapter(ArrayList<CategoryModel> categoryModels, Context context, CategoryClickinterface categoryClickinterface) {
        this.categoryModels = categoryModels;
        this.context = context;
        this.categoryClickinterface = categoryClickinterface;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        CategoryModel categoryModel = categoryModels.get(position);
        holder.tvcategory.setText(categoryModel.getCategory());
        Picasso.get().load(categoryModel.getCategoryImageUrl()).into(holder.ivcategory);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickinterface.onCategoryClick(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public Locale getFilter() {
        return null;
    }

    public interface CategoryClickinterface{
        void onCategoryClick(int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvcategory;
        private ImageView ivcategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivcategory = itemView.findViewById(R.id.ivcategory);
            tvcategory = itemView.findViewById(R.id.tvcategory);
        }
    }
}
