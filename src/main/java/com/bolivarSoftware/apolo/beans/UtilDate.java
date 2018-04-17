package com.bolivarSoftware.apolo.beans;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Damian Saez on 16/4/2018.
 */
@Component
public class UtilDate {

    public static DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");

    public static LocalDateTime convertToLocalDateTime(String date){
        return LocalDateTime.from(LocalDate.parse(date, formatterDateTime).atStartOfDay());
    }

    public static Date convertToDate(String date) throws ParseException {
        return formatterDate.parse(date);
    }

}
