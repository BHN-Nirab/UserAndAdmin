package com.example.userandadmin;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class ShowContent extends AppCompatActivity {

    public static int contentID;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_content);


        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
            contentID =  bundle.getInt("contentID");

        viewPager = findViewById(R.id.viewPagerID);
        FragmentManager fragmentManager = getSupportFragmentManager();
        final CustomAdapter2 adapter = new CustomAdapter2(fragmentManager);
        viewPager.setAdapter(adapter);
    }
}


class CustomAdapter2 extends FragmentStatePagerAdapter {

    public CustomAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        if(i==0)
        {
            fragment = new Content();
        }
        else if(i==1)
        {
            fragment = new Comment();

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}