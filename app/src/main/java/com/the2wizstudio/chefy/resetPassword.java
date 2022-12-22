package com.the2wizstudio.chefy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import com.the2wizstudio.chefy.databinding.ActivityResetPasswordBinding;

public class resetPassword extends AppCompatActivity {
    ActivityResetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityResetPasswordBinding.inflate(getLayoutInflater());
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
        binding.pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        binding.pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        binding.pass.setTransformationMethod(new MyPasswordTransformationMethod());
        binding.pass2.setTransformationMethod(new MyPasswordTransformationMethod());
        Typeface typeface = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            typeface = getResources().getFont(R.font.montserrat);
            binding.pass.setHint("Enter Password");
            binding.passField.setPlaceholderText(null);
            binding.pass2.setHint("Enter Password Again");
            binding.passField2.setPlaceholderText(null);
        }
        binding.pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(binding.pass.getText().toString().length()>5)
                {
                    binding.tickIcon.setColorFilter(ContextCompat.getColor(resetPassword.this, R.color.backgroundGreen));
                    binding.passField.setBoxStrokeColor(Color.parseColor("#333333"));
                    binding.passText.setText("Must be at least 6 characters.");
                    binding.passText.setTextColor(Color.parseColor("#333333"));
                }
               else if(binding.pass.getText().toString().length()<6) {
                    binding.passField.setBoxStrokeColor(Color.parseColor("#F03828"));
                    binding.passText.setText("Must be at least 6 characters.");
                    binding.passText.setTextColor(Color.parseColor("#F03828"));
                }
                else
                {
                    binding.tickIcon.setColorFilter(ContextCompat.getColor(resetPassword.this, R.color.tickDisabled));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.pass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!binding.pass.getText().toString().equals(binding.pass2.getText().toString()))
                {
                    binding.passField2.setBoxStrokeColor(Color.parseColor("#F03828"));
                    binding.passField.setBoxStrokeColor(Color.parseColor("#F03828"));
                    binding.passText.setText("Passwords don't match");
                    binding.passText.setTextColor(Color.parseColor("#F03828"));
                }
                else if(!binding.pass2.getText().toString().equals(null) && binding.pass.getText().toString().equals(binding.pass2.getText().toString())){
                    binding.passField2.setBoxStrokeColor(Color.parseColor("#333333"));
                    binding.passText.setText("Passwords match");
                    binding.passText.setTextColor(Color.parseColor("#333333"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                    if(binding.pass.getText().toString().length()<6) {
                        binding.passField.setBoxStrokeColor(Color.parseColor("#F03828"));
                        binding.passText.setText("Must be at least 6 characters.");
                        binding.passText.setTextColor(Color.parseColor("#F03828"));
                    }
                    else if(!binding.pass.getText().toString().equals(binding.pass2.getText().toString()))
                    {
                        binding.passField2.setBoxStrokeColor(Color.parseColor("#F03828"));
                        binding.passField.setBoxStrokeColor(Color.parseColor("#F03828"));
                        binding.passText.setText("Passwords don't match");
                        binding.passText.setTextColor(Color.parseColor("#F03828"));
                    }
                    else if(!binding.pass2.getText().toString().equals(null) && binding.pass.getText().toString().equals(binding.pass2.getText().toString())){
                        binding.passField.setBoxStrokeColor(Color.parseColor("#333333"));
                        binding.passText.setText("Passwords match");
                        binding.passText.setTextColor(Color.parseColor("#333333"));
                    }
                    else {
                        binding.passField.setBoxStrokeColor(Color.parseColor("#333333"));
                        binding.passText.setTextColor(Color.parseColor("#333333"));
                    }

            }
        });

        binding.pass2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                    if(binding.pass2.getText().toString().length()<6) {
                        binding.passField2.setBoxStrokeColor(Color.parseColor("#F03828"));
                    }
                   else if(!binding.pass.getText().toString().equals(binding.pass2.getText().toString()))
                    {
                        binding.passField2.setBoxStrokeColor(Color.parseColor("#F03828"));
                        binding.passField.setBoxStrokeColor(Color.parseColor("#F03828"));
                        binding.passText.setText("Passwords don't match");
                        binding.passText.setTextColor(Color.parseColor("#F03828"));
                    }
                    else if(!binding.pass.getText().toString().equals(null) && binding.pass.getText().toString().equals(binding.pass2.getText().toString())){
                        binding.passField2.setBoxStrokeColor(Color.parseColor("#333333"));
                        binding.passText.setText("Passwords match");
                        binding.passText.setTextColor(Color.parseColor("#333333"));
                    }
                    else {
                        binding.passField2.setBoxStrokeColor(Color.parseColor("#333333"));
                        binding.passText.setTextColor(Color.parseColor("#333333"));
                    }


            }
        });
        binding.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_2,R.anim.fade);
    }
}

;