package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Apple on 2017/5/25.
 */
public class MyUtil {

    static public String getNowDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

}
