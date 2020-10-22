package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashActivity extends AppCompatActivity {

    TextView textViewNameSplash;
    CountDownTimer countDownTimerObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        init();
    }

    private void init() {

        textViewNameSplash = findViewById(R.id.textViewNameSplash);
        countDownTimerObject = new CountDownTimer(5000,5){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(5)
                        .playOn(findViewById(R.id.textViewNameSplash));

                Intent intentObject = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intentObject);
                finish();
            }
        }.start();
    }
}