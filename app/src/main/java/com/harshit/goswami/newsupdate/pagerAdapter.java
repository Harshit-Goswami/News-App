package com.harshit.goswami.newsupdate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.harshit.goswami.newsupdate.fragments.businessFragment;
import com.harshit.goswami.newsupdate.fragments.entertainmentFragment;
import com.harshit.goswami.newsupdate.fragments.helthFragment;
import com.harshit.goswami.newsupdate.fragments.homeFragment;
import com.harshit.goswami.newsupdate.fragments.scienceFragment;
import com.harshit.goswami.newsupdate.fragments.sportFragment;
import com.harshit.goswami.newsupdate.fragments.technologyFragment;

public class pagerAdapter extends FragmentPagerAdapter {
    int tabcount;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount =behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
             case 0:return new homeFragment();
             case 1:return new sportFragment();
             case 2:return new helthFragment();
             case 3:return new scienceFragment();
             case 4:return new entertainmentFragment();
             case 5:return new technologyFragment();
            case 6:return new businessFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
