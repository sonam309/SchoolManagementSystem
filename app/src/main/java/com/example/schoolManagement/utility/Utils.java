package com.example.schoolManagement.utility;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {


    public static String getStringFromDate(@NonNull Date date, @NonNull String formatString) {
        if (date == null)
            return "";
        SimpleDateFormat format = new SimpleDateFormat(formatString, Locale.US);
        return format.format(date);
    }

    public static String getDeviceToken(){

        return prefrenceShared.getInstance().getPreferenceData().getValueFromKey(KeyClass.PRE_FCM_TOKEN);

    }

    public static void loadImage(ImageView imageView, Context context, String profilePic) {
        Glide.with(context).load(KeyClass.BASE_URL.substring(0,KeyClass.BASE_URL.length()-1)+profilePic).into(imageView);
    }
}
