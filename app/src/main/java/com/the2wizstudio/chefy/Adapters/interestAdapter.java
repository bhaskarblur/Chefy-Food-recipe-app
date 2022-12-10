package com.the2wizstudio.chefy.Adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.the2wizstudio.chefy.Models.interestModel;
import com.the2wizstudio.chefy.R;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class interestAdapter extends RecyclerView.Adapter<interestAdapter.viewHolder> {

    private ArrayList<interestModel> list=new ArrayList<>();
    private ArrayList<interestModel> selectedList=new ArrayList<>();
   private clickListener clickListener;
    private Context context;

    public ArrayList<interestModel> getSelectedList() {
        return selectedList;
    }

    public interestAdapter(ArrayList<interestModel> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.interest_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final int radius = 20;
        final int margin = 5;
        final Transformation transformation = new RoundedCornersTransformation(radius, margin);
        Picasso.get().load(list.get(position).getImage()).
                resize(700,700).
                centerCrop().into(holder.image);
        holder.name.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private View layout;
        private ImageView image;
        private ImageView selector;
        private TextView name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.interest_layout);
            image=itemView.findViewById(R.id.interest_image);
            selector=itemView.findViewById(R.id.selected_image);
            name=itemView.findViewById(R.id.interest_name);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(getAdapterPosition()!=RecyclerView.NO_POSITION) {
                        setAlphaAnimation(layout);
                        if(selectedList.contains(list.get(getAdapterPosition()))) {
                            selector.setVisibility(View.INVISIBLE);
                            layout.setBackgroundResource(R.drawable.interest_card_notselected);
                            selectedList.remove(list.get(getAdapterPosition()));
                        }
                        else {
                            selector.setVisibility(View.VISIBLE);
                            layout.setBackgroundResource(R.drawable.interest_card_selected);
                            selectedList.add(list.get(getAdapterPosition()));
                        }
                        clickListener.onClick(list.get(getAdapterPosition()));
                    }
                }
            });

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getAdapterPosition()!=RecyclerView.NO_POSITION) {
                        setAlphaAnimation(layout);
                        if(selectedList.contains(list.get(getAdapterPosition()))) {
                            selector.setVisibility(View.INVISIBLE);
                            layout.setBackgroundResource(R.drawable.interest_card_notselected);
                            selectedList.remove(list.get(getAdapterPosition()));
                        }
                        else {
                            selector.setVisibility(View.VISIBLE);
                            layout.setBackgroundResource(R.drawable.interest_card_selected);
                            selectedList.add(list.get(getAdapterPosition()));

                        }
                        clickListener.onClick(list.get(getAdapterPosition()));
                    }
                }
            });

            selector.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getAdapterPosition()!=RecyclerView.NO_POSITION) {
                        setAlphaAnimation(layout);
                        if(selectedList.contains(list.get(getAdapterPosition()))) {
                            selector.setVisibility(View.INVISIBLE);
                            layout.setBackgroundResource(R.drawable.interest_card_notselected);
                            selectedList.remove(list.get(getAdapterPosition()));
                        }
                        else {
                            selector.setVisibility(View.VISIBLE);
                            layout.setBackgroundResource(R.drawable.interest_card_selected);
                            selectedList.add(list.get(getAdapterPosition()));
                        }
                        clickListener.onClick(list.get(getAdapterPosition()));
                    }
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

    }

    public interface clickListener {
        void onClick(interestModel interestModel);
    }

    public void setClickListener(clickListener clickListener){
        this. clickListener=clickListener;
    }
}
