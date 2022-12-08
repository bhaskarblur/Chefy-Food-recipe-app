package com.the2wizstudio.chefy;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.the2wizstudio.chefy.databinding.FragmentOnboardingFragBinding;

import java.util.zip.Inflater;


public class onboarding_frag extends Fragment {
    FragmentOnboardingFragBinding onbfrag;

    public Integer getCurrentPos() {
        return currentPos;
    }

    private Integer currentPos=1;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onbfrag=FragmentOnboardingFragBinding.inflate(inflater,container,false);

        switch (currentPos){
            case 1:
                onbfrag.onbimg.setImageResource(R.drawable.ic_illustration1);
                onbfrag.onbheadtxt.setText("All recipe you need");
                onbfrag.onbsubtxt.setText("5000+ healthy recipes made by people for your healthy life");


                break;
            case 2:
                onbfrag.onbimg.setImageResource(R.drawable.ic_illustration2);
                onbfrag.onbheadtxt.setText("Order ingredients");
                onbfrag.onbsubtxt.setText("Order the ingredients you need quickly with a fast process");


                break;
            case 3:
                onbfrag.onbimg.setImageResource(R.drawable.ic_illustration3);
                onbfrag.onbheadtxt.setText("Let's cooking");
                onbfrag.onbsubtxt.setText("Cooking based on the food recipes you find and food you love");
                break;
        }
        return onbfrag.getRoot();
    }

    public void setCurrentPos(Integer currentPos) {
        this.currentPos = currentPos;
    }
}
