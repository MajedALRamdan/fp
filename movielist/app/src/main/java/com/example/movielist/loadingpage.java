package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.DoubleBounce;

public class loadingpage extends AppCompatActivity {
    public static int SPLASH_TIME_OUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingpage2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent l = new Intent(loadingpage.this,MainActivity.class);
                startActivity(l);
                finish();
            }
        },SPLASH_TIME_OUT =3000);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        Sprite ChasingDots = new ChasingDots();
        progressBar.setIndeterminateDrawable(ChasingDots);
    }
}