package com.sparrowpaul.splashrotation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends Activity {
    int splashTimer = 3000;
    private ImageView imageView;
    boolean dirY = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.imageViewID);

        rotateImage();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTimer);

    }

    public void rotateImage(){
            ObjectAnimator flip = ObjectAnimator.ofFloat(imageView, "rotationY", 0f, 180f);
            flip.setDuration(3000);
            flip.start();
    }
}
