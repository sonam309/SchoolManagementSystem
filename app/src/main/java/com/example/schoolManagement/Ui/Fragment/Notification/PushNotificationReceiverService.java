package com.example.schoolManagement.Ui.Fragment.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.schoolManagement.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static com.example.schoolManagement.Ui.Fragment.Notification.ChannelId.FCM_CHANNEL_ID;

public class PushNotificationReceiverService extends FirebaseMessagingService {

    private static final String TAG = "notificationDebug";


    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.e("token",s);

        Log.d(TAG,"onNewToken");

    }


//    @Override
//    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//
//        Log.d(TAG,"onMessageReceived" + remoteMessage.getFrom());
//
//        if (remoteMessage.getNotification() != null) {
//
//            String title = remoteMessage.getNotification().getTitle();
//            String body = remoteMessage.getNotification().getBody();
//
//            Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            Notification notification = new NotificationCompat.Builder(this,FCM_CHANNEL_ID)
//                    .setSmallIcon(R.drawable.app_icon)
//                    .setContentTitle(title)
//                    .setContentText(body)
//                    .setColor(Color.BLACK)
//                    .setSound(defaultSoundUri)
//                    .build();
//
//            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//            manager.notify(0,notification);
//
//
//        }
//
//        if(remoteMessage.getData().size()>0){
//
//            Log.d(TAG,"onMessageReceived: Data"+ remoteMessage.getData().toString());
//        }
//    }
//
//
//
//    @Override
//    public void onDeletedMessages() {
//        super.onDeletedMessages();
//
//        Log.d(TAG,"onDeletedMessages");
//
//    }
}
