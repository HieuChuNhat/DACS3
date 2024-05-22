package com.example.fastfood.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.fastfood.Domain.Foods;
import com.example.fastfood.Helper.ManagmentCart;
import com.example.fastfood.R;
import com.example.fastfood.databinding.ActivityDetailBinding;
import com.example.fastfood.databinding.ActivityIntrolBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private Foods object;
    private int num=1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();

    }

    private void setVariable() {
    managmentCart=new ManagmentCart(this);

    binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(this)
                .load(object.getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(60))
                .into(binding.pic);

        binding.priceTxt.setText("$"+object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.decriptionTxt.setText(object.getDescription());
        binding.ratingTxt.setText(object.getStar()+"Rating");
        binding.ratingBar3.setRating((float) object.getStar());
        binding.totalTxt.setText((num*object.getPrice()+"$"));

        binding.congCartBtn.setOnClickListener(v -> {
            num=num+1;
            binding.numberItemTxt.setText(num+"");
            binding.totalTxt.setText((num*object.getPrice()+"$"));
        });

        binding.truCartBtn.setOnClickListener(v -> {
            if (num>1){
                num=num-1;
                binding.congCartBtn.setText(num+"");
                binding.totalTxt.setText((num*object.getPrice()+"$"));
            }
        });
        binding.addBtn.setOnClickListener(v -> {
            object.setNumberInCart(num);
            managmentCart.insertFood(object);
        });


    }

    private void getIntentExtra() {
        object= (Foods) getIntent().getSerializableExtra("object");
    }
}