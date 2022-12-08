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
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.the2wizstudio.chefy.databinding.ActivityOnBoardingBinding;

import java.util.ArrayList;

public class onBoarding extends AppCompatActivity {
    ActivityOnBoardingBinding onbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onbinding=ActivityOnBoardingBinding.inflate(getLayoutInflater());
        this.getSupportActionBar().hide();
        setContentView(onbinding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundGreen));
        }
        newOnBoardingAdapter adapter=new newOnBoardingAdapter(this);

        onbinding.viewpager.setAdapter(adapter);
        onbinding.viewpager.setClipToPadding(false);
        onbinding.viewpager.setClipChildren(false);
        onbinding.viewpager.setOffscreenPageLimit(2);
        onbinding.viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        onbinding.onboardingProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbinding.viewpager.setCurrentItem(0,true);
              //  onboardingFragment.setCurrentPos(1);
            }
        });
        onbinding.onboardingProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbinding.viewpager.setCurrentItem(1,true);
               // onboardingFragment.setCurrentPos(2);
            }
        });
        onbinding.onboardingProgress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbinding.viewpager.setCurrentItem(2,true);
               // onboardingFragment.setCurrentPos(3);
            }
        });
        onbinding.onboardingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onbinding.viewpager.getCurrentItem()==1 && !onbinding.onboardingButton.getText().equals("Next")) {
                    onbinding.viewpager.setCurrentItem(1,true);
               }
                else if(onbinding.viewpager.getCurrentItem()==2 && !onbinding.onboardingButton.getText().equals("Next")) {
                    onbinding.viewpager.setCurrentItem(2,true);
                }
                else if(onbinding.onboardingButton.getText().equals("Get Started")) {
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

        onbinding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position==0) {
                    //onboardingFragment.setCurrentPos(1);
                    onbinding.onboardingButton.setText("Next");
                    //onbinding.skipText.setVisibility(View.VISIBLE);
                    onbinding.onboardingProgress.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress1.setImageResource(R.drawable.ic_onboard_selected);
                    onbinding.onboardingProgress3.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());;
                    onbinding.onboardingProgress1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());;
                    onbinding.onboardingProgress.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());


                }
                else if(position==1) {
                    //onboardingFragment.setCurrentPos(2);
                    onbinding.onboardingButton.setText("Next");

                    onbinding.onboardingProgress1.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress.setImageResource(R.drawable.ic_onboard_selected);
                    onbinding.onboardingProgress3.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());;
                    onbinding.onboardingProgress.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());;
                    onbinding.onboardingProgress1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

                }
                else if(position==2) {
                  //  onboardingFragment.setCurrentPos(2);
                    onbinding.onboardingButton.setText("Get Started");

                    onbinding.onboardingProgress1.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress3.setImageResource(R.drawable.ic_onboard_selected);
                    onbinding.onboardingProgress.setImageResource(R.drawable.ic_onboard_notselected);
                    onbinding.onboardingProgress3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());;
                    onbinding.onboardingProgress3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());;
                    onbinding.onboardingProgress1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    onbinding.onboardingProgress.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

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