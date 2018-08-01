package com.example.rahulkapoor.testapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rahulkapoor.testapplication.HomeActivity;
import com.example.rahulkapoor.testapplication.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView playerView;
    private static final int RECOVERY_REQUEST = 1;
    private static final String videoPlaylist = "PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD";

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_youtube, container, false);

        playerView = (YouTubePlayerView) v.findViewById(R.id.youtubeplayer_view);
        playerView.initialize(getResources().getString(R.string.youtube_api_key), this);


        return v;
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RECOVERY_REQUEST) {
            //retry initialising the player view;
            playerView.initialize(getResources().getString(R.string.youtube_api_key), this);
        }

    }


    public static YoutubeFragment newInstance() {

        YoutubeFragment frag = new YoutubeFragment();

        return frag;
    }

    @Override
    public void onInitializationSuccess(final YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, final boolean restored) {

        if (!restored) {
            youTubePlayer.cueVideo(videoPlaylist);
        }

    }

    @Override
    public void onInitializationFailure(final YouTubePlayer.Provider provider, final YouTubeInitializationResult youTubeInitializationResult) {
        youTubeInitializationResult.getErrorDialog(((HomeActivity) getActivity()), RECOVERY_REQUEST).show();

    }
}
