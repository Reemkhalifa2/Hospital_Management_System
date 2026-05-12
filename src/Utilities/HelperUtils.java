package Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.UUID;

public class HelperUtils {
    //Null Check Methods
    public static Boolean isNull(Object obj){
        return obj == null;
    }

    public static Boolean isNull(String str){
        return str == null || str.isEmpty() ;
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    //String Validation Methods
    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }
    public static boolean isValidString(String str, int minLength) {
        return str != null && str.length() >= minLength;
    }
    public static boolean isValidString(String str, int minLength, int maxLength) {
        return str != null && str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        return str != null && str.matches(regex);
    }

    //ID Generation Methods
    public static UUID generateId(){
        return UUID.randomUUID();
    }
    
    public static String generateId(String prefix){
        return prefix+UUID.randomUUID();
    }

    public static String generateId(String prefix, int length){
        return prefix + UUID.randomUUID().toString().substring(0,length);
    }

    public static String generateId(String prefix, String suffix){
        return prefix + UUID.randomUUID() + suffix;
    }

    // Date Validation Method
    public static Boolean isValidDate(Date date){
        return date != null;
    }

    public static Boolean isValidDate(String dateStr){
        if (dateStr == null || dateStr.isEmpty()) {
            return false;
        }

        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static Boolean isValidDate(Date date, Date minDate, Date maxDate){
        return  date.after(minDate) && date.before(maxDate) ;
    }
















}
