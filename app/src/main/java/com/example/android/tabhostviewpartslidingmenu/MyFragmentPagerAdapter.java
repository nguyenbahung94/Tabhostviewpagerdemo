package com.example.android.tabhostviewpartslidingmenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by everything on 3/25/2016.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment;
    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> listFragment) {
        super(fm);
        this.listFragment=listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
