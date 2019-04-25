package com.example.tablayout_slidercustom_icons_viewpager;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tablayout_slidercustom_icons_viewpager.Fragments.Five;
import com.example.tablayout_slidercustom_icons_viewpager.Fragments.Four;
import com.example.tablayout_slidercustom_icons_viewpager.Fragments.One;
import com.example.tablayout_slidercustom_icons_viewpager.Fragments.Six;
import com.example.tablayout_slidercustom_icons_viewpager.Fragments.Three;
import com.example.tablayout_slidercustom_icons_viewpager.Fragments.Two;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {R.drawable.ic_one,R.drawable.ic_two,R.drawable.ic_three,
            R.drawable.ic_four,R.drawable.ic_five,R.drawable.ic_six};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        setupViewPager();
        setupTabIcons();

    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);

    }

    private void setupViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new One(),"Frag One");
        viewPagerAdapter.addFragment(new Two(),"Frag Two");
        viewPagerAdapter.addFragment(new Three(),"Frag Three");
        viewPagerAdapter.addFragment(new Four(),"Frag Four");
        viewPagerAdapter.addFragment(new Five(),"Frag Five");
        viewPagerAdapter.addFragment(new Six(),"Frag Six");

        viewPager.setAdapter(viewPagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}
