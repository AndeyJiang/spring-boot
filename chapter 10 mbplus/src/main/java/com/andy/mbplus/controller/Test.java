package com.andy.mbplus.controller;


import com.andy.mbplus.utils.DayCompareUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

    public static void  main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //入职日期是1月28日
        int  calMonth = DayCompareUtil.monthCompare(sdf.parse("2020-02-03"),sdf.parse("2020-02-04"));
        System.out.println(calMonth);

   //     int initFlag=getMonthSpace("2020-01-28","2020-05-01");

   //     System.out.println(initFlag);
    }

    public static int getMonthSpace(String date1, String date2) throws ParseException {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        Integer yearSpace = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        if(yearSpace > 0){
            Integer month2 = c2.get(Calendar.MONTH);
            Integer month1 = c1.get(Calendar.MONTH);
            result = month2 + (yearSpace * 12) - month1;
        }else if(yearSpace == 0){
            result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        }else if(yearSpace < 0){
            Integer month2 = c2.get(Calendar.MONTH);
            Integer month1 = c1.get(Calendar.MONTH);
            result = -(month1 + (Math.abs(yearSpace) * 12) - month2);
        }
        return result;
    }
}
