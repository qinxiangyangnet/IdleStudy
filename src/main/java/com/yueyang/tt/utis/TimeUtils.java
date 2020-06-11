package com.yueyang.tt.utis;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeUtils {

    private static final DateTimeFormatter FULL_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME_DAY = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final SimpleDateFormat SIMPLE_DATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final String DEFAULT = "0000-00-00 00:00:00";
    private static final String DEFAULT_DAY = "0000/00/00";
    private static final LocalDateTime DEFAULTTIME = LocalDateTime.now();

    private TimeUtils() {
    }

    public static String format(LocalDateTime ldt) {
        return ldt != null ? ldt.format(FULL_TIME) : DEFAULT;
    }

    public static String formatLocalDateTime(LocalDateTime ldt) {
        return ldt != null ? ldt.format(DATE_TIME) : DEFAULT;
    }

    public static String formatDateTime(LocalDateTime ldt) {
        return ldt != null ? ldt.format(DATE) : DEFAULT;
    }

    public static String formatDateTimeDay(LocalDateTime ldt) {
        return ldt != null ? ldt.format(DATE_TIME_DAY) : DEFAULT_DAY;
    }

    public static String formatDate(Date date) {
        if (null == date) {
            return null;
        }
        return SIMPLE_DATE.format(date);
    }

    public static LocalDateTime parseTime(String time) {
        return StringUtils.isBlank(time) ? DEFAULTTIME : LocalDateTime.parse(time, FULL_TIME);
    }

    public static LocalDateTime parseTimestamp(long ts) {
        return LocalDateTime.ofInstant(new Timestamp(ts).toInstant(), ZoneId.systemDefault());
    }

}
