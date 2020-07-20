package com.muneiah.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText userinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userinput=findViewById(R.id.et_url);

    }

    public void showWebPage(View view) {
        String inputUrl=userinput.getText().toString();
        Uri u=Uri.parse("https://www."+inputUrl+".in");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}
