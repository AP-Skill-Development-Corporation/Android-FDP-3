package com.muneiah.imagebuttionsandimagesviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView myimage;
ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myimage=findViewById(R.id.img);
        ib=findViewById(R.id.img_btn);
        //ImageView Click handleing
        myimage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                myimage.setImageResource(R.drawable.image_actions);
            }
        });
        //Image Buttons
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib.setImageResource(R.drawable.image_actions);
            }
        });
    }
}
