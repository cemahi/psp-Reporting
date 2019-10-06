package clearkode.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String MYSQL_DATE_FORMAT = "yyyy-MM-dd";

    public static String genericFormatDate(String pattern, Date date) {
        return new SimpleDateFormat(pattern).format(date);
    }

}
