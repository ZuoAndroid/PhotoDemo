package com.zwb.photodemo.Utils;

import android.content.Context;

import com.lidroid.xutils.DbUtils;

/**
 * Created by ZuoWenBin on 2015/7/22 0022.
 * Email: zuoandroid@gmail.com
 */
public class DbHepler {
    public static DbUtils utils;

    public static void init(Context context){
        utils = DbUtils.create(context);
        utils.configAllowTransaction(true);
        utils.configDebug(true);
    }

    public static DbUtils getUtils() {
        return utils;
    }
}
