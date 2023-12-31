package com.the2wizstudio.chefy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class newOnBoardingAdapter extends RecyclerView.Adapter<newOnBoardingAdapter.ViewHolder> {

    ArrayList<onBoardingItem> onBoardingItemArrayList=new ArrayList<>();
    Context context;
    ViewPager2 viewPager;
    public newOnBoardingAdapter(Context context,ViewPager2 viewPager) {
        this.context=context;
        this.viewPager=viewPager;
        onBoardingItemArrayList.add(new onBoardingItem(R.drawable.ic_illustration1,"Discover all the best recipes you needed",
                "5000+ healthy recipes made by people for your healthy life"));
        onBoardingItemArrayList.add(new onBoardingItem(R.drawable.ic_illustration2,"Order directly the ingredients",
                "Order the ingredients you need quickly with a fast process"));
        onBoardingItemArrayList.add(new onBoardingItem(R.drawable.ic_illustration3,"Let's cook with the recipe you found",
                "Cooking based on the food recipes you find and food you love"));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.fragment_onboarding_frag,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        onBoardingItem onBoardingItem=onBoardingItemArrayList.get(position);
        holder.illustration.setImageResource(onBoardingItem.getImageId());
        holder.headText.setText(onBoardingItem.getHeadText());
        holder.subText.setText(onBoardingItem.getSubText());

      //  viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
      //      @Override
      //      public void onPageSelected(int position) {
      //          super.onPageSelected(position);
       //         if(position==0) {
                //    holder.animView.setAnimation(R.raw.onboarding1);
        //        }
      //          else if(position==1) {
       //             holder.animView.setAnimation(R.raw.onboarding2);
      //          }
       //         else if(position==2) {
       //             holder.animView.setAnimation(R.raw.onboarding3);
       //         }
     //           holder.animView.resumeAnimation();
        //    }
    //    });

        holder.skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   SharedPreferences sharedPreferences= context.getSharedPreferences("onbdone",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("onbdone","yes");
                    editor.commit();
                context.startActivity(new Intent(context,loginAsk.class));
                ((Activity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView illustration;
        TextView headText;
        TextView subText;
        TextView skipText;
        LottieAnimationView animView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            illustration=itemView.findViewById(R.id.onbimg);
            headText=itemView.findViewById(R.id.onbheadtxt);
            subText=itemView.findViewById(R.id.onbsubtxt);
            skipText=itemView.findViewById(R.id.skipText);
            animView=itemView.findViewById(R.id.onboardingLottie);
        }
    }
}


