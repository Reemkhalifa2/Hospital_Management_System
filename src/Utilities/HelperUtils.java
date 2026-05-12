package Utilities;

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












}
