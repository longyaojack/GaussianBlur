package com.vansuita.gaussianblur.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.vansuita.gaussianblur.GaussianBlur;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivCat = (ImageView) findViewById(R.id.cat);
        ImageView ivWolf = (ImageView) findViewById(R.id.wolf);
        ImageView ivStone = (ImageView) findViewById(R.id.stone);

        //Synchronous
        Bitmap catBitmap = GaussianBlur.with(this).radius(25).noScaleDown(true).render(R.mipmap.cat);
        ivCat.setImageBitmap(catBitmap);

        //Synchronous - Only scaleDown
        Bitmap wolfBitmap = GaussianBlur.with(this).maxSixe(50).scaleDown(R.mipmap.wolf);
        ivWolf.setImageBitmap(wolfBitmap);

        //Asynchronous
        GaussianBlur.with(this).maxSixe(400).radius(25).put(R.mipmap.stone, ivStone);
    }
}
