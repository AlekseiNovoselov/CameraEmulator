package com.example.aleksei.cameraemulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button mCameraButton;
    ImageView mImageBackGround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCameraButton = (Button) findViewById(R.id.camera_button);
        mImageBackGround = (ImageView) findViewById(R.id.image_view);
        mImageBackGround.setScaleType(ImageView.ScaleType.FIT_XY);

        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation myFadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tween);
                mImageBackGround.startAnimation(myFadeInAnimation);
            }
        });
    }
}
