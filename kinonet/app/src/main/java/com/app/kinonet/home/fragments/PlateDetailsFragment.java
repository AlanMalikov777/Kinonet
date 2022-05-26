package com.app.kinonet.home.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.home.activities.ReceiptDetailsActivity;
import com.app.kinonet.home.adapter.Food_plate_adapter;
import com.app.kinonet.home.model.Food_Plate_Model;

import java.util.ArrayList;
import java.util.List;

public class PlateDetailsFragment extends Fragment {
    String desc,actor1,actor2,actor3,director, movieId;

    public PlateDetailsFragment(String desc, String actor1, String actor2, String actor3,
                                String director, String movieId) {
        this.desc = desc;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.director = director;
        this.movieId = movieId;
    }

    private RecyclerView recyclerView;
    private Food_plate_adapter adapter;
    private LinearLayoutManager layoutManager1;
    private List<Food_Plate_Model> foodList;
    TextView tx, act1,act2,act3,dir;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plate_details, container, false);
        tx = view.findViewById(R.id.desc);
        act1 = view.findViewById(R.id.actor1);
        act2 = view.findViewById(R.id.actor2);
        act3 = view.findViewById(R.id.actor3);
        dir = view.findViewById(R.id.director);
        tx.setText(desc);
        act1.setText(actor1);
        act2.setText(actor2);
        act3.setText(actor3);
        dir.setText(director);

        Button button = view.findViewById(R.id.viewReceipt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kinopoisk.ru/film/"+movieId));
                startActivity(websiteIntent);

            }
        });


        return view;
    }

}
