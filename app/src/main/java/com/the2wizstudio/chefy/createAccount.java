package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;

import com.the2wizstudio.chefy.databinding.ActivityCreateAccountBinding;

public class createAccount extends AppCompatActivity {
    ActivityCreateAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        viewFunc();
        ManageUI();
    }

    private void ManageUI() {
        binding.pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        binding.pass.setTransformationMethod(new MyPasswordTransformationMethod());
        Typeface font = ResourcesCompat.getFont(this, R.font.montserrat);
        Typeface font2 = ResourcesCompat.getFont(this, R.font.montserrat_medium);
        SpannableStringBuilder SS = new SpannableStringBuilder("By continuing, you agree to the\n");
        SpannableStringBuilder SS2 = new SpannableStringBuilder(" Terms of Services");
        SpannableStringBuilder SS3 = new SpannableStringBuilder(" & Privacy Policy");
        SS.append(SS2.toString()+SS3.toString());
        SS.setSpan (new CustomTypefaceSpan("", font), 0, 32, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SS.setSpan(new ForegroundColorSpan(Color.parseColor("#0A2533")), 33, SS.toString().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        SS.setSpan (new CustomTypefaceSpan("", font2), 30, SS.toString().length(),Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        binding.termspolicy.setText(SS);
    }

    private void viewFunc() {

        binding.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.contButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(createAccount.this,enterOTP.class);
                Bundle bundle=new Bundle();
                bundle.putString("action","createAccount");
                intent.putExtras(bundle);
                startActivity(intent);
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

class CustomTypefaceSpan extends TypefaceSpan {

    private final Typeface newType;

    public CustomTypefaceSpan(String family, Typeface type) {
        super(family);
        newType = type;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface tf) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
}