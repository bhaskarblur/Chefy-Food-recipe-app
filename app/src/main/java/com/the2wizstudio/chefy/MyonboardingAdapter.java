package com.the2wizstudio.chefy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyonboardingAdapter extends FragmentPagerAdapter {

    onboarding_frag page1,page2,page3;
    public MyonboardingAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
        page1=new onboarding_frag();
        page1.setCurrentPos(1);
        page2=new onboarding_frag();
        page2.setCurrentPos(2);
        page3=new onboarding_frag();
        page3.setCurrentPos(3);
    }



    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return page1;
            case 1:
                return page2;
            case 2:
                return page3;
            default:
                return page1;
        }


    }

    @Override
    public int getCount() {
        return 3;
    }
}
