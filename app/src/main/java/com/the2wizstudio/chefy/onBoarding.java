package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.the2wizstudio.chefy.databinding.ActivityOnBoardingBinding;

public class onBoarding extends AppCompatActivity {
    ActivityOnBoardingBinding onbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        onbinding=ActivityOnBoardingBinding.inflate(getLayoutInflater());
        this.getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen));
        }
        onboarding_frag onboardingFragment=new onboarding_frag();
        onbinding.viewpager.setAdapter(new ScreenSlidePagerAdapter(this));

        onbinding.onboardingProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbinding.viewpager.setCurrentItem(0,true);
                onboardingFragment.setCurrentPos(1);
            }
        });
        onbinding.onboardingProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbinding.viewpager.setCurrentItem(1,true);
                onboardingFragment.setCurrentPos(2);
            }
        });
        onbinding.onboardingProgress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbinding.viewpager.setCurrentItem(2,true);
                onboardingFragment.setCurrentPos(3);
            }
        });
        onbinding.onboardingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(onBoarding.this, "Welcome", Toast.LENGTH_SHORT).show();
                if(onboardingFragment.getCurrentPos()==1 && !onbinding.onboardingButton.getText().equals("Next")) {
                    onbinding.viewpager.setCurrentItem(1,true);
                    onboardingFragment.setCurrentPos(2);
                }
                else if(onboardingFragment.getCurrentPos()==2 && !onbinding.onboardingButton.getText().equals("Next")) {
                    onbinding.viewpager.setCurrentItem(2,true);
                    onboardingFragment.setCurrentPos(3);
                }
                else if(onbinding.onboardingButton.getText().equals("Get Started") || onbinding.onboardingButton.getText().equals("Next")) {
                    Toast.makeText(onBoarding.this, "Welcome", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences= getSharedPreferences("onbdone",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("onbdone","yes");
                    editor.commit();
                    startActivity(new Intent(onBoarding.this,loginAsk.class));
                    finish();


                }
            }

        });
        onbinding.skipText.setClickable(true);
        onbinding.skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(onBoarding.this, "Welcome", Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences= getSharedPreferences("onbdone",0);
               SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("onbdone","yes");
                editor.commit();
                startActivity(new Intent(onBoarding.this,loginAsk.class));
                finish();
            }
        });

        onbinding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position==0) {
                    onboardingFragment.setCurrentPos(1);
                    onbinding.onboardingButton.setText("Next");
                    onbinding.skipText.setVisibility(View.VISIBLE);
                    onbinding.onboardingProgress.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress1.setImageResource(R.drawable.ic_onboard_selected);
                    onbinding.onboardingProgress3.setImageResource(R.drawable.ic_onboard_notselected);

                }
                else if(position==1) {
                    onboardingFragment.setCurrentPos(2);
                    onbinding.onboardingButton.setText("Next");
                    onbinding.skipText.setVisibility(View.VISIBLE);
                    onbinding.onboardingProgress1.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress.setImageResource(R.drawable.ic_onboard_selected);
                    onbinding.onboardingProgress3.setImageResource(R.drawable.ic_onboard_notselected);
                }
                else if(position==2) {
                    onboardingFragment.setCurrentPos(2);
                    onbinding.onboardingButton.setText("Get Started");
                    onbinding.skipText.setVisibility(View.VISIBLE);
                    onbinding.onboardingProgress1.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress3.setImageResource(R.drawable.ic_onboard_selected);
                    onbinding.onboardingProgress.setImageResource(R.drawable.ic_onboard_notselected);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
    }


}
class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    public ScreenSlidePagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        return new onboarding_frag();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}