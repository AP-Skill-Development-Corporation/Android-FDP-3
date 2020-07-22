package com.muneiah.myrecycerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
RecyclerView rec;
int images[];
String titles[];
String subtitles[];
MyAdpter adpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=findViewById(R.id.recycler);
        titles=getResources().getStringArray(R.array.clg_names);
        subtitles=getResources().getStringArray(R.array.subtitle);
        images=new int[]{R.drawable.muneiah,
        R.drawable.aits_android,
        R.drawable.aits_gihub,
        R.drawable.android_aits,
        R.drawable.android_team,
        R.drawable.android_ksrm,
        R.drawable.cbit_py,
        R.drawable.cbit_proddatur,
        R.drawable.vignas_guntur,
        R.drawable.dlp_svne};
        adpter=new MyAdpter(this,images,titles,subtitles);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adpter);

    }
}
