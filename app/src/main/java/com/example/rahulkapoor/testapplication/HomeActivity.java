package com.example.rahulkapoor.testapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.rahulkapoor.testapplication.adapter.MyPagerAdapter;
import com.example.rahulkapoor.testapplication.utility.SharedPref;

public class HomeActivity extends FragmentActivity {

    private Button btnLogout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                SharedPref.getInstance(getApplicationContext()).save_token(null, getApplicationContext());
                finish();
            }
        });

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }

    /**
     * init made;
     */
    private void init() {

        btnLogout = (Button) findViewById(R.id.logout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

    }
}
