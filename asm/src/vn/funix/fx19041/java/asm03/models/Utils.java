package vn.funix.fx19041.java.asm03.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String getDivider() {
        return "+---------+---------------------+--------+";
    }

    public static String getTitle() {
        return "BIEN LAI GIAO DICH";
    }

    public static String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return dateFormat.format(date);
    }
}
