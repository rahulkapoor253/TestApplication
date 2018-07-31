package com.example.rahulkapoor.testapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rahulkapoor.testapplication.fragments.ChatFragment;
import com.example.rahulkapoor.testapplication.fragments.YoutubeFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {

            case 0:
                return YoutubeFragment.newInstance();
            case 1:
                return ChatFragment.newInstance();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
