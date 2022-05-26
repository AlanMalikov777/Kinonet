package com.app.kinonet.cart.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.cart.activities.CustomOrderCheckoutActivity;
import com.app.kinonet.cart.adapter.CustomOrderAdapter;

public class CustomOrderFragment extends Fragment {


    public CustomOrderFragment() {
        // Required empty public constructor
    }

    String foodItemList[] = {"Mexican Pizza", "Grilled Salmon", "Pasta Ham"};

    int imgList[] = {R.drawable.mexican_pizza, R.drawable.grilled_salmon, R.drawable.chicken_pasta};
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_order, container, false);

        LinearLayout itemCart = view.findViewById(R.id.layout_custom_order_cart);

        // get the reference of RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);


        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomOrderAdapter customAdapter = new CustomOrderAdapter(getActivity(), foodItemList, imgList);
        recyclerView.setAdapter(customAdapter);


        itemCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomOrderCheckoutActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
