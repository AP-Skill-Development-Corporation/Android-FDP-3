package com.muneiah.notificationworkmanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
/*NotificationManager manager;*/
public static final String CHANNEL_ID="muneiah.tellakula";

PendingIntent pi;
Intent intentObj;
OneTimeWorkRequest oneTimeWorkRequest;
PeriodicWorkRequest periodicWorkRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentObj=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,245,intentObj,PendingIntent.FLAG_UPDATE_CURRENT);
        /*manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);*/
        //createChannel();
        oneTimeWorkRequest=new OneTimeWorkRequest.Builder(FirstWok.class).build();
        periodicWorkRequest=new PeriodicWorkRequest.Builder(SecondWork.class,1, TimeUnit.MINUTES).build();
    }

  /*  private void createChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"apssdc",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            manager.createNotificationChannel(nc);
        }
    }
*/
    /*
    * for design of notification we reqvire 3 components
    *   Icon
    *   Title
    *   Text
    *
    * for creation notification we reqvired two classes
    *   1.NotificationManager:For Managing the all notification
    *   2.NotificationCompact:To design or creation using this
    * Api level 26:version OREO ..We need to reqvired add a NotificationChannel
    * */
    /*
    * Pending Intent
    * Intent intentObj=new Intent(this,DestinationClass.class)
    *PendingIntent pi=PendingIntent.getActivty(this,12,intentObj,PendingIntent.FLAGUPDATE)
    * */

    public void showNotification(View view) {
        //WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
        /*WorkManager.getInstance(this).enqueueUniquePeriodicWork("muni", ExistingPeriodicWorkPolicy.KEEP,
                periodicWorkRequest);*/
        WorkManager.getInstance(this).enqueue(periodicWorkRequest);
        /*NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This Is MY NOTIFICATION");
        builder.setContentText("Hello This is my OWN Notification..!");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        manager.notify(123,builder.build());*/




    }
}
