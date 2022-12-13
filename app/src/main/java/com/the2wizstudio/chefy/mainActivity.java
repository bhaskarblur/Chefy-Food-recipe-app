package com.the2wizstudio.chefy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import com.the2wizstudio.chefy.databinding.ActivityMainBinding;

public class mainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        homeFragment homeFragment=new homeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFragment, homeFragment);
        transaction.commit();

        manageNavBar();
    }

    private void manageNavBar() {

        homeFragment homeFragment=new homeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFragment, homeFragment);
        transaction.commit();

        final Boolean[] cookOpened = {false};
        binding.cooklayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlphaAnimation(binding.cooklayout);
                if(cookOpened[0]) {
                    cookOpened[0] = false;
                    setAlphaAnimation2(binding.cooklayout);

                }
                else {
                    cookOpened[0] = true;
                    setAlphaAnimation3(binding.cooklayout);


                }

            }
        });
        binding.homelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlphaAnimation(binding.homeIcon);

                // Picasso.get().load(R.drawable.ic_homeselected).into(binding.homeIcon);
                binding.homeIcon.setImageResource(R.drawable.ic_home_selected);

                //Picasso.get().load(R.drawable.ic_trending).into(binding.trendingIcon);
                binding.searchIcon.setImageResource(R.drawable.ic_search_notselected);

                // Picasso.get().load(R.drawable.ic_bookmark).into(binding.savedIcon);
                binding.notiIcon.setImageResource(R.drawable.ic_notificication_notselected);

                // Picasso.get().load(R.drawable.ic_profile).into(binding.profileIcon);
                binding.profileIcon.setImageResource(R.drawable.ic_profile_notselected);

                homeFragment homeFragment=new homeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_2, R.anim.fade);
                transaction.replace(R.id.mainFragment, homeFragment);
                transaction.commit();

            }
        });

        binding.searchlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlphaAnimation(binding.searchIcon);
                binding.homeIcon.setImageResource(R.drawable.ic_icon_homenotselected);

                //Picasso.get().load(R.drawable.ic_trending).into(binding.trendingIcon);
                binding.searchIcon.setImageResource(R.drawable.ic_search_selected);

                // Picasso.get().load(R.drawable.ic_bookmark).into(binding.savedIcon);
                binding.notiIcon.setImageResource(R.drawable.ic_notificication_notselected);

                // Picasso.get().load(R.drawable.ic_profile).into(binding.profileIcon);
                binding.profileIcon.setImageResource(R.drawable.ic_profile_notselected);

               // trendingFragment homeFragment=new trendingFragment();
             //   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
             //   transaction.setCustomAnimations(R.anim.fade_2, R.anim.fade);
              //  transaction.replace(R.id.mainFragment, homeFragment);
              //  transaction.commit();
            }
        });

        binding.notilayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlphaAnimation(binding.notiIcon);

                binding.homeIcon.setImageResource(R.drawable.ic_icon_homenotselected);

                //Picasso.get().load(R.drawable.ic_trending).into(binding.trendingIcon);
                binding.searchIcon.setImageResource(R.drawable.ic_search_notselected);

                // Picasso.get().load(R.drawable.ic_bookmark).into(binding.savedIcon);
                binding.notiIcon.setImageResource(R.drawable.ic_notification_selected);

                // Picasso.get().load(R.drawable.ic_profile).into(binding.profileIcon);
                binding.profileIcon.setImageResource(R.drawable.ic_profile_notselected);

              //  savednewsFragment homeFragment=new savednewsFragment();
              //  FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               // transaction.setCustomAnimations(R.anim.fade_2, R.anim.fade);
               // transaction.replace(R.id.mainFragment, homeFragment);
             //   transaction.commit();
            }
        });

        binding.profilelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlphaAnimation(binding.profileIcon);
                binding.homeIcon.setImageResource(R.drawable.ic_icon_homenotselected);

                //Picasso.get().load(R.drawable.ic_trending).into(binding.trendingIcon);
                binding.searchIcon.setImageResource(R.drawable.ic_search_notselected);

                // Picasso.get().load(R.drawable.ic_bookmark).into(binding.savedIcon);
                binding.notiIcon.setImageResource(R.drawable.ic_notificication_notselected);

                // Picasso.get().load(R.drawable.ic_profile).into(binding.profileIcon);
                binding.profileIcon.setImageResource(R.drawable.ic_profileselected);


              //  profileFragment homeFragment=new profileFragment();
             //   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
              //  transaction.setCustomAnimations(R.anim.fade_2, R.anim.fade);
              //  transaction.replace(R.id.mainFragment, homeFragment);
              //  transaction.commit();
            }
        });
    }

    public void setAlphaAnimation(View v) {
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(v, "alpha",  1f, .3f);
        fadeOut.setDuration(80);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(v, "alpha", .3f, 1f);
        fadeIn.setDuration(80);

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

    public void setAlphaAnimation2(View v) {
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(v, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa1.setDuration(150);
        oa2.setDuration(150);

        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                binding.cookIcon.setImageResource(R.drawable.ic_icon_chef);
                oa2.start();

                Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_in_down_50);

                Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_in_up_50);

                binding.chefDialogButtons.startAnimation(slide_up);


            }
        });
        oa1.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.chefDialog.setVisibility(View.INVISIBLE);
            }
        },300);

    }
    public void setAlphaAnimation3(View v) {
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(v, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa1.setDuration(150);
        oa2.setDuration(150);

        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                binding.cookIcon.setImageResource(R.drawable.ic_icon_close);
                oa2.start();
                binding.chefDialog.setVisibility(View.VISIBLE);
                Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_in_down_50);

                Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_in_up_50);


                binding.chefDialogButtons.startAnimation(slide_down);

            }
        });
        oa1.start();
    }

    @Override
    public void onBackPressed() {
        //The Fragment Manager causes Memory Leaks. Needs to be fixed

        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();

            if (getSupportFragmentManager().getBackStackEntryCount() < 2) {
                // set the home tab as default;
                binding.homeIcon.setImageResource(R.drawable.ic_home_selected);

                //Picasso.get().load(R.drawable.ic_trending).into(binding.trendingIcon);
                binding.searchIcon.setImageResource(R.drawable.ic_search_notselected);

                // Picasso.get().load(R.drawable.ic_bookmark).into(binding.savedIcon);
                binding.notiIcon.setImageResource(R.drawable.ic_notificication_notselected);

                // Picasso.get().load(R.drawable.ic_profile).into(binding.profileIcon);
                binding.profileIcon.setImageResource(R.drawable.ic_profile_notselected);

             //   homeFragment homeFragment=new homeFragment();
              //  FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
              //  transaction.setCustomAnimations(R.anim.fade_2, R.anim.fade);
              //  transaction.replace(R.id.mainFragment, homeFragment);
               // transaction.commit();

            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Exit?")
                    .setMessage("Do you want to exit the app?")
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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}