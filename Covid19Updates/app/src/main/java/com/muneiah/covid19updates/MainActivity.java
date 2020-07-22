package com.muneiah.covid19updates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView deaths,date,recovered,active,conformed,counry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deaths=findViewById(R.id.tv_Deaths);
        date=findViewById(R.id.date_tv);
        recovered=findViewById(R.id.tv_Recovered);
        active=findViewById(R.id.tv_Active);
        conformed=findViewById(R.id.tv_confirmed);
        counry=findViewById(R.id.country);
    }
}
