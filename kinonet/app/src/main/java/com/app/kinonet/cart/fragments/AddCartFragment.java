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
import com.app.kinonet.cart.activities.ItemCartActivity;
import com.app.kinonet.cart.adapter.AddCartAdapter;

public class AddCartFragment extends Fragment {

    String foodItemList[] = {"Mexican Pizza", "Grilled Salmon", "Pasta Ham"};
    double foodPriceList[] = {100.00, 96.00, 120.00};
    int imgList[] = {R.drawable.mexican_pizza, R.drawable.grilled_salmon, R.drawable.chicken_pasta};
    RecyclerView recyclerView;

    LinearLayout layoutItemCart;


    public AddCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_cart, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        layoutItemCart = view.findViewById(R.id.layout_item_cart);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);

        AddCartAdapter customAdapter = new AddCartAdapter(getActivity(), foodItemList, foodPriceList, imgList);
        recyclerView.setAdapter(customAdapter);


        layoutItemCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ItemCartActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
