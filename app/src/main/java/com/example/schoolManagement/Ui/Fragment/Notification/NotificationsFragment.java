package com.example.schoolManagement.Ui.Fragment.Notification;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.schoolManagement.R;


public class NotificationsFragment extends Fragment implements View.OnClickListener {
    private View mview;
    private Context mctx;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mview == null) {
            mctx = getActivity();
            // Inflate the layout for this fragment
            mview = inflater.inflate(R.layout.fragment_notifications, container, false);
        }
        return mview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bindView();
        viewModelSetup();
        viewSetup();
    }

    private void bindView() {


    }

    private void viewModelSetup() {

    }

    private void viewSetup() {

//        submit_btn.setOnClickListener(this);

//        model=new NotificationModel();
//
//        firebaseDatabase=FirebaseDatabase.getInstance();
//        databaseReference=firebaseDatabase.getReference().child("notification");

//        notificationData();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.submit_btn:
//
//                String notification=txt_notification.getText().toString();
//
//                if(notification.isEmpty()){
//
//                    Toast.makeText(mctx, "Please Write something", Toast.LENGTH_LONG).show();
//                }else {
//
//                    model.setNotficationtxt(txt_notification.getText().toString());
//
//                    databaseReference.child(String.valueOf(id+1)).setValue(model);
//                }
//                sendNotifications();

//                txt_notification.setText("");
//                Toast.makeText(mctx, "send Notification suessfully", Toast.LENGTH_LONG).show();

                break;
        }

    }

//    public void notificationData(){
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if(snapshot.exists()){
//
//                    id=(int)snapshot.getChildrenCount();
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                String notification=txt_notification.getText().toString();
//
//                if(notification.isEmpty()){
//
//                    Toast.makeText(mctx, "Please Write something", Toast.LENGTH_LONG).show();
//                }else {
//
////                    sendNotifications();
//                }
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }


//    public void sendNotifications(){
//
//        String name= txt_notification.getText().toString();
//        String message="Thank You "+name +" for using our App";
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//
//            NotificationChannel notificationChannel = new NotificationChannel("n", "n", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager notificationManager= mctx.getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(notificationChannel);
//
//
//        }
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder builder= new NotificationCompat.Builder(mctx,"n")
//                .setContentText("School Management Sysytem")
//                .setSmallIcon(R.drawable.ic_notification)
//                .setAutoCancel(true)
//                .setContentText(message)
//                .setSound(defaultSoundUri);
//
//
//        NotificationManagerCompat managerCompat= NotificationManagerCompat.from(mctx);
//        managerCompat.notify(999,builder.build());
//
//        Toast.makeText(mctx, "notification send sucessfully", Toast.LENGTH_SHORT).show();
//        txt_notification.setText("");
//
//    }
}