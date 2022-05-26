package com.app.kinonet.profile.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.profile.model.Food_Menu_Model;

import java.util.List;

public class Food_Menu_Adapter extends RecyclerView.Adapter<Food_Menu_Adapter.Holder> {


    private List<Food_Menu_Model> foodlist;


    public Food_Menu_Adapter(List<Food_Menu_Model> foodlist, Context context) {
        this.foodlist = foodlist;


    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {


        holder.foodname.setText(foodlist.get(position).getFood_name());

        holder.foodrating.setText(foodlist.get(position).getFood_rating());

        holder.foodrating.setText(foodlist.get(position).getFood_rating());
        holder.foodtime.setText(foodlist.get(position).getFood_time());
        holder.fooddeliver.setText(foodlist.get(position).getFood_delivery_text());
        holder.foodimage.setImageResource(foodlist.get(position).getFood_image());


    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView foodimage;
        TextView foodname, foodrating, foodtime, fooddeliver;

        Holder(@NonNull View itemView) {
            super(itemView);
            foodname = itemView.findViewById(R.id.foodname);
            foodrating = itemView.findViewById(R.id.ratings);
            foodtime = itemView.findViewById(R.id.times);
            fooddeliver = itemView.findViewById(R.id.deliverytext);
            foodimage = itemView.findViewById(R.id.foodimage);

        }
    }

}





