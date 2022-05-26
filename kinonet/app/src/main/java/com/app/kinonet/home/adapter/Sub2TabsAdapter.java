package com.app.kinonet.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.app.kinonet.home.fragments.PlateDetailsFragment;
import com.app.kinonet.home.fragments.PlateReviewFragment;


public class Sub2TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    String desc,actor1,actor2,actor3,director, movieId;
    public Sub2TabsAdapter(FragmentManager fm, int NoofTabs, String desc, String actor1, String actor2, String actor3,
                           String director, String movieId) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
        this.desc = desc;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.director = director;
        this.movieId = movieId;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PlateDetailsFragment pf = new PlateDetailsFragment(desc, actor3, actor2, actor1, director, movieId);
                return pf;
            case 1:
                PlateReviewFragment rf = new PlateReviewFragment();
                return rf;


            default:
                return null;
        }
    }
}