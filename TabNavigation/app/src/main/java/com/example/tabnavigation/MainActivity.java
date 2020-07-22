package com.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabs);

        TabAdpater adpater = new TabAdpater(getSupportFragmentManager());
        viewPager.setAdapter(adpater);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_chat_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_camera_alt_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_call_24);
    }

    class TabAdpater extends FragmentPagerAdapter {

        public TabAdpater(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Chats();
                case 1:
                    return new Status();
                case 2:
                    return new Calls();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chats";
                case 1:
                    return "Status";
                case 2:
                    return "Calls";
            }
            return super.getPageTitle(position);
        }
    }

}