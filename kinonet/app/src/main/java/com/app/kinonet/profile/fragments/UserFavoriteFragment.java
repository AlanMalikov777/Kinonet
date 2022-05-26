package com.app.kinonet.profile.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.profile.adapter.Food_Menu_Adapter;
import com.app.kinonet.profile.model.Food_Menu_Model;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private Food_Menu_Adapter adapter;
    private GridLayoutManager layoutManager;
    private List<Food_Menu_Model> foodList;


    public UserFavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_chef, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_food_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        foodList = new ArrayList<>();

        foodList.add(new Food_Menu_Model("Available", "Mexican Pizza", "4.3(200)", "15-20 min", "Delivery", R.drawable.mexican_pizza));
        foodList.add(new Food_Menu_Model("Available", "Chicken Pasta", "4.5(200)", "25-30 min", "Delivery", R.drawable.chicken_pasta));
        foodList.add(new Food_Menu_Model("Available", "Grilled Salmon", "4.9(200)", "15-20 min", "Delivery", R.drawable.grilled_salmon));
        foodList.add(new Food_Menu_Model("Available", "Chicken Biryani", "5.0(200)", "15-20 min", "Delivery", R.drawable.chicken_biryani));
        foodList.add(new Food_Menu_Model("Available", "Ice Coffee", "4.8(200)", "10-15 min", "Delivery", R.drawable.ice_coffee));

        foodList.add(new Food_Menu_Model("Available", "Mexican Pizza", "4.3(200)", "15-20 min", "Delivery", R.drawable.mexican_pizza));
        foodList.add(new Food_Menu_Model("Available", "Chicken Pasta", "4.5(200)", "25-30 min", "Delivery", R.drawable.chicken_pasta));
        foodList.add(new Food_Menu_Model("Available", "Grilled Salmon", "4.9(200)", "15-20 min", "Delivery", R.drawable.grilled_salmon));
        foodList.add(new Food_Menu_Model("Available", "Chicken Biryani", "5.0(200)", "15-20 min", "Delivery", R.drawable.chicken_biryani));
        foodList.add(new Food_Menu_Model("Available", "Ice Coffee", "4.8(200)", "10-15 min", "Delivery", R.drawable.ice_coffee));

        adapter = new Food_Menu_Adapter(foodList, getActivity());
        recyclerView.setAdapter(adapter);


        return view;


    }

}
