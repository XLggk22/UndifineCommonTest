package my.test.java8;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.TimeZone;

public class DateTime {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("local date:" + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("local time:" + localTime);

        //当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local date time:" + localDateTime);
        //设置偏移时区
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.of("+0800"));
        System.out.println("local date time atOffset:" + offsetDateTime);
        //设置市区id
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("local date time atzoneId:" + zonedDateTime);


        //根据时区ID获取时间
        LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("local date time zoneId Tokyo:" + localDateTime2);


        //时间格式化
        String format = DateTimeFormatter.ISO_DATE_TIME.format(localDateTime2);
        System.out.println(format);
        String format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime2);
        System.out.println(format1);


        //LocalDateTime to Date
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime2.atZone(zoneId);
        Date from = Date.from(zdt.toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("localDateTime to Date :" + sdf.format(from));


//        ZonedDateTime parse = ZonedDateTime.parse("2020-10-10T16:44:51.618+08:00");
//        ZonedDateTime parse = LocalDateTime.now().atZone(ZoneId.systemDefault());
        ZonedDateTime parse = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = parse.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("北京时间: + "+ parse + "  --转--  东京时间：" + zonedDateTime1);

    }

//    public static String formatTimeZoneToCST(String utcStr,String format){
//        if(StringUtils.isEmpty(format)){
//            format ="yyyy-MM-dd HH:mm:ss";
//        }
//        if(StringUtils.isEmpty(utcStr)){
//            return StringUtils.EMPTY;
//        }
//        String result;
//        ZonedDateTime parse = ZonedDateTime.parse(utcStr);
//        ZonedDateTime zonedDateTime = parse.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));//中国标准时间 (北京)
//        result = zonedDateTime.format(DateTimeFormatter.ofPattern(format));
//        return result;
//    }
}
