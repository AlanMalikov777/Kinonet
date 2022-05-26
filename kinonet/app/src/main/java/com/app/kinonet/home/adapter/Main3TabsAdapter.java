package com.app.kinonet.home.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.app.kinonet.home.fragments.KitchenFragment;
import com.app.kinonet.home.fragments.PlateFragment;
import com.app.kinonet.home.fragments.ReceiptFragment;


public class Main3TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    String desc,actor1,actor2,actor3,director, movieId, slogan;


    public Main3TabsAdapter(FragmentManager fm, int NoofTabs, String desc, String actor1, String actor2, String actor3,
                            String director, String movieId, String slogan) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
        this.desc = desc;
        this.actor1 = actor1;
        this.actor2 = actor2;
        this.actor3 = actor3;
        this.director = director;
        this.movieId = movieId;
        this.slogan = slogan;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PlateFragment pf = new PlateFragment(desc, director, actor3, actor2, actor1, movieId, slogan);

                return pf;
            case 1:
                KitchenFragment kf = new KitchenFragment();
                return kf;

            case 2:
                ReceiptFragment rf = new ReceiptFragment();

                return rf;

            default:
                return null;
        }
    }
}