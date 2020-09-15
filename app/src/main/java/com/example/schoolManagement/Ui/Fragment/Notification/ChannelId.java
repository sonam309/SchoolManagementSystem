package com.example.schoolManagement.Ui.Fragment.Notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class ChannelId extends Application {

    public static final String FCM_CHANNEL_ID = "Fcm channel id";

    @Override
    public void onCreate() {
        super.onCreate();

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(FCM_CHANNEL_ID, "Fcm channel", NotificationManager.IMPORTANCE_DEFAULT);


            NotificationManager manager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }


}
