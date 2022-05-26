package com.app.kinonet.food_category.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.food_category.model.FoodCategoryModel;
import com.app.kinonet.home.activities.FoodDetails;

import java.util.List;

public class Food_Category_Adapter extends RecyclerView.Adapter<Food_Category_Adapter.Holder> {

    private List<FoodCategoryModel> categoryList;
    private Context context;


    public Food_Category_Adapter(List<FoodCategoryModel> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_category_by_country, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {


        holder.foodname.setText(categoryList.get(position).getCategoryName());
        holder.foodimage.setImageResource(categoryList.get(position).getCategoryImage());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(context, FoodDetails.class);
                context.startActivity(intent);
                Toast.makeText(context, "" + categoryList.get(position).getCategoryName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView foodimage;
        TextView foodname;

        Holder(@NonNull View itemView) {
            super(itemView);
            foodimage = itemView.findViewById(R.id.itemimage);
            foodname = itemView.findViewById(R.id.itemname);

        }
    }

}





