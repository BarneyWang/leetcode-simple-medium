package me.heng.phone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcutorData {

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d1 = sdf.parse("2012-02-02 20:20:20");
    Date d2 = sdf.parse("2012-02-02 23:10:10");
    System.out.print(daysBetween(d1, d2));
  }

  public static int daysBetween(Date smdate, Date bdate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    smdate = sdf.parse(sdf.format(smdate));
    bdate = sdf.parse(sdf.format(bdate));
    Calendar cal = Calendar.getInstance();
    cal.setTime(smdate);
    long time1 = cal.getTimeInMillis();
    cal.setTime(bdate);
    long time2 = cal.getTimeInMillis();
    long between_days = (time2 - time1) / (1000 * 3600 * 24);

    return Integer.parseInt(String.valueOf(between_days));
  }

}