package com.app.kinonet.cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;

public class CustomOrderListAdapter extends RecyclerView.Adapter<CustomOrderListAdapter.MyViewHolder> {


    Context context;
    private String foodItemList[];


    //constructor
    public CustomOrderListAdapter(Context context, String foodItemList[], double foodPriceList[], int imgList[]) {
        this.context = context;
        this.foodItemList = foodItemList;

    }


    @NonNull
    public CustomOrderListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_order_list_row_items, parent, false);
        CustomOrderListAdapter.MyViewHolder vh = new CustomOrderListAdapter.MyViewHolder(view); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myHolder, final int position) {


        myHolder.txtChefName.setText(foodItemList[position]);
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, foodItemList[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


    //for item count
    @Override
    public int getItemCount() {
        return foodItemList.length;
    }


    //create class
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtChefName;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            txtChefName = itemView.findViewById(R.id.txt_chef_name);

        }
    }
}


