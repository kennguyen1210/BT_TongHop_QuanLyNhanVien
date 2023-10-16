package business.util;

import java.time.LocalDate;

public class FormatTime {
    public static String formatTime(LocalDate date){
        String year = String.valueOf(date.getYear());
        String month = String.valueOf(date.getMonthValue());
        String day = String.valueOf(date.getDayOfMonth());
        return day+"/"+month +"/"+year;
    }

}
