package com.example.fastfood.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fastfood.R;
import com.example.fastfood.databinding.ActivityIntrolBinding;
import com.example.fastfood.databinding.ActivityMainBinding;

public class IntrolActivity extends BaseActivity {
    ActivityIntrolBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityIntrolBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.goBtn.setOnClickListener(v -> {
            if (mAuth.getCurrentUser() != null){
                startActivity(new Intent(IntrolActivity.this, MainActivity.class));
            }else {
                startActivity(new Intent(IntrolActivity.this, LoginActivity.class));
            }
        });
    }
}