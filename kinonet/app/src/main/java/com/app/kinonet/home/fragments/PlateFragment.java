package com.app.kinonet.home.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.kinonet.R;
import com.app.kinonet.home.adapter.Sub2TabsAdapter;
import com.google.android.material.tabs.TabLayout;


public class PlateFragment extends Fragment {
    String desc,actor1,actor2,actor3,director, movieId, slogan;

    public PlateFragment(String desc, String actor1, String actor2, String actor3,
                         String director, String movieId, String slogan) {
        this.desc = desc;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.director = director;
        this.movieId = movieId;
        this.slogan = slogan;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plate, container, false);

        TextView slog = view.findViewById(R.id.slogan);
        slog.setText(slogan);
        TabLayout tabLayout = view.findViewById(R.id.details_review_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Детали"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = view.findViewById(R.id.details_review_viewpager);
        Sub2TabsAdapter tabsAdapter = new Sub2TabsAdapter(getChildFragmentManager(), tabLayout.getTabCount(),desc, director, actor3, actor2, actor1, movieId);
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }


}
