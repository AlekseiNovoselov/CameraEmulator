package com.example.aleksei.cameraemulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public final String CAMERA_NEW_IMAGE_INTENT = "com.example.aleksei.NEW_IMAGE";

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
                sendBroadCast();
            }
        });
    }

    private void sendBroadCast() {
        Log.e(LOG_TAG, "sendBroadCast");
        Intent intent = new Intent();
        intent.setAction(CAMERA_NEW_IMAGE_INTENT);
        sendBroadcast(intent);
    }
}
