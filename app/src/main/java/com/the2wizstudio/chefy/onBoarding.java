package com.the2wizstudio.chefy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        newOnBoardingAdapter adapter=new newOnBoardingAdapter(this,onbinding.viewpager);

        onbinding.viewpager.setAdapter(adapter);
        onbinding.viewpager.setClipToPadding(false);
        onbinding.viewpager.setClipChildren(false);
        onbinding.viewpager.setOffscreenPageLimit(2);
        onbinding.viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        onbinding.viewpager.setPageTransformer(new ZoomOutPageTransformer());
        onbinding.onboardingProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        Thread.sleep(120);
                        onbinding.viewpager.setCurrentItem(0,true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        onbinding.onboardingProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        Thread.sleep(120);
                        onbinding.viewpager.setCurrentItem(1,true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        onbinding.onboardingProgress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        Thread.sleep(120);
                        onbinding.viewpager.setCurrentItem(2,true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        onbinding.onboardingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onbinding.viewpager.getCurrentItem()==0) {

                    try {
                        Thread.sleep(120);
                        onbinding.viewpager.setCurrentItem(1,true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else if(onbinding.viewpager.getCurrentItem()==1) {
                    try {
                        Thread.sleep(120);
                        onbinding.viewpager.setCurrentItem(2,true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else if(onbinding.onboardingButton.getText().equals("Get Started")) {
                  //  SharedPreferences sharedPreferences= getSharedPreferences("onbdone",0);
                  //  SharedPreferences.Editor editor=sharedPreferences.edit();
                  //  editor.putString("onbdone","yes");
                  //  editor.commit();
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

    public void setAlphaAnimation(View v) {
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(v, "alpha",  1f, .3f);
        fadeOut.setDuration(500);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(v, "alpha", .3f, 1f);
        fadeIn.setDuration(500);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }
        });
        mAnimationSet.start();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }

    @Override
    public void onBackPressed() {
        if(onbinding.viewpager.getCurrentItem()==0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this).
                    setTitle("Exit?").setMessage("Do you want to exit the app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.show();
        }
        else if (onbinding.viewpager.getCurrentItem()==1) {
            onbinding.viewpager.setCurrentItem(0,true);
        }
        else if (onbinding.viewpager.getCurrentItem()==2) {
            onbinding.viewpager.setCurrentItem(1,true);
        }
    }
}

class ZoomOutPageTransformer implements ViewPager2.PageTransformer  {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.4f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0f);

        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0f);
        }
    }
}