package com.mac.picoholic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
;
import com.mac.picoholic.R;

public class Splash_Screen_Activity extends AppCompatActivity {


    private static int time = 2000;
    private ImageView Splash_image;
    private Animation fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        Splash_image = findViewById(R.id.splash_image);

        fade = AnimationUtils.loadAnimation(Splash_Screen_Activity.this, R.anim.fade_in);
        Splash_image.setAnimation(fade);
        getSplash();

    }

    private void getSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, time);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}