package com.andy.mbplus.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 2020-05-21
 * @author  jiangBin
 * 获取月差、当前月份首日、尾日及15日前后的工具类
 */
public  class DayCompareUtil {

    /**获取间隔month 按月为单位
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int monthCompare(Date fromDate,Date toDate){
        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);
        //只要年月
        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        System.out.println("fromYear:"+fromYear+"   "+"fromMonth:"+fromMonth);
        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        System.out.println("toYear:"+toYear+"   "+"toMonth:"+toMonth);
        //int year = toYear  -  fromYear;
        int month = toYear *  12  + toMonth  -  (fromYear  *  12  +  fromMonth);
        //int day = (int) ((to.getTimeInMillis()  -  from.getTimeInMillis())  /  (24  *  3600  *  1000));
        from.clear();
        to.clear();
        return  month+1;
    }


    /**
     * 获取当月下月的第一天
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfNextMonth(String dateStr,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.add(Calendar.MONTH, 1);
            return sdf.format(calendar.getTime());

    }

    /**
     * 获取当前月的第一天
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfGivenMonth(String dateStr,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.add(Calendar.MONTH, 0);
            return sdf.format(calendar.getTime());

    }

    /**
     * 获取当月份的最后一天
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static String getLastDayOfGivenMonth(String dateStr,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(dateStr));
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return sdf.format(calendar.getTime());
    }

    /**
     * 判断指定日期是15之前还是15日之后规则
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static boolean getBeforeOrAfter15(String dateStr,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String exactDate=dateStr.substring(8);
        if (Integer.parseInt(exactDate) >=15)
                return true;
        else
                return  false;

    }

    /**
     * 定义一个Map，来获取大湾区Grade Order
     * @param grade
     * @return
     */
    public static int getGradeOrder(String grade){
        Map<String, Integer> gradeOrder=new HashMap<>();
        gradeOrder.put("00",0);
        gradeOrder.put("GHS",1);
        gradeOrder.put("GJGHS",2);
        gradeOrder.put("ZSGHS",3);
        gradeOrder.put("SXGHS",4);
        gradeOrder.put("JL",5);
        gradeOrder.put("ZJ",6);
        gradeOrder.put("LHCSR",7);
        gradeOrder.put("CSR",8);

        return gradeOrder.get(grade);

    }
}
