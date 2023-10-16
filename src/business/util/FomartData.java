package business.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FomartData {
    public static LocalDate formatDate(String date){
        DateTimeFormatter s = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date,s);
    }
}
