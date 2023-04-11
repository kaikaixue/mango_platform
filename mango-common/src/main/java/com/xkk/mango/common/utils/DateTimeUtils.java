package com.xkk.mango.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getDateTime() {
        return getDateTime(new Date());
    }

    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }
}
