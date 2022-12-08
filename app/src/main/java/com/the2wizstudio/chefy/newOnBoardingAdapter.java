package com.the2wizstudio.chefy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class newOnBoardingAdapter extends FragmentStateAdapter {
    onboarding_frag page1,page2,page3;

    public newOnBoardingAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        page1=new onboarding_frag();
        page1.setCurrentPos(1);
        page2=new onboarding_frag();
        page2.setCurrentPos(2);
        page3=new onboarding_frag();
        page3.setCurrentPos(3);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
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
    public int getItemCount() {
        return 3;
    }
}


