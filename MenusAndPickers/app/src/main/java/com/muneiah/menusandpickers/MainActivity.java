package com.muneiah.menusandpickers;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int day,month,year,hour,minute;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
    }
    //for configuring the menus in our screen/activity


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu resourse file
        getMenuInflater().inflate(R.menu.option_menus,menu);
        return super.onCreateOptionsMenu(menu);
    }
//items click listener
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ap:
                Toast.makeText(this, "You clicked Ap", Toast.LENGTH_SHORT).show();
            break;
            case R.id.alert:
                showAlert();
                Toast.makeText(this, "Alert dialog clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this, "Share item Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //for Showing Alert Dilog
    public void showAlert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //Alert title
        //alert Message
        //Icon
        builder.setTitle("Alert..!");
        builder.setMessage("Do want close the app ..!");
        builder.setIcon(R.drawable.ic_add_alert_black_24dp);
        //positive button
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showDate(View view) {
        Calendar c=Calendar.getInstance();
        day=c.get(Calendar.DAY_OF_MONTH);
        month=c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);

        DatePickerDialog dp=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date=year+"-"+(month+1)+"-"+dayOfMonth;
                tv.setText(date);
            }
        },year,month,day);
        dp.show();

    }

    public void showTime(View view) {
        Calendar c=Calendar.getInstance();
        hour=c.get(Calendar.HOUR_OF_DAY);
        minute=c.get(Calendar.MINUTE);

        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time=hourOfDay+"-"+minute;
                tv.setText(time);
            }
        },hour,minute,false);
        tpd.show();
    }
}
