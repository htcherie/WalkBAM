package com.walkBAM.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateSubUtil {
    public static String getDate(Object date, int amount) {
        Date dd = null;
        if (date instanceof Date){
            dd = (Date)date;
        }
        if (date instanceof String){
            String d = date.toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                //使用SimpleDateFormat的parse()方法生成Date
                dd = sdf.parse(d);
                //打印Date

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dd);
        calendar.add(calendar.DATE, amount);//把日期往后增加一天.整数往后推,负数往前移动
        dd = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dd);

        return dateString;
    }
}
