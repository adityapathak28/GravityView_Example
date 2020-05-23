package com.sneakytechie.gravityviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import co.gofynd.gravityview.GravityView;

public class MainActivity extends AppCompatActivity {

    GravityView gravityView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        gravityView=GravityView.getInstance(this);
        if(!gravityView.deviceSupported()){
            // show the error / imageView
        }
        else
        {
            gravityView.setImage(imageView,R.drawable.image).center();
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        gravityView.unRegisterListener();
    }
    @Override

    protected void onResume(){
        super.onResume();
        gravityView.registerListener();
    }
}
