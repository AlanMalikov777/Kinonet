package com.app.kinonet.profile.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.app.kinonet.R;
import com.app.kinonet.profile.TabsAdapter;
import com.app.kinonet.profile.activities.EditProfileActivity;
import com.google.android.material.tabs.TabLayout;


public class AccountFragment extends Fragment {


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        ImageView imgUser = view.findViewById(R.id.user_image);

        return view;
    }



}
