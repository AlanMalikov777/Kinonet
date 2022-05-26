package com.app.kinonet.home.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.home.adapter.Food_plate_adapter;
import com.app.kinonet.home.model.Food_Plate_Model;

import java.util.List;

public class KitchenDetailsFragment extends Fragment {


    public KitchenDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kitchen_details, container, false);
        return view;
    }

}
