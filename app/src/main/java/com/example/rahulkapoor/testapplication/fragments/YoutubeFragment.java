package com.example.rahulkapoor.testapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rahulkapoor.testapplication.R;

public class YoutubeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_youtube, container, false);


        return v;
    }


    public static YoutubeFragment newInstance() {

        YoutubeFragment frag = new YoutubeFragment();

        return frag;
    }
}
