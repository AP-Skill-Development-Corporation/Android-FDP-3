package com.muneiah.notificationworkmanger;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static com.muneiah.notificationworkmanger.MainActivity.CHANNEL_ID;

public class SecondWork extends Worker {
    NotificationManager manager;
    public SecondWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        manager= (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        showNotification();
        createChannel();
        return Result.success();
    }
    private void createChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"apssdc",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            manager.createNotificationChannel(nc);
        }
    }
    public void showNotification() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setContentTitle("This Is MY NOTIFICATION");
        builder.setContentText("Hello This is my OWN Notification..!");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        // builder.setContentIntent(pi);
        manager.notify(123,builder.build());




    }
}
