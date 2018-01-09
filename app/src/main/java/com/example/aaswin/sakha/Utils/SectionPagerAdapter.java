package com.example.aaswin.sakha.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaswin on 20/12/17.
 */

public class SectionPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragmentList=new ArrayList<Fragment>();

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment)
    {
        fragmentList.add(fragment);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


}
