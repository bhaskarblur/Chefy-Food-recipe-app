package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.the2wizstudio.chefy.databinding.ActivityPreparePlanningBinding;

public class preparePlanning extends AppCompatActivity {
    ActivityPreparePlanningBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPreparePlanningBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        viewFunc();

    }

    private void viewFunc() {
        binding.progressBar.setProgress(250);
     //   new CountDownTimer(6000, 500) {
      //      public void onFinish() {

       //     }

        //    public void onTick(long millisUntilFinished) {
        //        binding.progressBar.setProgress(binding.progressBar.getProgress()+1);
      //      }
     //   }.start();
        setProgressAnimate(binding.progressBar,100);
    }



    private void setProgressAnimate(ProgressBar pb, int progressTo)
    {
        binding.shimmerViewContainer.setBaseAlpha(0.8f);
        binding.shimmerViewContainer.startShimmerAnimation();
      pb.setMax(1000);
      int currentProgress=700;

      ObjectAnimator.ofInt(pb,"progress",currentProgress).
              setDuration(7500).
              start();
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              pb.setProgress(900);
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      pb.setProgress(1000);
                      binding.shimmerViewContainer.stopShimmerAnimation();
                      Intent intent=new Intent(preparePlanning.this,createAccount.class);
                      finish();
                      startActivity(intent);
                      overridePendingTransition(R.anim.fade_2,R.anim.fade);
                  }
              },1500);
          }
      },6500);
    }
    @Override
    public void onBackPressed() {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}