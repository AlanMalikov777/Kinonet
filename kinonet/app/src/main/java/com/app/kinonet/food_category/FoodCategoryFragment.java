package com.app.kinonet.food_category;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.food_category.adapter.Food_Category_Adapter;
import com.app.kinonet.food_category.model.FoodCategoryModel;

import java.util.ArrayList;
import java.util.List;


public class FoodCategoryFragment extends Fragment {


    public FoodCategoryFragment() {
        // Required empty public constructor
    }


    private RecyclerView recyclerView;
    private Food_Category_Adapter adapter;
    private GridLayoutManager layoutManager;
    private List<FoodCategoryModel> categoryList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_category, container, false);


        categoryList = new ArrayList<>();


        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        categoryList.add(new FoodCategoryModel("Arabian", R.drawable.upload_thumbnail));
        categoryList.add(new FoodCategoryModel("Japanese", R.drawable.food_image2));
        categoryList.add(new FoodCategoryModel("Asian", R.drawable.img_food_2));
        categoryList.add(new FoodCategoryModel("Bengali", R.drawable.food_image3));
        categoryList.add(new FoodCategoryModel("Mexican", R.drawable.mexican_pizza));
        categoryList.add(new FoodCategoryModel("Indian", R.drawable.chicken_biryani));
        categoryList.add(new FoodCategoryModel("Italian", R.drawable.grilled_salmon));
        categoryList.add(new FoodCategoryModel("American", R.drawable.chicken_pasta));

        adapter = new Food_Category_Adapter(categoryList, getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }


}

