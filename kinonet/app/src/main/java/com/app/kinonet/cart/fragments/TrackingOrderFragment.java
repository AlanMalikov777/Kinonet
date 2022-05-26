package com.app.kinonet.cart.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.cart.adapter.TrackingOrderAdapter;


public class TrackingOrderFragment extends Fragment {
    String foodItemList[] = {"Mexican Pizza", "Grilled Salmon", "Pasta Ham"};
    double foodPriceList[] = {100.00, 96.00, 120.00};
    int imgList[] = {R.drawable.mexican_pizza, R.drawable.grilled_salmon, R.drawable.chicken_pasta};
    RecyclerView recyclerView;


    public TrackingOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tracking_order, container, false);

        // get the reference of RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);

        TrackingOrderAdapter customAdapter = new TrackingOrderAdapter(getActivity(), foodItemList, foodPriceList, imgList);
        recyclerView.setAdapter(customAdapter);


        return view;
    }

}
