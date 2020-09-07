package com.example.schoolManagement.utility;

import androidx.annotation.NonNull;

import com.example.schoolManagement.prefrenceShared;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class utils {


    public static String getStringFromDate(@NonNull Date date, @NonNull String formatString) {
        if (date == null)
            return "";
        SimpleDateFormat format = new SimpleDateFormat(formatString, Locale.US);
        return format.format(date);
    }

    public static String getDeviceToken(){

        return prefrenceShared.getInstance().getPreferenceData().getValueFromKey(KeyClass.PRE_FCM_TOKEN);

    }

}
