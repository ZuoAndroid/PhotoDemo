package com.zwb.photodemo.Utils;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

public class BitmapHelper {
    public static BitmapUtils utils;


    public static void init(Context context) {
        utils = new BitmapUtils(context);
        utils.configDefaultBitmapMaxSize(300,300);
    }

    public static BitmapUtils getUtils() {
        return utils;
    }
}
