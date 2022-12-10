package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.the2wizstudio.chefy.Adapters.interestAdapter;
import com.the2wizstudio.chefy.Models.interestModel;
import com.the2wizstudio.chefy.databinding.ActivitySelectInterestBinding;

import java.util.ArrayList;

public class selectInterest extends AppCompatActivity {
    ActivitySelectInterestBinding binding;
    interestAdapter adapter;
    private ArrayList<interestModel> interestList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySelectInterestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        viewFunc();
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<interestModel> list=new ArrayList<>();
        list.add(new interestModel("https://img.freepik.com/free-photo/flat-lay-batch-cooking-composition_23-2148765597.jpg?w=2000","Discover Recipes"));
        list.add(new interestModel("https://upload.wikimedia.org/wikipedia/commons/6/6d/Good_Food_Display_-_NCI_Visuals_Online.jpg","Healthy Living"));
        list.add(new interestModel("https://static.toiimg.com/photo/72023714.cms","Easy Fit"));
        list.add(new interestModel("https://media.istockphoto.com/id/1295633127/photo/grilled-chicken-meat-and-fresh-vegetable-salad-of-tomato-avocado-lettuce-and-spinach-healthy.jpg?s=612x612&w=0&k=20&c=Qa3tiqUCO4VpVMQDXLXG47znCmHr_ZIdoynViJ8kW0E=","Daily recipe"));
        list.add(new interestModel("https://burst.shopifycdn.com/photos/flatlay-iron-skillet-with-meat-and-other-food.jpg?width=1200&format=pjpg&exif=1&iptc=1","Live Cooking"));
        list.add(new interestModel("https://media.istockphoto.com/id/1295633127/photo/grilled-chicken-meat-and-fresh-vegetable-salad-of-tomato-avocado-lettuce-and-spinach-healthy.jpg?s=612x612&w=0&k=20&c=Qa3tiqUCO4VpVMQDXLXG47znCmHr_ZIdoynViJ8kW0E=","Breakfast"));
        list.add(new interestModel("https://burst.shopifycdn.com/photos/flatlay-iron-skillet-with-meat-and-other-food.jpg?width=1200&format=pjpg&exif=1&iptc=1","Lunch"));
        list.add(new interestModel("https://img.freepik.com/free-photo/flat-lay-batch-cooking-composition_23-2148765597.jpg?w=2000","Dinner"));
        adapter=new interestAdapter(list,this);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.CENTER);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        binding.interestRecycleview.setLayoutManager(layoutManager);
       // binding.interestRecycleview.setLayoutManager(new StaggeredGridLayoutManager(5,
       //         StaggeredGridLayoutManager.HORIZONTAL));
        binding.interestRecycleview.setAdapter(adapter);
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this,
                R.anim.fade_anim);
        binding.interestRecycleview.setLayoutAnimation(controller);
        binding.interestRecycleview.scheduleLayoutAnimation();
        adapter.setClickListener(new interestAdapter.clickListener() {
            @Override
            public void onClick(interestModel interestModel) {
                if(interestList.contains(interestModel)) {
                    interestList.remove(interestModel);
                }
                else {
                    interestList.add(interestModel);
                }
                if(interestList.size()<1) {
                    binding.contButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                    binding.contButton.setAlpha(0.5F);
                }
                else {
                    binding.contButton.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                    binding.contButton.setAlpha(1F);
                }
            }
        });

    }

    private void viewFunc() {
        if(interestList.size()<1) {
            binding.contButton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            binding.contButton.setAlpha(0.5F);
        }
        binding.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(selectInterest.this,preparePlanning.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade_2,R.anim.fade);
            }
        });

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}